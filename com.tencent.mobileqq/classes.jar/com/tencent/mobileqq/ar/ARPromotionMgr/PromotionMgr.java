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
import mqq.util.LogUtil;

public class PromotionMgr
  implements Manager
{
  final String a;
  String b;
  PromotionConfigInfo c = null;
  PromotionResDownload d = null;
  DownloadDependRes e = null;
  private ReadConfigTask f = null;
  
  public PromotionMgr(AppInterface paramAppInterface)
  {
    long l = QQAudioHelper.d();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARPromotion_");
    localStringBuilder.append(l);
    this.a = localStringBuilder.toString();
    this.b = paramAppInterface.getAccount();
    paramAppInterface = this.a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("PromotionMgr, mUin[");
    localStringBuilder.append(LogUtil.getSafePrintUin(this.b));
    localStringBuilder.append("]");
    QLog.w(paramAppInterface, 1, localStringBuilder.toString());
    this.d = new PromotionResDownload(l);
  }
  
  public PromotionConfigInfo a()
  {
    if ((this.c == null) && (QQAudioHelper.b())) {
      QLog.w(PromotionUtil.a, 1, "getConfigInfo, AR配置还未初始化", new Throwable("打印调用栈"));
    }
    return this.c;
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
    if (this.d != null)
    {
      if (b())
      {
        PromotionConfigInfo localPromotionConfigInfo = a();
        this.d.a(localPromotionConfigInfo);
        this.d.a(paramAppInterface, false, paramString, 0);
        return;
      }
      QLog.w(this.a, 1, "requestDownload, 配置还未初始化");
      return;
    }
    QLog.w(this.a, 1, "requestDownload, 下载器为空");
    if (!QQAudioHelper.b()) {
      return;
    }
    throw new IllegalArgumentException(HardCodeUtil.a(2131906290));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, PromotionConfigInfo paramPromotionConfigInfo)
  {
    String str = this.a;
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
      paramPromotionConfigInfo = this.f;
      if (paramPromotionConfigInfo != null)
      {
        paramPromotionConfigInfo.clean();
        this.f = null;
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
    if (!b())
    {
      QLog.w(this.a, 1, "onGetResConfig, 365还没加载");
      return;
    }
    paramDefaultConfigInfo = a();
    if (paramDefaultConfigInfo == null)
    {
      QLog.w(this.a, 1, "onGetResConfig, 365为null");
      return;
    }
    int i = ARPromotionConfigSP.d(this.b);
    String str = this.a;
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
          String str = this.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setConfigInfo, old[");
          localStringBuilder.append(this.c);
          localStringBuilder.append("], new[");
          localStringBuilder.append(paramPromotionConfigInfo);
          localStringBuilder.append("]");
          QLog.w(str, 1, localStringBuilder.toString(), localThrowable);
          this.c = paramPromotionConfigInfo;
          this.f = null;
          return;
        }
      }
      finally {}
      Throwable localThrowable = null;
    }
  }
  
  public void a(PromotionResDownload.DownloadListener paramDownloadListener)
  {
    PromotionResDownload localPromotionResDownload = this.d;
    if (localPromotionResDownload != null) {
      localPromotionResDownload.a(paramDownloadListener);
    }
  }
  
  void a(String paramString)
  {
    PromotionResDownload localPromotionResDownload = this.d;
    if (localPromotionResDownload != null) {
      localPromotionResDownload.c();
    }
    BusinessCommonConfig.sendConfigUpdateNotify(2, paramString);
  }
  
  boolean a(String paramString, AppInterface paramAppInterface, PromotionMgr.GetConfigListen paramGetConfigListen)
  {
    if ((b()) && (PromotionDevice.b != -1)) {
      return false;
    }
    Object localObject2 = this.f;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((TextUtils.isEmpty(this.b)) && (paramAppInterface != null)) {
        this.b = paramAppInterface.getCurrentAccountUin();
      }
      localObject1 = new ReadConfigTask(this.a, this.b, paramAppInterface);
      this.f = ((ReadConfigTask)localObject1);
    }
    if (((ReadConfigTask)localObject1).isNeedRunTask())
    {
      localObject2 = this.a;
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
    paramAppInterface = this.a;
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
    if (QQAudioHelper.f())
    {
      localObject1 = this.a;
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
      localObject2 = this.d;
      if (localObject2 == null) {
        return;
      }
      ((PromotionResDownload)localObject2).a((PromotionConfigInfo)localObject1);
      this.d.a(paramAppInterface, true, localPromotionConfigInfo.activityid, 0);
    }
  }
  
  public void b(PromotionResDownload.DownloadListener paramDownloadListener)
  {
    PromotionResDownload localPromotionResDownload = this.d;
    if (localPromotionResDownload != null) {
      localPromotionResDownload.b(paramDownloadListener);
    }
  }
  
  public boolean b()
  {
    for (;;)
    {
      try
      {
        if (this.c != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  void c(AppInterface paramAppInterface)
  {
    GestureRecognitionUtils.a();
    if (this.e == null) {
      this.e = new DownloadDependRes();
    }
    this.e.a(paramAppInterface);
  }
  
  public void onDestroy()
  {
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy, ThreadID[");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append("], Tid[");
    localStringBuilder.append(Process.myTid());
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.f;
    if (localObject != null)
    {
      ((ReadConfigTask)localObject).clean();
      this.f = null;
    }
    localObject = this.d;
    if (localObject != null)
    {
      ((PromotionResDownload)localObject).a();
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((DownloadDependRes)localObject).a();
      this.e = null;
    }
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionMgr
 * JD-Core Version:    0.7.0.1
 */