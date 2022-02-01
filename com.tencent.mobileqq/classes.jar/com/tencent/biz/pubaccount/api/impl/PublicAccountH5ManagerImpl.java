package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountH5Manager;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPttImpl;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.aio.AioPicTransFileController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IPttTransProcessorHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppService;

public class PublicAccountH5ManagerImpl
  implements IPublicAccountH5Manager, INetEngineListener
{
  public static final String C2B_FIRE_CAMERC_DIR = "c2bCAM/";
  public static final String C2B_FIRE_PIC_DIR = "c2bPIC/";
  private static final String JS_PEER_UIN = "255";
  public static final String TAG = "PAH5Manager";
  private ArrayList<TransferRequest> JSPttList = new ArrayList();
  private QQAppInterface app;
  private ArrayList<HttpNetReq> downloadList = new ArrayList();
  TransProcessorHandler mTransProcessorHandler = new PublicAccountH5ManagerImpl.1(this);
  HashMap<Long, Bundle> mapDone = new HashMap();
  HashMap<String, Bundle> mapDownload = new HashMap();
  HashMap<Long, Bundle> mapStart = new HashMap();
  private IHttpEngineService netEngine;
  private String pUin;
  TroopMemberApiService troopMemberApiService;
  private ArrayList<TransferRequest> uploadList = new ArrayList();
  
  private boolean isJsPtt(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool3 = ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).checkIsJsPttClass(paramIHttpCommunicatorListener);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
      bool1 = bool2;
      if (paramIHttpCommunicatorListener.getFileStatus() != 1003L)
      {
        bool1 = bool2;
        if (paramIHttpCommunicatorListener.getLastFileStatus() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void removeDownloadloadByKey(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.downloadList.iterator();
    while (localIterator.hasNext())
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)localIterator.next();
      if (localHttpNetReq.mReqUrl.equals(paramString)) {
        localArrayList.add(localHttpNetReq);
      }
    }
    this.downloadList.removeAll(localArrayList);
  }
  
  public void cancelJsPttTask(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (paramLong == 0L) {
        return;
      }
      Iterator localIterator = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).getProcessMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (isJsPtt((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (paramLong == ((BaseTransProcessor)localObject).mUiRequest.mUniseq))
          {
            ((BaseTransProcessor)localObject).cancel();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("cancel JSPTT:");
              localStringBuilder.append(((BaseTransProcessor)localObject).mUiRequest.mUniseq);
              QLog.d("cancelpic", 2, localStringBuilder.toString());
            }
          }
        }
      }
    }
  }
  
  public void cancleAllTask()
  {
    Iterator localIterator;
    Object localObject;
    if (this.netEngine != null)
    {
      localIterator = this.downloadList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (HttpNetReq)localIterator.next();
        this.netEngine.cancelReq((NetReq)localObject);
      }
    }
    if ((ITransFileController)this.app.getRuntimeService(ITransFileController.class) != null)
    {
      localIterator = this.uploadList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (TransferRequest)localIterator.next();
        AioPicTransFileController.a(((TransferRequest)localObject).mPeerUin, ((TransferRequest)localObject).mUniseq);
      }
      localIterator = this.JSPttList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (TransferRequest)localIterator.next();
        cancelJsPttTask(((TransferRequest)localObject).mPeerUin, ((TransferRequest)localObject).mUniseq);
      }
    }
    this.mapStart.clear();
    this.mapDone.clear();
    this.mapDownload.clear();
    this.uploadList.clear();
    this.downloadList.clear();
  }
  
  public void downloadPtt(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    this.mTransProcessorHandler.addFilter(new Class[] { ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getJSPttDownloadProcessorClass() });
    ((ITransFileController)localObject).addHandle(this.mTransProcessorHandler);
    localObject = new TransferRequest();
    ((TransferRequest)localObject).mSelfUin = this.app.getAccount();
    ((TransferRequest)localObject).mPeerUin = "255";
    ((TransferRequest)localObject).mUinType = 9999;
    ((TransferRequest)localObject).mFileType = 32;
    ((TransferRequest)localObject).mUniseq = ((Math.random() * 1000.0D));
    ((TransferRequest)localObject).mIsUp = false;
    ((TransferRequest)localObject).mServerPath = str;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("c2bPTT/");
    localStringBuilder.append(str);
    localStringBuilder.append(".amr");
    ((TransferRequest)localObject).mOutFilePath = localStringBuilder.toString();
    if (new File(((TransferRequest)localObject).mOutFilePath).exists())
    {
      paramBundle.putString("pic_local_id", new PublicAccountH5AbilityPttImpl().getLocalIdForPTTDownLoad(((TransferRequest)localObject).mOutFilePath));
      this.troopMemberApiService.a(26, paramBundle);
      return;
    }
    ((TransferRequest)localObject).mIsSelfSend = true;
    ((TransferRequest)localObject).mDbRecVersion = 5;
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
    this.mapStart.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.mapDone.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.JSPttList.add(localObject);
  }
  
  public void init(AppService paramAppService, AppInterface paramAppInterface)
  {
    this.app = ((QQAppInterface)paramAppInterface);
    this.troopMemberApiService = ((TroopMemberApiService)paramAppService);
    this.netEngine = ((IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject1;
    Bundle localBundle;
    if ((paramNetResp != null) && ((paramNetResp.mReq instanceof HttpNetReq)))
    {
      localObject1 = (HttpNetReq)paramNetResp.mReq;
      if ((paramNetResp.mResult == 0) || (paramNetResp.mResult == 1))
      {
        localBundle = (Bundle)this.mapDownload.remove(((HttpNetReq)localObject1).mReqUrl);
        removeDownloadloadByKey(((HttpNetReq)localObject1).mReqUrl);
        if (localBundle != null) {
          if ((((HttpNetReq)localObject1).mReqUrl != null) && (paramNetResp.mResult == 0))
          {
            paramNetResp = ((HttpNetReq)localObject1).mReqUrl.split("/");
            if (paramNetResp.length >= 2)
            {
              localBundle.putString("pic_local_id", paramNetResp[(paramNetResp.length - 2)]);
              localObject1 = ((HttpNetReq)localObject1).mOutPath;
              if ((localObject1 != null) && (!"".equals(localObject1)))
              {
                paramNetResp = new File((String)localObject1);
                if (paramNetResp.exists()) {
                  localBundle.putString("pic_local_path", (String)localObject1);
                }
              }
            }
          }
        }
      }
    }
    try
    {
      String str = FileUtils.estimateFileType((String)localObject1);
      int i = ((String)localObject1).lastIndexOf(".");
      if (i != -1)
      {
        Object localObject2 = ((String)localObject1).substring(i + 1);
        if ((str != null) && (!str.equals(localObject2)))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(((String)localObject1).substring(0, i));
          ((StringBuilder)localObject2).append(".");
          ((StringBuilder)localObject2).append(str);
          localObject1 = ((StringBuilder)localObject2).toString();
          if (paramNetResp.renameTo(new File((String)localObject1))) {
            localBundle.putString("pic_local_path", (String)localObject1);
          }
        }
      }
      this.troopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception paramNetResp)
    {
      label290:
      break label290;
    }
    localBundle.putString("pic_local_id", "-1");
    this.troopMemberApiService.a(26, localBundle);
    return;
    localBundle.putString("pic_local_id", "-1");
    this.troopMemberApiService.a(26, localBundle);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  void removeJSPttByKey(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.JSPttList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      if (localTransferRequest.mUniseq == paramLong) {
        localArrayList.add(localTransferRequest);
      }
    }
    this.JSPttList.removeAll(localArrayList);
  }
  
  void removeUploadByKey(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.uploadList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      if (localTransferRequest.mUniseq == paramLong) {
        localArrayList.add(localTransferRequest);
      }
    }
    this.uploadList.removeAll(localArrayList);
  }
  
  public void startDownloadPic(Bundle paramBundle)
  {
    if (HttpUtil.getNetWorkType() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.troopMemberApiService.a(26, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_server_id");
    paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = str;
    localHttpNetReq.mExcuteTimeLimit = 180000L;
    if (localHttpNetReq.mReqUrl != null)
    {
      Object localObject1 = localHttpNetReq.mReqUrl.split("/");
      if (localObject1.length >= 2)
      {
        localObject1 = localObject1[(localObject1.length - 2)];
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject2).append("c2bPIC/");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(".png");
        localHttpNetReq.mOutPath = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject2).append("c2bPIC/");
        Object localObject3 = new File(((StringBuilder)localObject2).toString());
        localObject2 = new ArrayList();
        localObject3 = ((File)localObject3).listFiles();
        if (localObject3 != null)
        {
          int k = 0;
          int i = 0;
          int j;
          while (i < localObject3.length)
          {
            if (!localObject3[i].isDirectory())
            {
              j = localObject3[i].getName().lastIndexOf(".");
              if (j != -1) {
                ((List)localObject2).add(localObject3[i].getName().substring(0, j));
              }
            }
            i += 1;
          }
          i = 0;
          for (;;)
          {
            j = k;
            if (i >= ((List)localObject2).size()) {
              break;
            }
            if (((String)localObject1).equalsIgnoreCase((String)((List)localObject2).get(i)))
            {
              j = 1;
              break;
            }
            i += 1;
          }
          if (j != 0)
          {
            paramBundle.putString("pic_local_id", (String)localObject1);
            this.troopMemberApiService.a(26, paramBundle);
            return;
          }
        }
        localObject1 = this.netEngine;
        if (localObject1 != null)
        {
          ((IHttpEngineService)localObject1).sendReq(localHttpNetReq);
          this.mapDownload.put(str, paramBundle);
          this.downloadList.add(localHttpNetReq);
          if (paramBundle.getInt("is_showProgress_tips") == 1) {
            this.troopMemberApiService.a(25, paramBundle);
          }
          return;
        }
      }
    }
    paramBundle.putString("pic_local_id", "-1");
    this.troopMemberApiService.a(26, paramBundle);
  }
  
  public void startUploadPic(Bundle paramBundle)
  {
    if (HttpUtil.getNetWorkType() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.troopMemberApiService.a(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.pUin = paramBundle.getString("pic_puin");
    ITransFileController localITransFileController = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    this.mTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    localITransFileController.addHandle(this.mTransProcessorHandler);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mCommandId = 10;
    localTransferRequest.mLocalPath = str;
    localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mFileType = 24;
    localTransferRequest.mRichTag = "PAJSSDKPicUploadProcess";
    localITransFileController.transferAsync(localTransferRequest);
    this.mapStart.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
    this.mapDone.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
    this.uploadList.add(localTransferRequest);
  }
  
  public void uploadPtt(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_local_path");
    Object localObject = (ITransFileController)this.app.getRuntimeService(ITransFileController.class);
    this.mTransProcessorHandler.addFilter(new Class[] { ((IPttTransProcessorHelper)QRoute.api(IPttTransProcessorHelper.class)).getJSPttUpProcessorClass() });
    ((ITransFileController)localObject).addHandle(this.mTransProcessorHandler);
    localObject = new TransferRequest();
    ((TransferRequest)localObject).mSelfUin = this.app.getAccount();
    ((TransferRequest)localObject).mPeerUin = "255";
    ((TransferRequest)localObject).mUinType = 9999;
    ((TransferRequest)localObject).mFileType = 32;
    ((TransferRequest)localObject).mUniseq = ((Math.random() * 1000000.0D));
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mLocalPath = str;
    ((TransferRequest)localObject).mBusiType = 102;
    ((TransferRequest)localObject).mPttCompressFinish = true;
    ((TransferRequest)localObject).mPttUploadPanel = 2;
    ((ITransFileController)this.app.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
    this.mapStart.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.mapDone.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.JSPttList.add(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountH5ManagerImpl
 * JD-Core Version:    0.7.0.1
 */