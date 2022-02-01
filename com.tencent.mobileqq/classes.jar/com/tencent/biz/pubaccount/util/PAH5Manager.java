package com.tencent.biz.pubaccount.util;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPttImpl;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.aio.AioPicTransFileController;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.JSPttDownloadProcessor;
import com.tencent.mobileqq.transfile.JSPttUploadProcessor;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
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

public class PAH5Manager
  implements INetEngineListener
{
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new PAH5Manager.1(this);
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<TransferRequest> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<HttpNetReq> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Long, Bundle> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<TransferRequest> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<String, Bundle> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public PAH5Manager(TroopMemberApiService paramTroopMemberApiService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)paramQQAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
  }
  
  private void a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      HttpNetReq localHttpNetReq = (HttpNetReq)localIterator.next();
      if (localHttpNetReq.mReqUrl.equals(paramString)) {
        localArrayList.add(localHttpNetReq);
      }
    }
    this.jdField_b_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  private boolean a(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null) {
      if (!(paramIHttpCommunicatorListener instanceof JSPttUploadProcessor))
      {
        bool1 = bool2;
        if (!(paramIHttpCommunicatorListener instanceof JSPttDownloadProcessor)) {}
      }
      else
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
    }
    return bool1;
  }
  
  public void a()
  {
    Iterator localIterator;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService != null)
    {
      localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (HttpNetReq)localIterator.next();
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.cancelReq((NetReq)localObject);
      }
    }
    if ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class) != null)
    {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (TransferRequest)localIterator.next();
        AioPicTransFileController.a(((TransferRequest)localObject).mPeerUin, ((TransferRequest)localObject).mUniseq);
      }
      localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (TransferRequest)localIterator.next();
        a(((TransferRequest)localObject).mPeerUin, ((TransferRequest)localObject).mUniseq);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
  }
  
  void a(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      if (localTransferRequest.mUniseq == paramLong) {
        localArrayList.add(localTransferRequest);
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void a(Bundle paramBundle)
  {
    if (HttpUtil.getNetWorkType() == 0)
    {
      paramBundle.putLong("uniseq", 0L);
      paramBundle.putString("pic_server_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(24, paramBundle);
      return;
    }
    String str = paramBundle.getString("pic_local_path");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("pic_puin");
    ITransFileController localITransFileController = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    localITransFileController.addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mCommandId = 10;
    localTransferRequest.mLocalPath = str;
    localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mFileType = 24;
    localTransferRequest.mRichTag = "PAJSSDKPicUploadProcess";
    localITransFileController.transferAsync(localTransferRequest);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localTransferRequest.mUniseq), paramBundle);
    this.jdField_a_of_type_JavaUtilArrayList.add(localTransferRequest);
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).getProcessMap().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (a((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (paramLong == ((BaseTransProcessor)localObject).mUiRequest.mUniseq))
          {
            ((BaseTransProcessor)localObject).cancel();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            }
          }
        }
      }
    }
  }
  
  void b(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TransferRequest localTransferRequest = (TransferRequest)localIterator.next();
      if (localTransferRequest.mUniseq == paramLong) {
        localArrayList.add(localTransferRequest);
      }
    }
    this.jdField_c_of_type_JavaUtilArrayList.removeAll(localArrayList);
  }
  
  public void b(Bundle paramBundle)
  {
    int k = 0;
    if (HttpUtil.getNetWorkType() == 0)
    {
      paramBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
    }
    do
    {
      return;
      String str = paramBundle.getString("pic_server_id");
      paramBundle.putInt("seq", paramBundle.getInt("seq", -1));
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = this;
      localHttpNetReq.mReqUrl = str;
      localHttpNetReq.mExcuteTimeLimit = 180000L;
      if (localHttpNetReq.mReqUrl == null) {
        break;
      }
      Object localObject1 = localHttpNetReq.mReqUrl.split("/");
      if (localObject1.length < 2) {
        break;
      }
      localObject1 = localObject1[(localObject1.length - 2)];
      localHttpNetReq.mOutPath = (AppConstants.SDCARD_PATH + "c2bPIC/" + (String)localObject1 + ".png");
      Object localObject2 = new File(AppConstants.SDCARD_PATH + "c2bPIC/");
      ArrayList localArrayList = new ArrayList();
      localObject2 = ((File)localObject2).listFiles();
      if (localObject2 != null)
      {
        int i = 0;
        int j;
        while (i < localObject2.length)
        {
          if (!localObject2[i].isDirectory())
          {
            j = localObject2[i].getName().lastIndexOf(".");
            if (j != -1) {
              localArrayList.add(localObject2[i].getName().substring(0, j));
            }
          }
          i += 1;
        }
        i = 0;
        for (;;)
        {
          j = k;
          if (i < localArrayList.size())
          {
            if (((String)localObject1).equalsIgnoreCase((String)localArrayList.get(i))) {
              j = 1;
            }
          }
          else
          {
            if (j == 0) {
              break;
            }
            paramBundle.putString("pic_local_id", (String)localObject1);
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
            return;
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq(localHttpNetReq);
      this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
      this.jdField_b_of_type_JavaUtilArrayList.add(localHttpNetReq);
    } while (paramBundle.getInt("is_showProgress_tips") != 1);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(25, paramBundle);
    return;
    paramBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_local_path");
    Object localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { JSPttUploadProcessor.class });
    ((ITransFileController)localObject).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    localObject = new TransferRequest();
    ((TransferRequest)localObject).mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((TransferRequest)localObject).mPeerUin = "255";
    ((TransferRequest)localObject).mUinType = 9999;
    ((TransferRequest)localObject).mFileType = 32;
    ((TransferRequest)localObject).mUniseq = ((Math.random() * 1000000.0D));
    ((TransferRequest)localObject).mIsUp = true;
    ((TransferRequest)localObject).mLocalPath = str;
    ((TransferRequest)localObject).mBusiType = 102;
    ((TransferRequest)localObject).mPttCompressFinish = true;
    ((TransferRequest)localObject).mPttUploadPanel = 2;
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void d(Bundle paramBundle)
  {
    String str = paramBundle.getString("pic_server_id");
    Object localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { JSPttDownloadProcessor.class });
    ((ITransFileController)localObject).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    localObject = new TransferRequest();
    ((TransferRequest)localObject).mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    ((TransferRequest)localObject).mPeerUin = "255";
    ((TransferRequest)localObject).mUinType = 9999;
    ((TransferRequest)localObject).mFileType = 32;
    ((TransferRequest)localObject).mUniseq = ((Math.random() * 1000.0D));
    ((TransferRequest)localObject).mIsUp = false;
    ((TransferRequest)localObject).mServerPath = str;
    ((TransferRequest)localObject).mOutFilePath = (AppConstants.SDCARD_PATH + "c2bPTT/" + str + ".amr");
    if (new File(((TransferRequest)localObject).mOutFilePath).exists())
    {
      paramBundle.putString("pic_local_id", new PublicAccountH5AbilityPttImpl().getLocalIdForPTTDownLoad(((TransferRequest)localObject).mOutFilePath));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, paramBundle);
      return;
    }
    ((TransferRequest)localObject).mIsSelfSend = true;
    ((TransferRequest)localObject).mDbRecVersion = 5;
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(((TransferRequest)localObject).mUniseq), paramBundle);
    this.jdField_c_of_type_JavaUtilArrayList.add(localObject);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject;
    Bundle localBundle;
    if ((paramNetResp != null) && ((paramNetResp.mReq instanceof HttpNetReq)))
    {
      localObject = (HttpNetReq)paramNetResp.mReq;
      if ((paramNetResp.mResult == 0) || (paramNetResp.mResult == 1))
      {
        localBundle = (Bundle)this.jdField_c_of_type_JavaUtilHashMap.remove(((HttpNetReq)localObject).mReqUrl);
        a(((HttpNetReq)localObject).mReqUrl);
        if (localBundle != null)
        {
          if ((((HttpNetReq)localObject).mReqUrl == null) || (paramNetResp.mResult != 0)) {
            break label296;
          }
          paramNetResp = ((HttpNetReq)localObject).mReqUrl.split("/");
          if (paramNetResp.length < 2) {
            break label296;
          }
          localBundle.putString("pic_local_id", paramNetResp[(paramNetResp.length - 2)]);
          localObject = ((HttpNetReq)localObject).mOutPath;
          if ((localObject == null) || ("".equals(localObject))) {
            break label296;
          }
          paramNetResp = new File((String)localObject);
          if (!paramNetResp.exists()) {
            break label296;
          }
          localBundle.putString("pic_local_path", (String)localObject);
        }
      }
    }
    try
    {
      String str1 = FileUtils.b((String)localObject);
      int i = ((String)localObject).lastIndexOf(".");
      if (i != -1)
      {
        String str2 = ((String)localObject).substring(i + 1);
        if ((str1 != null) && (!str1.equals(str2)))
        {
          localObject = ((String)localObject).substring(0, i) + "." + str1;
          if (paramNetResp.renameTo(new File((String)localObject))) {
            localBundle.putString("pic_local_path", (String)localObject);
          }
        }
      }
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    catch (Exception paramNetResp)
    {
      localBundle.putString("pic_local_id", "-1");
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
      return;
    }
    label296:
    localBundle.putString("pic_local_id", "-1");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(26, localBundle);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PAH5Manager
 * JD-Core Version:    0.7.0.1
 */