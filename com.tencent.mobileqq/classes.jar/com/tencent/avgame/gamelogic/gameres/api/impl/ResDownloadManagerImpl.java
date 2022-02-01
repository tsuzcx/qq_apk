package com.tencent.avgame.gamelogic.gameres.api.impl;

import android.text.TextUtils;
import com.tencent.avgame.gamelogic.gameres.ResDownloadHandler;
import com.tencent.avgame.gamelogic.gameres.ResDownloadHandler.RDHandler;
import com.tencent.avgame.gamelogic.gameres.api.IResDownloadManager;
import com.tencent.avgame.gamelogic.gameres.api.IResDownloadManager.DownloadParam;
import com.tencent.avgame.gamelogic.gameres.api.IResDownloadManager.IResDownloadListener;
import com.tencent.avgame.util.ResUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.image.Utils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ResDownloadManagerImpl
  implements IResDownloadManager
{
  public static final String TAG = "ResDownloadManager";
  AppInterface app;
  private List<IResDownloadManager.IResDownloadListener> mDownloadListeners = new Vector();
  private IHttpEngineService mNetEngine;
  Set<String> mPicsMd5Set = Collections.synchronizedSet(new HashSet());
  ResDownloadHandler mRDHander;
  
  public ResDownloadManagerImpl() {}
  
  public ResDownloadManagerImpl(AppInterface paramAppInterface)
  {
    init(paramAppInterface);
  }
  
  private void init(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
    this.mNetEngine = ((IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    this.mRDHander = new ResDownloadHandler();
  }
  
  private boolean isNeedDownload(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    return this.mRDHander.a(this.app, paramDownloadParam.jdField_a_of_type_Int).b(paramDownloadParam);
  }
  
  private void retry(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retry|");
      ((StringBuilder)localObject).append(paramDownloadParam);
      QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = this;
    ((HttpNetReq)localObject).mReqUrl = paramDownloadParam.jdField_a_of_type_JavaLangString;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = this.mRDHander.a(this.app, paramDownloadParam.jdField_a_of_type_Int).b(paramDownloadParam);
    ((HttpNetReq)localObject).mPrioty = 1;
    ((HttpNetReq)localObject).setUserData(paramDownloadParam);
    ((HttpNetReq)localObject).mSupportBreakResume = true;
    this.mNetEngine.sendReq((NetReq)localObject);
  }
  
  private String unCompressZipFile(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unCompressZipFile|:");
      ((StringBuilder)localObject).append(paramDownloadParam);
      QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mRDHander.a(this.app, paramDownloadParam.jdField_a_of_type_Int).a(paramDownloadParam);
    if (!FileUtils.fileExists((String)localObject)) {
      try
      {
        FileUtils.uncompressZip(this.mRDHander.a(this.app, paramDownloadParam.jdField_a_of_type_Int).b(paramDownloadParam), (String)localObject, false);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("unCompressZipFile success.destDir=");
          localStringBuilder1.append((String)localObject);
          QLog.d("ResDownloadManager", 2, localStringBuilder1.toString());
          return localObject;
        }
      }
      catch (Exception localException)
      {
        FileUtils.deleteDirectory((String)localObject);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("unCompressZipFile failed,");
        localStringBuilder2.append(paramDownloadParam);
        localStringBuilder2.append(" , ");
        localStringBuilder2.append(localException.getMessage());
        QLog.d("ResDownloadManager", 1, localStringBuilder2.toString(), localException);
      }
    }
    return localObject;
  }
  
  public void addListener(IResDownloadManager.IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener == null) {
      return;
    }
    synchronized (this.mDownloadListeners)
    {
      if (!this.mDownloadListeners.contains(paramIResDownloadListener)) {
        this.mDownloadListeners.add(paramIResDownloadListener);
      }
      return;
    }
  }
  
  public boolean download(IResDownloadManager.DownloadParam paramDownloadParam)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("download|");
      ((StringBuilder)localObject1).append(paramDownloadParam);
      QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.mRDHander.a(this.app, paramDownloadParam.jdField_a_of_type_Int);
    bool = TextUtils.isEmpty(paramDownloadParam.jdField_b_of_type_JavaLangString);
    int k = 0;
    int j = 0;
    if ((!bool) && (this.mPicsMd5Set.contains(paramDownloadParam.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("no need to download, task is underway.|");
        ((StringBuilder)localObject1).append(paramDownloadParam);
        QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    if (!isNeedDownload(paramDownloadParam))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("no need to download, file is exists.|");
        ((StringBuilder)???).append(paramDownloadParam);
        QLog.i("ResDownloadManager", 2, ((StringBuilder)???).toString());
      }
      if (paramDownloadParam.jdField_a_of_type_Boolean)
      {
        ??? = ((ResDownloadHandler.RDHandler)localObject1).a(paramDownloadParam);
        if ((FileUtils.fileExists((String)???)) && (!((ResDownloadHandler.RDHandler)localObject1).a(paramDownloadParam, true)))
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("unzipDir has been changed. |");
            ((StringBuilder)localObject1).append(paramDownloadParam);
            QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject1).toString());
          }
          FileUtils.deleteDirectory((String)???);
        }
        localObject1 = unCompressZipFile(paramDownloadParam);
      }
      else
      {
        localObject1 = ((ResDownloadHandler.RDHandler)localObject1).b(paramDownloadParam);
      }
      if (new File((String)localObject1).exists()) {
        i = 0;
      }
      synchronized (this.mDownloadListeners)
      {
        if (j < this.mDownloadListeners.size())
        {
          IResDownloadManager.IResDownloadListener localIResDownloadListener = (IResDownloadManager.IResDownloadListener)this.mDownloadListeners.get(j);
          if (localIResDownloadListener == null) {
            break label623;
          }
          localIResDownloadListener.a(paramDownloadParam.jdField_a_of_type_JavaLangString, paramDownloadParam.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramDownloadParam.jdField_a_of_type_JavaLangObject);
          break label623;
        }
        if (paramDownloadParam.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager$IResDownloadListener != null) {
          paramDownloadParam.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager$IResDownloadListener.a(paramDownloadParam.jdField_a_of_type_JavaLangString, paramDownloadParam.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramDownloadParam.jdField_a_of_type_JavaLangObject);
        }
        return true;
      }
    }
    this.mPicsMd5Set.add(paramDownloadParam.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("download send request ,url = ");
      ((StringBuilder)???).append(paramDownloadParam.jdField_a_of_type_JavaLangString);
      QLog.i("ResDownloadManager", 2, ((StringBuilder)???).toString());
    }
    ??? = new HttpNetReq();
    ((HttpNetReq)???).mCallback = this;
    ((HttpNetReq)???).mReqUrl = paramDownloadParam.jdField_a_of_type_JavaLangString;
    ((HttpNetReq)???).mHttpMethod = 0;
    ((HttpNetReq)???).mOutPath = ((ResDownloadHandler.RDHandler)localObject1).b(paramDownloadParam);
    ((HttpNetReq)???).mPrioty = 1;
    ((HttpNetReq)???).setUserData(paramDownloadParam);
    ((HttpNetReq)???).mSupportBreakResume = true;
    this.mNetEngine.sendReq((NetReq)???);
    paramDownloadParam = this.mDownloadListeners;
    i = k;
    for (;;)
    {
      try
      {
        if (i < this.mDownloadListeners.size())
        {
          localObject1 = (IResDownloadManager.IResDownloadListener)this.mDownloadListeners.get(i);
          if (localObject1 == null) {
            break label630;
          }
          ((IResDownloadManager.IResDownloadListener)localObject1).a();
          break label630;
        }
        return true;
      }
      finally {}
      for (;;)
      {
        throw localObject2;
      }
      label623:
      j += 1;
      break;
      label630:
      i += 1;
    }
  }
  
  public boolean download(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    return download(paramString1, paramString2, paramString3, paramBoolean, paramInt, null);
  }
  
  public boolean download(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return download(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean download(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, IResDownloadManager.IResDownloadListener paramIResDownloadListener)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download|");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    IResDownloadManager.DownloadParam localDownloadParam = new IResDownloadManager.DownloadParam();
    localDownloadParam.jdField_a_of_type_Int = paramInt;
    localDownloadParam.jdField_a_of_type_JavaLangString = paramString1;
    localDownloadParam.jdField_b_of_type_Int = 2;
    Object localObject = paramString3;
    if (paramString3 == null) {
      localObject = "";
    }
    localDownloadParam.c = ((String)localObject);
    localDownloadParam.jdField_a_of_type_Boolean = paramBoolean;
    localDownloadParam.jdField_a_of_type_JavaLangObject = paramObject;
    localDownloadParam.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager$IResDownloadListener = paramIResDownloadListener;
    if (TextUtils.isEmpty(paramString2))
    {
      localDownloadParam.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
      localDownloadParam.jdField_b_of_type_Boolean = false;
    }
    else
    {
      localDownloadParam.jdField_b_of_type_JavaLangString = paramString2;
      localDownloadParam.jdField_b_of_type_Boolean = true;
    }
    return download(localDownloadParam);
  }
  
  public boolean isFileExist(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = Utils.Crc64String(paramString1);
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    paramString3 = new IResDownloadManager.DownloadParam();
    paramString3.jdField_a_of_type_JavaLangString = paramString1;
    paramString3.jdField_b_of_type_JavaLangString = str;
    paramString3.jdField_a_of_type_Boolean = paramBoolean;
    paramString3.c = paramString2;
    paramString3.jdField_a_of_type_Int = paramInt;
    return this.mRDHander.a(this.app, paramString3.jdField_a_of_type_Int).a(paramString3);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    init((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void onResp(NetResp paramNetResp)
  {
    int i = paramNetResp.mResult;
    int k = 0;
    boolean bool1;
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    Object localObject1 = new File(localHttpNetReq.mOutPath);
    Object localObject2 = localHttpNetReq.getUserData();
    int j = paramNetResp.mErrCode;
    Object localObject3;
    if (paramNetResp.mErrDesc == null) {
      localObject3 = "0";
    } else {
      localObject3 = paramNetResp.mErrDesc;
    }
    Object localObject4 = null;
    Object localObject6;
    if ((localObject2 != null) && ((localObject2 instanceof IResDownloadManager.DownloadParam)))
    {
      localObject5 = (IResDownloadManager.DownloadParam)localObject2;
      localObject2 = this.mRDHander.a(this.app, ((IResDownloadManager.DownloadParam)localObject5).jdField_a_of_type_Int);
      localObject4 = ((IResDownloadManager.DownloadParam)localObject5).jdField_b_of_type_JavaLangString;
      if (bool1)
      {
        boolean bool2 = bool1;
        i = j;
        if (((IResDownloadManager.DownloadParam)localObject5).jdField_b_of_type_Boolean)
        {
          if (!((ResDownloadHandler.RDHandler)localObject2).c((IResDownloadManager.DownloadParam)localObject5))
          {
            j = -6103066;
            ((File)localObject1).delete();
            bool1 = false;
          }
          bool2 = bool1;
          i = j;
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("onResp.md5 verify suc|");
            ((StringBuilder)localObject6).append(bool1);
            ((StringBuilder)localObject6).append("|");
            ((StringBuilder)localObject6).append(localObject5);
            QLog.i("ResDownloadManager", 1, ((StringBuilder)localObject6).toString());
            i = j;
            bool2 = bool1;
          }
        }
        localObject6 = ((ResDownloadHandler.RDHandler)localObject2).a((IResDownloadManager.DownloadParam)localObject5);
        bool1 = bool2;
        localObject2 = localObject1;
        j = i;
        if (bool2)
        {
          bool1 = bool2;
          localObject2 = localObject1;
          j = i;
          if (((IResDownloadManager.DownloadParam)localObject5).jdField_a_of_type_Boolean)
          {
            FileUtils.deleteDirectory((String)localObject6);
            unCompressZipFile((IResDownloadManager.DownloadParam)localObject5);
            localObject1 = new File((String)localObject6);
            bool2 = ((File)localObject1).exists();
            if (!bool2) {
              i = 2;
            }
            bool1 = bool2;
            localObject2 = localObject1;
            j = i;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("onResp.unCompressZipFile suc|");
              ((StringBuilder)localObject2).append(bool2);
              ((StringBuilder)localObject2).append("|");
              ((StringBuilder)localObject2).append(localObject5);
              QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject2).toString());
              j = i;
              localObject2 = localObject1;
              bool1 = bool2;
            }
          }
        }
        if (this.mPicsMd5Set.contains(localObject4)) {
          this.mPicsMd5Set.remove(localObject4);
        }
        localObject1 = localObject2;
        i = j;
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onResp result|");
          ((StringBuilder)localObject2).append(paramNetResp.mResult);
          ((StringBuilder)localObject2).append("|errCode:");
          ((StringBuilder)localObject2).append(3);
          ((StringBuilder)localObject2).append("|errDesc:");
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append("|params:");
          ((StringBuilder)localObject2).append(localObject5);
          QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject2).toString());
        }
        if (((File)localObject1).exists()) {
          ((File)localObject1).delete();
        }
        if (((IResDownloadManager.DownloadParam)localObject5).jdField_b_of_type_Int > 0)
        {
          ((IResDownloadManager.DownloadParam)localObject5).jdField_b_of_type_Int -= 1;
          retry((IResDownloadManager.DownloadParam)localObject5);
          i = 3;
          j = 1;
          break label609;
        }
        if (this.mPicsMd5Set.contains(localObject4)) {
          this.mPicsMd5Set.remove(localObject4);
        }
        i = 3;
      }
      j = 0;
      label609:
      localObject2 = localObject1;
      localObject1 = localObject5;
    }
    else
    {
      ((File)localObject1).delete();
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("onResp userdata|");
        ((StringBuilder)localObject5).append(localObject2);
        QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject5).toString());
      }
      localObject2 = localObject1;
      localObject1 = null;
      int m = 0;
      i = j;
      j = m;
    }
    if (QLog.isColorLevel())
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("onResp url:");
      ((StringBuilder)localObject5).append(localHttpNetReq.mReqUrl);
      ((StringBuilder)localObject5).append(" result:");
      ((StringBuilder)localObject5).append(paramNetResp.mResult);
      ((StringBuilder)localObject5).append(" errCode:");
      ((StringBuilder)localObject5).append(i);
      ((StringBuilder)localObject5).append(" md5:");
      ((StringBuilder)localObject5).append((String)localObject4);
      QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject5).toString());
    }
    if (j != 0) {
      return;
    }
    Object localObject5 = this.mDownloadListeners;
    j = k;
    for (;;)
    {
      try
      {
        if (j < this.mDownloadListeners.size())
        {
          localObject6 = (IResDownloadManager.IResDownloadListener)this.mDownloadListeners.get(j);
          if ((localObject6 != null) && (localObject1 != null)) {
            ((IResDownloadManager.IResDownloadListener)localObject6).a(localHttpNetReq.mReqUrl, (String)localObject4, i, ((File)localObject2).getAbsolutePath(), ((IResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangObject);
          }
        }
        else
        {
          if ((localObject1 != null) && (((IResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager$IResDownloadListener != null)) {
            ((IResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager$IResDownloadListener.a(localHttpNetReq.mReqUrl, (String)localObject4, i, ((File)localObject2).getAbsolutePath(), ((IResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangObject);
          }
          if ((!bool1) && (localObject1 != null))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("reportDownloadResult, params=");
            ((StringBuilder)localObject2).append(localObject1);
            ((StringBuilder)localObject2).append(", errCode=");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(", errDesc=");
            ((StringBuilder)localObject2).append((String)localObject3);
            ((StringBuilder)localObject2).append(", httpCode=");
            ((StringBuilder)localObject2).append(paramNetResp.mHttpCode);
            QLog.d("ResDownloadManager", 1, ((StringBuilder)localObject2).toString());
            if ((paramNetResp.mRespProperties != null) && (paramNetResp.mRespProperties.containsKey("netresp_param_reason"))) {
              localObject2 = (String)paramNetResp.mRespProperties.get("netresp_param_reason");
            } else {
              localObject2 = "0";
            }
            localObject4 = new HashMap();
            ((HashMap)localObject4).put("param_FailCode", String.valueOf(i));
            ((HashMap)localObject4).put("url", ResUtil.a(((IResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangString));
            ((HashMap)localObject4).put("md5", ((IResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_JavaLangString);
            ((HashMap)localObject4).put("err_desc", localObject3);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((IResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_Int);
            ((StringBuilder)localObject3).append("");
            ((HashMap)localObject4).put("type", ((StringBuilder)localObject3).toString());
            ((HashMap)localObject4).put("endFix", ((IResDownloadManager.DownloadParam)localObject1).c);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((IResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_Int);
            ((StringBuilder)localObject3).append("");
            ((HashMap)localObject4).put("retryCount", ((StringBuilder)localObject3).toString());
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((IResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_Boolean);
            ((StringBuilder)localObject3).append("");
            ((HashMap)localObject4).put("needUnzip", ((StringBuilder)localObject3).toString());
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((IResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_Boolean);
            ((StringBuilder)localObject3).append("");
            ((HashMap)localObject4).put("needVerify", ((StringBuilder)localObject3).toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramNetResp.mHttpCode);
            ((StringBuilder)localObject1).append("");
            ((HashMap)localObject4).put("httpCode", ((StringBuilder)localObject1).toString());
            ((HashMap)localObject4).put("netresp_param_reason", localObject2);
            StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(this.app.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject4, "", false);
          }
          return;
        }
      }
      finally
      {
        continue;
        throw paramNetResp;
        continue;
        j += 1;
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    String str1;
    String str2;
    int i;
    int j;
    if (paramNetReq != null)
    {
      if (!(paramNetReq instanceof HttpNetReq)) {
        return;
      }
      str1 = ((HttpNetReq)paramNetReq).mReqUrl;
      paramNetReq = paramNetReq.getUserData();
      if ((paramNetReq != null) && ((paramNetReq instanceof IResDownloadManager.DownloadParam)))
      {
        paramNetReq = (IResDownloadManager.DownloadParam)paramNetReq;
        str2 = paramNetReq.jdField_b_of_type_JavaLangString;
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("onUpdateProgeress|curOffset=");
          ((StringBuilder)???).append(paramLong1);
          ((StringBuilder)???).append("|totalLen=");
          ((StringBuilder)???).append(paramLong2);
          ((StringBuilder)???).append("|");
          ((StringBuilder)???).append(paramNetReq);
          QLog.i("ResDownloadManager", 2, ((StringBuilder)???).toString());
        }
        if (paramNetReq.jdField_a_of_type_Boolean) {
          i = 90;
        } else {
          i = 100;
        }
        j = 0;
        if (paramLong2 > 0L) {
          i = (int)(paramLong1 * i / paramLong2);
        } else {
          i = 0;
        }
      }
    }
    for (;;)
    {
      synchronized (this.mDownloadListeners)
      {
        if (j < this.mDownloadListeners.size())
        {
          IResDownloadManager.IResDownloadListener localIResDownloadListener = (IResDownloadManager.IResDownloadListener)this.mDownloadListeners.get(j);
          if (localIResDownloadListener == null) {
            break label261;
          }
          localIResDownloadListener.a(str1, str2, i);
          break label261;
        }
        if (paramNetReq.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager$IResDownloadListener != null)
        {
          paramNetReq.jdField_a_of_type_ComTencentAvgameGamelogicGameresApiIResDownloadManager$IResDownloadListener.a(str1, str2, i);
          return;
        }
      }
      return;
      label261:
      j += 1;
    }
  }
  
  public void removeListener(IResDownloadManager.IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener == null) {
      return;
    }
    synchronized (this.mDownloadListeners)
    {
      this.mDownloadListeners.remove(paramIResDownloadListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.api.impl.ResDownloadManagerImpl
 * JD-Core Version:    0.7.0.1
 */