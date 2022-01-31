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

public class bbrg
  implements Manager
{
  public ansm a;
  public anxg a;
  public apzh a;
  public aqwp a;
  public auuz a;
  public bbos a;
  private bbrh a;
  public bbtq a;
  public QQAppInterface a;
  public VasFaceManager a;
  
  public bbrg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Anxg = new anxg(paramQQAppInterface);
    this.jdField_a_of_type_Apzh = new apzh(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager = new VasFaceManager(paramQQAppInterface);
    this.jdField_a_of_type_Ansm = new ansm(paramQQAppInterface);
    this.jdField_a_of_type_Auuz = new auuz(paramQQAppInterface);
    this.jdField_a_of_type_Bbos = new bbos(paramQQAppInterface);
    this.jdField_a_of_type_Aqwp = new aqwp(paramQQAppInterface);
    this.jdField_a_of_type_Bbtq = new bbtq(paramQQAppInterface);
    this.jdField_a_of_type_Bbrh = new bbrh();
    AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this.jdField_a_of_type_Bbrh);
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt & 0xF;
    String str = null;
    if (i == 1)
    {
      str = amyz.c().mNotifyPaymentText;
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
      str = amyz.c().mExpiredNotifyPaymentText;
      break;
      paramInt = 2131695486;
      continue;
      paramInt = 2131719975;
      continue;
      paramInt = 2131690464;
    }
    label112:
    return "";
  }
  
  public static boolean a()
  {
    if (bbxl.a().a())
    {
      if (bbfj.b(BaseApplicationImpl.getApplication()) == 0)
      {
        bbxl.a().a(null, false);
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
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Bbrh);
    this.jdField_a_of_type_Apzh.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager.onDestroy();
    this.jdField_a_of_type_Bbtq.a();
    this.jdField_a_of_type_Bbos.onDestroy();
    this.jdField_a_of_type_Aqwp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrg
 * JD-Core Version:    0.7.0.1
 */