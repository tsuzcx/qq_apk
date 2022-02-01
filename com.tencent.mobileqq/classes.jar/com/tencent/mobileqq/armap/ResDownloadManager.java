package com.tencent.mobileqq.armap;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
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
import mqq.manager.Manager;

public class ResDownloadManager
  implements INetEngineListener, Manager
{
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ResDownloadHandler jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler;
  private IHttpEngineService jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService;
  private List<ResDownloadManager.IResDownloadListener> jdField_a_of_type_JavaUtilList = new Vector();
  Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public ResDownloadManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService = ((IHttpEngineService)paramAppInterface.getRuntimeService(IHttpEngineService.class, "all"));
    this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler = new ResDownloadHandler();
  }
  
  private String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unCompressZipFile|:");
      ((StringBuilder)localObject).append(paramDownloadParam);
      QLog.i("ResDownloadManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).a(paramDownloadParam);
    if (!FileUtils.fileExists((String)localObject)) {
      try
      {
        FileUtils.uncompressZip(this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).b(paramDownloadParam), (String)localObject, false);
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
  
  private void a(ResDownloadManager.DownloadParam paramDownloadParam)
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
    ((HttpNetReq)localObject).mOutPath = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).b(paramDownloadParam);
    ((HttpNetReq)localObject).mPrioty = 1;
    ((HttpNetReq)localObject).setUserData(paramDownloadParam);
    ((HttpNetReq)localObject).mSupportBreakResume = true;
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq((NetReq)localObject);
  }
  
  private boolean b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    return this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).a(paramDownloadParam);
  }
  
  public void a(ResDownloadManager.IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramIResDownloadListener)) {
        this.jdField_a_of_type_JavaUtilList.add(paramIResDownloadListener);
      }
      return;
    }
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam)
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int);
    bool = TextUtils.isEmpty(paramDownloadParam.jdField_b_of_type_JavaLangString);
    int k = 0;
    int j = 0;
    if ((!bool) && (this.jdField_a_of_type_JavaUtilSet.contains(paramDownloadParam.jdField_b_of_type_JavaLangString)))
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
    if (!b(paramDownloadParam))
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
        localObject1 = a(paramDownloadParam);
      }
      else
      {
        localObject1 = ((ResDownloadHandler.RDHandler)localObject1).b(paramDownloadParam);
      }
      if (new File((String)localObject1).exists()) {
        i = 0;
      }
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          ResDownloadManager.IResDownloadListener localIResDownloadListener = (ResDownloadManager.IResDownloadListener)this.jdField_a_of_type_JavaUtilList.get(j);
          if (localIResDownloadListener == null) {
            break label623;
          }
          localIResDownloadListener.a(paramDownloadParam.jdField_a_of_type_JavaLangString, paramDownloadParam.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramDownloadParam.jdField_a_of_type_JavaLangObject);
          break label623;
        }
        if (paramDownloadParam.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener != null) {
          paramDownloadParam.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener.a(paramDownloadParam.jdField_a_of_type_JavaLangString, paramDownloadParam.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramDownloadParam.jdField_a_of_type_JavaLangObject);
        }
        return true;
      }
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramDownloadParam.jdField_b_of_type_JavaLangString);
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
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiIHttpEngineService.sendReq((NetReq)???);
    paramDownloadParam = this.jdField_a_of_type_JavaUtilList;
    i = k;
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject1 = (ResDownloadManager.IResDownloadListener)this.jdField_a_of_type_JavaUtilList.get(i);
          if (localObject1 == null) {
            break label630;
          }
          ((ResDownloadManager.IResDownloadListener)localObject1).a();
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
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    return a(paramString1, paramString2, paramString3, paramBoolean, paramInt, paramObject, null);
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, ResDownloadManager.IResDownloadListener paramIResDownloadListener)
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
    ResDownloadManager.DownloadParam localDownloadParam = new ResDownloadManager.DownloadParam();
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
    localDownloadParam.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener = paramIResDownloadListener;
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
    return a(localDownloadParam);
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
    if ((localObject2 != null) && ((localObject2 instanceof ResDownloadManager.DownloadParam)))
    {
      localObject5 = (ResDownloadManager.DownloadParam)localObject2;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((ResDownloadManager.DownloadParam)localObject5).jdField_a_of_type_Int);
      localObject4 = ((ResDownloadManager.DownloadParam)localObject5).jdField_b_of_type_JavaLangString;
      if (bool1)
      {
        boolean bool2 = bool1;
        i = j;
        if (((ResDownloadManager.DownloadParam)localObject5).jdField_b_of_type_Boolean)
        {
          if (!((ResDownloadHandler.RDHandler)localObject2).b((ResDownloadManager.DownloadParam)localObject5))
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
        localObject6 = ((ResDownloadHandler.RDHandler)localObject2).a((ResDownloadManager.DownloadParam)localObject5);
        bool1 = bool2;
        localObject2 = localObject1;
        j = i;
        if (bool2)
        {
          bool1 = bool2;
          localObject2 = localObject1;
          j = i;
          if (((ResDownloadManager.DownloadParam)localObject5).jdField_a_of_type_Boolean)
          {
            FileUtils.deleteDirectory((String)localObject6);
            a((ResDownloadManager.DownloadParam)localObject5);
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
        if (this.jdField_a_of_type_JavaUtilSet.contains(localObject4)) {
          this.jdField_a_of_type_JavaUtilSet.remove(localObject4);
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
        if (((ResDownloadManager.DownloadParam)localObject5).jdField_b_of_type_Int > 0)
        {
          ((ResDownloadManager.DownloadParam)localObject5).jdField_b_of_type_Int -= 1;
          a((ResDownloadManager.DownloadParam)localObject5);
          i = 3;
          j = 1;
          break label607;
        }
        if (this.jdField_a_of_type_JavaUtilSet.contains(localObject4)) {
          this.jdField_a_of_type_JavaUtilSet.remove(localObject4);
        }
        i = 3;
      }
      j = 0;
      label607:
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
    Object localObject5 = this.jdField_a_of_type_JavaUtilList;
    j = k;
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject6 = (ResDownloadManager.IResDownloadListener)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localObject6 != null) && (localObject1 != null)) {
            ((ResDownloadManager.IResDownloadListener)localObject6).a(localHttpNetReq.mReqUrl, (String)localObject4, i, ((File)localObject2).getAbsolutePath(), ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangObject);
          }
        }
        else
        {
          if ((localObject1 != null) && (((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener != null)) {
            ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener.a(localHttpNetReq.mReqUrl, (String)localObject4, i, ((File)localObject2).getAbsolutePath(), ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangObject);
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
            ((HashMap)localObject4).put("url", PrecoverUtils.b(((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangString));
            ((HashMap)localObject4).put("md5", ((ResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_JavaLangString);
            ((HashMap)localObject4).put("err_desc", localObject3);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_Int);
            ((StringBuilder)localObject3).append("");
            ((HashMap)localObject4).put("type", ((StringBuilder)localObject3).toString());
            ((HashMap)localObject4).put("endFix", ((ResDownloadManager.DownloadParam)localObject1).c);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((ResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_Int);
            ((StringBuilder)localObject3).append("");
            ((HashMap)localObject4).put("retryCount", ((StringBuilder)localObject3).toString());
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_Boolean);
            ((StringBuilder)localObject3).append("");
            ((HashMap)localObject4).put("needUnzip", ((StringBuilder)localObject3).toString());
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(((ResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_Boolean);
            ((StringBuilder)localObject3).append("");
            ((HashMap)localObject4).put("needVerify", ((StringBuilder)localObject3).toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramNetResp.mHttpCode);
            ((StringBuilder)localObject1).append("");
            ((HashMap)localObject4).put("httpCode", ((StringBuilder)localObject1).toString());
            ((HashMap)localObject4).put("netresp_param_reason", localObject2);
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject4, "", false);
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
      if ((paramNetReq != null) && ((paramNetReq instanceof ResDownloadManager.DownloadParam)))
      {
        paramNetReq = (ResDownloadManager.DownloadParam)paramNetReq;
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
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          ResDownloadManager.IResDownloadListener localIResDownloadListener = (ResDownloadManager.IResDownloadListener)this.jdField_a_of_type_JavaUtilList.get(j);
          if (localIResDownloadListener == null) {
            break label260;
          }
          localIResDownloadListener.a(str1, str2, i);
          break label260;
        }
        if (paramNetReq.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener != null)
        {
          paramNetReq.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager$IResDownloadListener.a(str1, str2, i);
          return;
        }
      }
      return;
      label260:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ResDownloadManager
 * JD-Core Version:    0.7.0.1
 */