import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aosv
  extends aosm
{
  static PromotionConfigInfo b;
  final String c = "SubProcessPromotionMgr_" + AudioHelper.b();
  
  public aosv(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    a(paramAppInterface);
    QLog.w(this.c, 1, "SubProcessPromotionMgr, sProcessId[" + BaseApplicationImpl.sProcessId + "], processName[" + BaseApplicationImpl.processName + "]");
  }
  
  public void a(AppInterface paramAppInterface, aoso paramaoso)
  {
    if (a("snycGetConfig", paramAppInterface, paramaoso)) {
      return;
    }
    paramaoso.a(a());
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    BusinessCommonConfig.notifyQQDownload(2, paramString, 0);
  }
  
  void a(PromotionConfigInfo paramPromotionConfigInfo)
  {
    super.a(paramPromotionConfigInfo);
    try
    {
      jdField_b_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = paramPromotionConfigInfo;
      return;
    }
    finally {}
  }
  
  boolean a(AppInterface paramAppInterface)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.businessnotify.qq.to.subprocess");
    return paramAppInterface.getApp().registerReceiver(new aosw(this), localIntentFilter) != null;
  }
  
  void b(AppInterface paramAppInterface) {}
  
  void b(String paramString)
  {
    try
    {
      paramString = bguf.a(this.jdField_b_of_type_JavaLangString, paramString);
      a(paramString);
      QLog.w(this.c, 1, "reloadConfigInfo, Uin[" + this.jdField_b_of_type_JavaLangString + "] configInfo[" + paramString + "]");
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jdField_b_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosv
 * JD-Core Version:    0.7.0.1
 */