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

public class apcq
  implements Manager
{
  apck jdField_a_of_type_Apck = null;
  apcu jdField_a_of_type_Apcu = null;
  private apcy jdField_a_of_type_Apcy;
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = null;
  final String jdField_a_of_type_JavaLangString;
  String b;
  
  public apcq(AppInterface paramAppInterface)
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_JavaLangString = ("ARPromotion_" + l);
    this.b = paramAppInterface.getAccount();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "PromotionMgr, mUin[" + this.b + "]");
    this.jdField_a_of_type_Apcu = new apcu(l);
  }
  
  public PromotionConfigInfo a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo == null) && (AudioHelper.e())) {
      QLog.w(apcx.jdField_a_of_type_JavaLangString, 1, "getConfigInfo, AR配置还未初始化", new Throwable("打印调用栈"));
    }
    return this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  }
  
  public void a(apcw paramapcw)
  {
    if (this.jdField_a_of_type_Apcu != null) {
      this.jdField_a_of_type_Apcu.a(paramapcw);
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
    if (this.jdField_a_of_type_Apcu != null) {
      if (a())
      {
        PromotionConfigInfo localPromotionConfigInfo = a();
        this.jdField_a_of_type_Apcu.a(localPromotionConfigInfo);
        this.jdField_a_of_type_Apcu.a(paramAppInterface, false, paramString, 0);
      }
    }
    do
    {
      return;
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestDownload, 配置还未初始化");
      return;
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestDownload, 下载器为空");
    } while (!AudioHelper.e());
    throw new IllegalArgumentException(anvx.a(2131707972));
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
        if (this.jdField_a_of_type_Apcy != null)
        {
          this.jdField_a_of_type_Apcy.clean();
          this.jdField_a_of_type_Apcy = null;
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
      i = bhjo.a(this.b);
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
        if (AudioHelper.e())
        {
          localThrowable = new Throwable("打印调用栈");
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setConfigInfo, old[" + this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo + "], new[" + paramPromotionConfigInfo + "]", localThrowable);
          this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
          this.jdField_a_of_type_Apcy = null;
          return;
        }
      }
      finally {}
      Throwable localThrowable = null;
    }
  }
  
  void a(String paramString)
  {
    if (this.jdField_a_of_type_Apcu != null) {
      this.jdField_a_of_type_Apcu.b();
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
  
  boolean a(String paramString, AppInterface paramAppInterface, apcs paramapcs)
  {
    if ((a()) && (apcp.a != -1)) {
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_Apcy;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if ((TextUtils.isEmpty(this.b)) && (paramAppInterface != null)) {
        this.b = paramAppInterface.getCurrentAccountUin();
      }
      localObject1 = new apcy(this.jdField_a_of_type_JavaLangString, this.b, paramAppInterface);
      this.jdField_a_of_type_Apcy = ((apcy)localObject1);
    }
    if (((apcy)localObject1).isNeedRunTask())
    {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "异步加载config[" + paramString + "]");
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(localObject1);
      bhhz.requestSyncTask(null, (ArrayList)localObject2, new apcr(this, paramAppInterface, paramString, paramapcs));
    }
    for (;;)
    {
      return true;
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "异步加载config[" + paramString + "], 已经在加载中");
    }
  }
  
  public void b(apcw paramapcw)
  {
    if (this.jdField_a_of_type_Apcu != null) {
      this.jdField_a_of_type_Apcu.b(paramapcw);
    }
  }
  
  void b(AppInterface paramAppInterface)
  {
    PromotionConfigInfo localPromotionConfigInfo1 = a();
    if (AudioHelper.f()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestPreDownload, PromotionConfigInfo[" + localPromotionConfigInfo1 + "], isDevicesSupport[" + apcp.a() + "]");
    }
    if (!apcp.a()) {}
    PromotionConfigInfo localPromotionConfigInfo2;
    do
    {
      do
      {
        return;
      } while ((localPromotionConfigInfo1 == null) || (!localPromotionConfigInfo1.mainswitch) || (localPromotionConfigInfo1.operationInfos.size() == 0));
      c(paramAppInterface);
      localPromotionConfigInfo2 = a();
    } while ((localPromotionConfigInfo2 == null) || (this.jdField_a_of_type_Apcu == null));
    this.jdField_a_of_type_Apcu.a(localPromotionConfigInfo2);
    this.jdField_a_of_type_Apcu.a(paramAppInterface, true, localPromotionConfigInfo1.activityid, 0);
  }
  
  void c(AppInterface paramAppInterface)
  {
    bdck.b();
    if (this.jdField_a_of_type_Apck == null) {
      this.jdField_a_of_type_Apck = new apck();
    }
    this.jdField_a_of_type_Apck.a(paramAppInterface);
  }
  
  public void onDestroy()
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onDestroy, ThreadID[" + Thread.currentThread().getId() + "], Tid[" + Process.myTid() + "]");
    if (this.jdField_a_of_type_Apcy != null)
    {
      this.jdField_a_of_type_Apcy.clean();
      this.jdField_a_of_type_Apcy = null;
    }
    if (this.jdField_a_of_type_Apcu != null)
    {
      this.jdField_a_of_type_Apcu.a();
      this.jdField_a_of_type_Apcu = null;
    }
    if (this.jdField_a_of_type_Apck != null)
    {
      this.jdField_a_of_type_Apck.a();
      this.jdField_a_of_type_Apck = null;
    }
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcq
 * JD-Core Version:    0.7.0.1
 */