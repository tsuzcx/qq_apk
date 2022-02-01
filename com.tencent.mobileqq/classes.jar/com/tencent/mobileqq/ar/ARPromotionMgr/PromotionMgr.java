package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ptvfilter.gesture.GestureRecognitionUtils;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.mobileqq.utils.confighandler.DefaultConfigInfo;
import com.tencent.mobileqq.utils.configsp.ARPromotionConfigSP;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.TreeMap;
import mqq.manager.Manager;

public class PromotionMgr
  implements Manager
{
  DownloadDependRes jdField_a_of_type_ComTencentMobileqqArARPromotionMgrDownloadDependRes = null;
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = null;
  PromotionResDownload jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload = null;
  private ReadConfigTask jdField_a_of_type_ComTencentMobileqqArARPromotionMgrReadConfigTask = null;
  final String jdField_a_of_type_JavaLangString;
  String b;
  
  public PromotionMgr(AppInterface paramAppInterface)
  {
    long l = QQAudioHelper.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARPromotion_");
    localStringBuilder.append(l);
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    this.b = paramAppInterface.getAccount();
    paramAppInterface = this.jdField_a_of_type_JavaLangString;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("PromotionMgr, mUin[");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    QLog.w(paramAppInterface, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload = new PromotionResDownload(l);
  }
  
  public PromotionConfigInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo == null) && (QQAudioHelper.b())) {
      QLog.w(PromotionUtil.jdField_a_of_type_JavaLangString, 1, "getConfigInfo, AR配置还未初始化", new Throwable("打印调用栈"));
    }
    return this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    if (a("doOnReconnect", paramAppInterface, null)) {
      return;
    }
    b(paramAppInterface);
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload != null)
    {
      if (a())
      {
        PromotionConfigInfo localPromotionConfigInfo = a();
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.a(localPromotionConfigInfo);
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.a(paramAppInterface, false, paramString, 0);
        return;
      }
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestDownload, 配置还未初始化");
      return;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestDownload, 下载器为空");
    if (!QQAudioHelper.b()) {
      return;
    }
    throw new IllegalArgumentException(HardCodeUtil.a(2131708505));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, PromotionConfigInfo paramPromotionConfigInfo)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetEntryConfig, from server, configInfo[");
    boolean bool;
    if (paramPromotionConfigInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (paramPromotionConfigInfo != null)
    {
      a(paramPromotionConfigInfo);
      paramPromotionConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrReadConfigTask;
      if (paramPromotionConfigInfo != null)
      {
        paramPromotionConfigInfo.clean();
        this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrReadConfigTask = null;
      }
    }
    if (a("onGetConfig", paramQQAppInterface, null)) {
      return;
    }
    a(paramString);
    b(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, DefaultConfigInfo paramDefaultConfigInfo)
  {
    if (!a())
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onGetResConfig, 365还没加载");
      return;
    }
    paramDefaultConfigInfo = a();
    if (paramDefaultConfigInfo == null)
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onGetResConfig, 365为null");
      return;
    }
    int i = ARPromotionConfigSP.a(this.b);
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetResConfig, 365已经加载了, [");
    localStringBuilder.append(paramDefaultConfigInfo.config364Version);
    localStringBuilder.append("], ver[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (TextUtils.equals(paramString, "test")) {
      i = -1;
    }
    if (i == paramDefaultConfigInfo.config364Version) {
      return;
    }
    a(null);
    a(paramQQAppInterface, null, null);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    if (paramPromotionConfigInfo == null) {}
    for (;;)
    {
      try
      {
        if (QQAudioHelper.b())
        {
          localThrowable = new Throwable("打印调用栈");
          String str = this.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setConfigInfo, old[");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo);
          localStringBuilder.append("], new[");
          localStringBuilder.append(paramPromotionConfigInfo);
          localStringBuilder.append("]");
          QLog.w(str, 1, localStringBuilder.toString(), localThrowable);
          this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
          this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrReadConfigTask = null;
          return;
        }
      }
      finally {}
      Throwable localThrowable = null;
    }
  }
  
  public void a(PromotionResDownload.DownloadListener paramDownloadListener)
  {
    PromotionResDownload localPromotionResDownload = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload;
    if (localPromotionResDownload != null) {
      localPromotionResDownload.a(paramDownloadListener);
    }
  }
  
  void a(String paramString)
  {
    PromotionResDownload localPromotionResDownload = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload;
    if (localPromotionResDownload != null) {
      localPromotionResDownload.b();
    }
    BusinessCommonConfig.sendConfigUpdateNotify(2, paramString);
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  boolean a(String paramString, AppInterface paramAppInterface, PromotionMgr.GetConfigListen paramGetConfigListen)
  {
    if ((a()) && (PromotionDevice.a != -1)) {
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrReadConfigTask;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((TextUtils.isEmpty(this.b)) && (paramAppInterface != null)) {
        this.b = paramAppInterface.getCurrentAccountUin();
      }
      localObject1 = new ReadConfigTask(this.jdField_a_of_type_JavaLangString, this.b, paramAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrReadConfigTask = ((ReadConfigTask)localObject1);
    }
    if (((ReadConfigTask)localObject1).isNeedRunTask())
    {
      localObject2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("异步加载config[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      SyncLoadTask.requestSyncTask(null, (ArrayList)localObject2, new PromotionMgr.1(this, paramAppInterface, paramString, paramGetConfigListen));
      return true;
    }
    paramAppInterface = this.jdField_a_of_type_JavaLangString;
    paramGetConfigListen = new StringBuilder();
    paramGetConfigListen.append("异步加载config[");
    paramGetConfigListen.append(paramString);
    paramGetConfigListen.append("], 已经在加载中");
    QLog.w(paramAppInterface, 1, paramGetConfigListen.toString());
    return true;
  }
  
  void b(AppInterface paramAppInterface)
  {
    PromotionConfigInfo localPromotionConfigInfo = a();
    Object localObject2;
    if (QQAudioHelper.c())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestPreDownload, PromotionConfigInfo[");
      ((StringBuilder)localObject2).append(localPromotionConfigInfo);
      ((StringBuilder)localObject2).append("], isDevicesSupport[");
      ((StringBuilder)localObject2).append(PromotionDevice.a());
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (!PromotionDevice.a()) {
      return;
    }
    if (localPromotionConfigInfo == null) {
      return;
    }
    if (!localPromotionConfigInfo.mainswitch) {
      return;
    }
    if (localPromotionConfigInfo.operationInfos.size() == 0) {
      return;
    }
    c(paramAppInterface);
    Object localObject1 = a();
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload;
      if (localObject2 == null) {
        return;
      }
      ((PromotionResDownload)localObject2).a((PromotionConfigInfo)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload.a(paramAppInterface, true, localPromotionConfigInfo.activityid, 0);
    }
  }
  
  public void b(PromotionResDownload.DownloadListener paramDownloadListener)
  {
    PromotionResDownload localPromotionResDownload = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload;
    if (localPromotionResDownload != null) {
      localPromotionResDownload.b(paramDownloadListener);
    }
  }
  
  void c(AppInterface paramAppInterface)
  {
    GestureRecognitionUtils.a();
    if (this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrDownloadDependRes == null) {
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrDownloadDependRes = new DownloadDependRes();
    }
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrDownloadDependRes.a(paramAppInterface);
  }
  
  public void onDestroy()
  {
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, ThreadID[");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append("], Tid[");
    localStringBuilder.append(Process.myTid());
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrReadConfigTask;
    if (localObject != null)
    {
      ((ReadConfigTask)localObject).clean();
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrReadConfigTask = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload;
    if (localObject != null)
    {
      ((PromotionResDownload)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionResDownload = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrDownloadDependRes;
    if (localObject != null)
    {
      ((DownloadDependRes)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrDownloadDependRes = null;
    }
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionMgr
 * JD-Core Version:    0.7.0.1
 */