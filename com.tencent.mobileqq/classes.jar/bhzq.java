import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class bhzq
  implements Manager
{
  public asgs a;
  public aslq a;
  public auvx a;
  public avqr a;
  public azxs a;
  public bhwz a;
  private bhzr a;
  public bidn a;
  public QQAppInterface a;
  public VasFaceManager a;
  
  public bhzq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aslq = new aslq(paramQQAppInterface);
    this.jdField_a_of_type_Auvx = new auvx(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager = new VasFaceManager(paramQQAppInterface);
    this.jdField_a_of_type_Asgs = new asgs(paramQQAppInterface);
    this.jdField_a_of_type_Azxs = new azxs(paramQQAppInterface);
    this.jdField_a_of_type_Bhwz = new bhwz(paramQQAppInterface);
    this.jdField_a_of_type_Avqr = new avqr(paramQQAppInterface);
    this.jdField_a_of_type_Bidn = new bidn(paramQQAppInterface, paramQQAppInterface.a().createEntityManager());
    this.jdField_a_of_type_Bhzr = new bhzr();
    a(paramQQAppInterface);
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt & 0xF;
    String str = null;
    if (i == 1)
    {
      str = armp.c().mNotifyPaymentText;
      if (TextUtils.isEmpty(str)) {
        break label112;
      }
      i = 0;
      switch (paramInt >> 4)
      {
      default: 
        paramInt = i;
      }
    }
    for (;;)
    {
      if (paramInt == 0) {
        break label112;
      }
      return str.replace("[vip]", BaseApplicationImpl.getContext().getResources().getString(paramInt));
      if (i != 2) {
        break;
      }
      str = armp.c().mExpiredNotifyPaymentText;
      break;
      paramInt = 2131694589;
      continue;
      paramInt = 2131718497;
      continue;
      paramInt = 2131690491;
    }
    label112:
    return "";
  }
  
  public static boolean a()
  {
    if (biim.a().a())
    {
      if (bhnv.b(BaseApplicationImpl.getApplication()) == 0)
      {
        biim.a().a(null, false);
        return true;
      }
      QLog.d("KC.TMSManager", 1, "can only query in mobile connection");
      return true;
    }
    QLog.d("KC.TMSManager", 1, "tms can not work");
    return false;
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 17: 
    case 33: 
      return "mvip.n.a.qlevel_cuifei";
    case 18: 
    case 34: 
      return "mvip.n.a.qlevel_guoqi";
    case 49: 
      return "jhan_qlevel_cuifei";
    }
    return "jhan_qlevel_guoqi";
  }
  
  public static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 17: 
    case 18: 
      return "LTMCLUB";
    case 33: 
    case 34: 
      return "CJCLUBT";
    }
    return "SVHHZLH";
  }
  
  public int a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).getInt("is_show_qq_level_notice", 0);
  }
  
  public void a(int paramInt)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    QLog.e("QQLevelNotice", 1, "setShowQQLevelNoticeValue: " + paramInt + ", " + str);
    BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).edit().putInt("is_show_qq_level_notice", paramInt).commit();
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this.jdField_a_of_type_Bhzr);
      return;
    }
    catch (Error paramQQAppInterface) {}
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Bhzr);
    this.jdField_a_of_type_Auvx.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager.onDestroy();
    this.jdField_a_of_type_Bidn.a();
    this.jdField_a_of_type_Bhwz.onDestroy();
    this.jdField_a_of_type_Avqr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzq
 * JD-Core Version:    0.7.0.1
 */