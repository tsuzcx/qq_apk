package com.tencent.mobileqq.armap;

import aawb;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.precover.PrecoverResDownloader;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
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
  implements INetEngine.INetEngineListener, Manager
{
  static INetEngine.IBreakDownFix jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = new aawb();
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ResDownloadHandler jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler;
  private INetEngine jdField_a_of_type_ComTencentMobileqqTransfileINetEngine;
  private List jdField_a_of_type_JavaUtilList = new Vector();
  Set jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  
  public ResDownloadManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = paramAppInterface.getNetEngine(0);
    this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler = new ResDownloadHandler();
  }
  
  private String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "unCompressZipFile|:" + paramDownloadParam);
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).a(paramDownloadParam);
    if (!FileUtils.a(str)) {}
    try
    {
      FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).b(paramDownloadParam), str, false);
      if (QLog.isColorLevel()) {
        QLog.d("ResDownloadManager", 2, "unCompressZipFile success.destDir=" + str);
      }
      return str;
    }
    catch (Exception localException)
    {
      FileUtils.a(str);
      QLog.d("ResDownloadManager", 1, "unCompressZipFile failed," + paramDownloadParam + " , " + localException.getMessage(), localException);
    }
    return str;
  }
  
  private void a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "retry|" + paramDownloadParam);
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramDownloadParam.jdField_a_of_type_JavaLangString;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.c = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int).b(paramDownloadParam);
    localHttpNetReq.e = 1;
    localHttpNetReq.a(paramDownloadParam);
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
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
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int j = 0;
    if ((paramNetReq == null) || (!(paramNetReq instanceof HttpNetReq))) {}
    String str;
    do
    {
      return;
      str = ((HttpNetReq)paramNetReq).jdField_a_of_type_JavaLangString;
      paramNetReq = paramNetReq.a();
    } while ((paramNetReq == null) || (!(paramNetReq instanceof ResDownloadManager.DownloadParam)));
    ??? = (ResDownloadManager.DownloadParam)paramNetReq;
    paramNetReq = ((ResDownloadManager.DownloadParam)???).jdField_b_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "onUpdateProgeress|curOffset=" + paramLong1 + "|totalLen=" + paramLong2 + "|" + ???);
    }
    if (((ResDownloadManager.DownloadParam)???).jdField_a_of_type_Boolean) {}
    for (int i = 90;; i = 100)
    {
      if (paramLong2 > 0L) {
        i = (int)(i * paramLong1 / paramLong2);
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilList)
        {
          if (j < this.jdField_a_of_type_JavaUtilList.size())
          {
            ResDownloadManager.IResDownloadListener localIResDownloadListener = (ResDownloadManager.IResDownloadListener)this.jdField_a_of_type_JavaUtilList.get(j);
            if (localIResDownloadListener == null) {
              break label208;
            }
            localIResDownloadListener.a(str, paramNetReq, i);
            break label208;
          }
          return;
        }
        i = 0;
        continue;
        label208:
        j += 1;
      }
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    boolean bool1;
    HttpNetReq localHttpNetReq;
    Object localObject1;
    Object localObject2;
    int i;
    String str;
    label56:
    Object localObject3;
    boolean bool2;
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      bool1 = true;
      localHttpNetReq = (HttpNetReq)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq;
      localObject1 = new File(localHttpNetReq.c);
      localObject2 = localHttpNetReq.a();
      i = paramNetResp.jdField_b_of_type_Int;
      if (paramNetResp.jdField_a_of_type_JavaLangString != null) {
        break label438;
      }
      str = "0";
      j = 0;
      if ((localObject2 == null) || (!(localObject2 instanceof ResDownloadManager.DownloadParam))) {
        break label595;
      }
      localObject2 = (ResDownloadManager.DownloadParam)localObject2;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((ResDownloadManager.DownloadParam)localObject2).jdField_a_of_type_Int);
      localObject4 = ((ResDownloadManager.DownloadParam)localObject2).jdField_b_of_type_JavaLangString;
      if (!bool1) {
        break label447;
      }
      if (!((ResDownloadManager.DownloadParam)localObject2).jdField_b_of_type_Boolean) {
        break label1143;
      }
      if (((ResDownloadHandler.RDHandler)localObject3).b((ResDownloadManager.DownloadParam)localObject2)) {
        break label1138;
      }
      j = -6103066;
      ((File)localObject1).delete();
      bool1 = false;
      i = j;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.i("ResDownloadManager", 1, "onResp.md5 verify suc|" + bool1 + "|" + localObject2);
        bool2 = bool1;
        i = j;
      }
      label194:
      localObject3 = ((ResDownloadHandler.RDHandler)localObject3).a((ResDownloadManager.DownloadParam)localObject2);
      if ((!bool2) || (!((ResDownloadManager.DownloadParam)localObject2).jdField_a_of_type_Boolean)) {
        break label1129;
      }
      FileUtils.a((String)localObject3);
      a((ResDownloadManager.DownloadParam)localObject2);
      localObject3 = new File((String)localObject3);
      bool2 = ((File)localObject3).exists();
      if (!bool2) {
        i = 2;
      }
      j = i;
      localObject1 = localObject3;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("ResDownloadManager", 2, "onResp.unCompressZipFile suc|" + bool2 + "|" + localObject2);
        bool1 = bool2;
        localObject1 = localObject3;
        j = i;
      }
      label317:
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject4)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject4);
      }
      i = j;
      j = 0;
      label347:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject4;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp url:" + localHttpNetReq.jdField_a_of_type_JavaLangString + " result:" + paramNetResp.jdField_a_of_type_Int + " errCode:" + i + " md5:" + (String)localObject2);
      }
      if (j == 0) {
        break label647;
      }
      label431:
      return;
      bool1 = false;
      break;
      label438:
      str = paramNetResp.jdField_a_of_type_JavaLangString;
      break label56;
      label447:
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp result|" + paramNetResp.jdField_a_of_type_Int + "|errCode:" + i + "|errDesc:" + str + "|params:" + localObject2);
      }
      if ((localObject1 != null) && (((File)localObject1).exists())) {
        ((File)localObject1).delete();
      }
      if (((ResDownloadManager.DownloadParam)localObject2).jdField_b_of_type_Int > 0)
      {
        ((ResDownloadManager.DownloadParam)localObject2).jdField_b_of_type_Int -= 1;
        a((ResDownloadManager.DownloadParam)localObject2);
        j = 1;
        break label347;
      }
      if (this.jdField_a_of_type_JavaUtilSet.contains(localObject4)) {
        this.jdField_a_of_type_JavaUtilSet.remove(localObject4);
      }
      j = 0;
      break label347;
      label595:
      ((File)localObject1).delete();
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "onResp userdata|" + localObject2);
      }
      localObject3 = localObject1;
      localObject2 = null;
      localObject1 = null;
    }
    label647:
    Object localObject4 = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    for (;;)
    {
      try
      {
        if (j < this.jdField_a_of_type_JavaUtilList.size())
        {
          ResDownloadManager.IResDownloadListener localIResDownloadListener = (ResDownloadManager.IResDownloadListener)this.jdField_a_of_type_JavaUtilList.get(j);
          if ((localIResDownloadListener == null) || (localObject1 == null)) {
            break label1150;
          }
          localIResDownloadListener.a(localHttpNetReq.jdField_a_of_type_JavaLangString, (String)localObject2, i, ((File)localObject3).getAbsolutePath(), ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangObject);
          break label1150;
        }
        if ((bool1) || (localObject1 == null)) {
          break label431;
        }
        QLog.d("ResDownloadManager", 1, "reportDownloadResult, params=" + localObject1 + ", errCode=" + i + ", errDesc=" + str + ", httpCode=" + paramNetResp.c);
        if ((paramNetResp.jdField_a_of_type_JavaUtilHashMap != null) && (paramNetResp.jdField_a_of_type_JavaUtilHashMap.containsKey("netresp_param_reason")))
        {
          localObject2 = (String)paramNetResp.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");
          localObject3 = new HashMap();
          ((HashMap)localObject3).put("param_FailCode", String.valueOf(i));
          ((HashMap)localObject3).put("url", PrecoverUtils.b(((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_JavaLangString));
          ((HashMap)localObject3).put("md5", ((ResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_JavaLangString);
          ((HashMap)localObject3).put("err_desc", str);
          ((HashMap)localObject3).put("type", ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_Int + "");
          ((HashMap)localObject3).put("endFix", ((ResDownloadManager.DownloadParam)localObject1).c);
          ((HashMap)localObject3).put("retryCount", ((ResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_Int + "");
          ((HashMap)localObject3).put("needUnzip", ((ResDownloadManager.DownloadParam)localObject1).jdField_a_of_type_Boolean + "");
          ((HashMap)localObject3).put("needVerify", ((ResDownloadManager.DownloadParam)localObject1).jdField_b_of_type_Boolean + "");
          ((HashMap)localObject3).put("httpCode", paramNetResp.c + "");
          ((HashMap)localObject3).put("netresp_param_reason", localObject2);
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "armap_download_result", bool1, 0L, 0L, (HashMap)localObject3, "", false);
          return;
        }
      }
      finally {}
      localObject2 = "0";
      continue;
      label1129:
      bool1 = bool2;
      j = i;
      break label317;
      label1138:
      j = i;
      break;
      label1143:
      bool2 = bool1;
      break label194;
      label1150:
      j += 1;
    }
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramDownloadParam);
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqArmapResDownloadHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadParam.jdField_a_of_type_Int);
    if ((!TextUtils.isEmpty(paramDownloadParam.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaUtilSet.contains(paramDownloadParam.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, task is underway.|" + paramDownloadParam);
      }
      return false;
    }
    Object localObject1;
    if (!b(paramDownloadParam))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ResDownloadManager", 2, "no need to download, file is exists.|" + paramDownloadParam);
      }
      if (paramDownloadParam.jdField_a_of_type_Boolean)
      {
        localObject1 = ((ResDownloadHandler.RDHandler)localObject2).a(paramDownloadParam);
        if ((FileUtils.a((String)localObject1)) && (!((ResDownloadHandler.RDHandler)localObject2).a(paramDownloadParam, true)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ResDownloadManager", 2, "unzipDir has been changed. |" + paramDownloadParam);
          }
          FileUtils.a((String)localObject1);
        }
        localObject1 = a(paramDownloadParam);
        if (new File((String)localObject1).exists()) {
          break label559;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        int j = 0;
        try
        {
          for (;;)
          {
            if (j < this.jdField_a_of_type_JavaUtilList.size())
            {
              ResDownloadManager.IResDownloadListener localIResDownloadListener = (ResDownloadManager.IResDownloadListener)this.jdField_a_of_type_JavaUtilList.get(j);
              if (localIResDownloadListener != null) {
                localIResDownloadListener.a(paramDownloadParam.jdField_a_of_type_JavaLangString, paramDownloadParam.jdField_b_of_type_JavaLangString, i, (String)localObject1, paramDownloadParam.jdField_a_of_type_JavaLangObject);
              }
              j += 1;
              continue;
              localObject1 = ((ResDownloadHandler.RDHandler)localObject2).b(paramDownloadParam);
              break;
            }
          }
          return false;
        }
        finally {}
      }
      this.jdField_a_of_type_JavaUtilSet.add(paramDownloadParam.jdField_b_of_type_JavaLangString);
      for (;;)
      {
        try
        {
          localObject1 = (PrecoverManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(178);
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
          if (localObject1 != null)
          {
            boolean bool = ((PrecoverResDownloader)localObject1).a(paramDownloadParam.jdField_b_of_type_JavaLangString);
            if (QLog.isColorLevel()) {
              QLog.d("ResDownloadManager", 2, "downloading by precover=" + bool + ", md5=" + paramDownloadParam.jdField_b_of_type_JavaLangString);
            }
            if (bool) {
              ((PrecoverResDownloader)localObject1).a(paramDownloadParam.jdField_b_of_type_JavaLangString);
            }
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          localException.printStackTrace();
          continue;
        }
        localObject1 = new HttpNetReq();
        ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
        ((HttpNetReq)localObject1).jdField_a_of_type_JavaLangString = paramDownloadParam.jdField_a_of_type_JavaLangString;
        ((HttpNetReq)localObject1).jdField_a_of_type_Int = 0;
        ((HttpNetReq)localObject1).c = ((ResDownloadHandler.RDHandler)localObject2).b(paramDownloadParam);
        ((HttpNetReq)localObject1).e = 1;
        ((HttpNetReq)localObject1).a(paramDownloadParam);
        ((HttpNetReq)localObject1).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject1);
        return true;
        localObject1 = ((PrecoverManager)localObject1).a();
      }
      label559:
      i = 0;
    }
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ResDownloadManager", 2, "download|" + paramString1 + "|" + paramString2);
    }
    ResDownloadManager.DownloadParam localDownloadParam = new ResDownloadManager.DownloadParam();
    localDownloadParam.jdField_a_of_type_Int = paramInt;
    localDownloadParam.jdField_a_of_type_JavaLangString = paramString1;
    localDownloadParam.jdField_b_of_type_Int = 2;
    String str = paramString3;
    if (paramString3 == null) {
      str = "";
    }
    localDownloadParam.c = str;
    localDownloadParam.jdField_a_of_type_Boolean = paramBoolean;
    localDownloadParam.jdField_a_of_type_JavaLangObject = paramObject;
    if (TextUtils.isEmpty(paramString2)) {
      localDownloadParam.jdField_b_of_type_JavaLangString = Utils.Crc64String(paramString1);
    }
    for (localDownloadParam.jdField_b_of_type_Boolean = false;; localDownloadParam.jdField_b_of_type_Boolean = true)
    {
      return a(localDownloadParam);
      localDownloadParam.jdField_b_of_type_JavaLangString = paramString2;
    }
  }
  
  public void b(ResDownloadManager.IResDownloadListener paramIResDownloadListener)
  {
    if (paramIResDownloadListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramIResDownloadListener);
      return;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ResDownloadManager
 * JD-Core Version:    0.7.0.1
 */