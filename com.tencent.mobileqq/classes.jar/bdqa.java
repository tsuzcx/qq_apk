import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class bdqa
  implements Manager
{
  public apju a;
  public apos a;
  public arsj a;
  public asnd a;
  public awml a;
  public bdnm a;
  private bdqb a;
  public bdsn a;
  public QQAppInterface a;
  public VasFaceManager a;
  
  public bdqa(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Apos = new apos(paramQQAppInterface);
    this.jdField_a_of_type_Arsj = new arsj(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager = new VasFaceManager(paramQQAppInterface);
    this.jdField_a_of_type_Apju = new apju(paramQQAppInterface);
    this.jdField_a_of_type_Awml = new awml(paramQQAppInterface);
    this.jdField_a_of_type_Bdnm = new bdnm(paramQQAppInterface);
    this.jdField_a_of_type_Asnd = new asnd(paramQQAppInterface);
    this.jdField_a_of_type_Bdsn = new bdsn(paramQQAppInterface);
    this.jdField_a_of_type_Bdqb = new bdqb();
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this.jdField_a_of_type_Bdqb);
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt & 0xF;
    String str = null;
    if (i == 1)
    {
      str = aoqg.c().mNotifyPaymentText;
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
      str = aoqg.c().mExpiredNotifyPaymentText;
      break;
      paramInt = 2131695644;
      continue;
      paramInt = 2131720510;
      continue;
      paramInt = 2131690515;
    }
    label112:
    return "";
  }
  
  public static boolean a()
  {
    if (bdwm.a().a())
    {
      if (bdee.b(BaseApplicationImpl.getApplication()) == 0)
      {
        bdwm.a().a(null, false);
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
  
  public void a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).edit().putBoolean("is_show_host_qq_level_guide", paramBoolean).commit();
  }
  
  public boolean b()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    return BaseApplicationImpl.sApplication.getSharedPreferences(str, 4).getBoolean("is_show_host_qq_level_guide", true);
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Bdqb);
    this.jdField_a_of_type_Arsj.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager.onDestroy();
    this.jdField_a_of_type_Bdsn.a();
    this.jdField_a_of_type_Bdnm.onDestroy();
    this.jdField_a_of_type_Asnd.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqa
 * JD-Core Version:    0.7.0.1
 */