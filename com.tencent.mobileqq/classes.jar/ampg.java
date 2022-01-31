import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.confighandler.DefaultConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.TreeMap;
import mqq.manager.Manager;

public class ampg
  implements Manager
{
  ampa jdField_a_of_type_Ampa = null;
  ampk jdField_a_of_type_Ampk = null;
  private ampo jdField_a_of_type_Ampo;
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = null;
  final String jdField_a_of_type_JavaLangString;
  String b;
  
  public ampg(AppInterface paramAppInterface)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_JavaLangString = ("ARPromotion_" + l);
    this.b = paramAppInterface.getAccount();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "PromotionMgr, mUin[" + this.b + "]");
    this.jdField_a_of_type_Ampk = new ampk(l);
  }
  
  public PromotionConfigInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo == null) && (AudioHelper.d()))
    {
      QLog.w(ampn.jdField_a_of_type_JavaLangString, 1, "getConfigInfo, AR配置还未初始化", new Throwable("打印调用栈"));
      throw new IllegalArgumentException("AR配置还未初始化");
    }
    return this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  }
  
  public void a(ampm paramampm)
  {
    if (this.jdField_a_of_type_Ampk != null) {
      this.jdField_a_of_type_Ampk.a(paramampm);
    }
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
    if (this.jdField_a_of_type_Ampk != null) {
      if (a())
      {
        PromotionConfigInfo localPromotionConfigInfo = a();
        this.jdField_a_of_type_Ampk.a(localPromotionConfigInfo);
        this.jdField_a_of_type_Ampk.a(paramAppInterface, false, paramString, 0);
      }
    }
    do
    {
      return;
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestDownload, 配置还未初始化");
      return;
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestDownload, 下载器为空");
    } while (!AudioHelper.d());
    throw new IllegalArgumentException(alpo.a(2131708896));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, PromotionConfigInfo paramPromotionConfigInfo)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("onGetEntryConfig, from server, configInfo[");
    if (paramPromotionConfigInfo != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w(str, 1, bool + "]");
      if (paramPromotionConfigInfo != null)
      {
        a(paramPromotionConfigInfo);
        if (this.jdField_a_of_type_Ampo != null)
        {
          this.jdField_a_of_type_Ampo.clean();
          this.jdField_a_of_type_Ampo = null;
        }
      }
      if (!a("onGetConfig", paramQQAppInterface, null)) {
        break;
      }
      return;
    }
    a(paramString);
    b(paramQQAppInterface);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, DefaultConfigInfo paramDefaultConfigInfo)
  {
    if (!a()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onGetResConfig, 365还没加载");
    }
    int i;
    do
    {
      return;
      paramDefaultConfigInfo = a();
      if (paramDefaultConfigInfo == null)
      {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onGetResConfig, 365为null");
        return;
      }
      i = bdkx.a(this.b);
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onGetResConfig, 365已经加载了, [" + paramDefaultConfigInfo.config364Version + "], ver[" + i + "]");
      if (TextUtils.equals(paramString, "test")) {
        i = -1;
      }
    } while (i == paramDefaultConfigInfo.config364Version);
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
        if (AudioHelper.d())
        {
          localThrowable = new Throwable("打印调用栈");
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setConfigInfo, old[" + this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo + "], new[" + paramPromotionConfigInfo + "]", localThrowable);
          this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
          this.jdField_a_of_type_Ampo = null;
          return;
        }
      }
      finally {}
      Throwable localThrowable = null;
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_Ampk != null) {
      this.jdField_a_of_type_Ampk.b();
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
  
  boolean a(String paramString, AppInterface paramAppInterface, ampi paramampi)
  {
    if ((a()) && (ampf.a != -1)) {
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_Ampo;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((TextUtils.isEmpty(this.b)) && (paramAppInterface != null)) {
        this.b = paramAppInterface.getCurrentAccountUin();
      }
      localObject1 = new ampo(this.jdField_a_of_type_JavaLangString, this.b, paramAppInterface);
      this.jdField_a_of_type_Ampo = ((ampo)localObject1);
    }
    if (((ampo)localObject1).isNeedRunTask())
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "异步加载config[" + paramString + "]");
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      bdjf.requestSyncTask(null, (ArrayList)localObject2, new amph(this, paramAppInterface, paramString, paramampi));
    }
    for (;;)
    {
      return true;
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "异步加载config[" + paramString + "], 已经在加载中");
    }
  }
  
  public void b(ampm paramampm)
  {
    if (this.jdField_a_of_type_Ampk != null) {
      this.jdField_a_of_type_Ampk.b(paramampm);
    }
  }
  
  void b(AppInterface paramAppInterface)
  {
    PromotionConfigInfo localPromotionConfigInfo1 = a();
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, PromotionConfigInfo[" + localPromotionConfigInfo1 + "], isDevicesSupport[" + ampf.a() + "]");
    }
    if (!ampf.a()) {}
    while ((localPromotionConfigInfo1 == null) || (!localPromotionConfigInfo1.mainswitch) || (localPromotionConfigInfo1.operationInfos.size() == 0)) {
      return;
    }
    c(paramAppInterface);
    PromotionConfigInfo localPromotionConfigInfo2 = a();
    this.jdField_a_of_type_Ampk.a(localPromotionConfigInfo2);
    this.jdField_a_of_type_Ampk.a(paramAppInterface, true, localPromotionConfigInfo1.activityid, 0);
  }
  
  void c(AppInterface paramAppInterface)
  {
    azem.b();
    if (this.jdField_a_of_type_Ampa == null) {
      this.jdField_a_of_type_Ampa = new ampa();
    }
    this.jdField_a_of_type_Ampa.a(paramAppInterface);
  }
  
  public void onDestroy()
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onDestroy, ThreadID[" + Thread.currentThread().getId() + "], Tid[" + Process.myTid() + "]");
    if (this.jdField_a_of_type_Ampo != null)
    {
      this.jdField_a_of_type_Ampo.clean();
      this.jdField_a_of_type_Ampo = null;
    }
    if (this.jdField_a_of_type_Ampk != null)
    {
      this.jdField_a_of_type_Ampk.a();
      this.jdField_a_of_type_Ampk = null;
    }
    if (this.jdField_a_of_type_Ampa != null)
    {
      this.jdField_a_of_type_Ampa.a();
      this.jdField_a_of_type_Ampa = null;
    }
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampg
 * JD-Core Version:    0.7.0.1
 */