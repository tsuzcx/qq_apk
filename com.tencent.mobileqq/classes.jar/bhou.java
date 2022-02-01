import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.qvip.QQLevelIconConfig;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class bhou
  implements Manager
{
  public asfa a;
  public asjs a;
  public aumm a;
  public avjn a;
  public azrc a;
  public bhmb a;
  private bhov a;
  public bhsv a;
  public QQAppInterface a;
  public VasFaceManager a;
  
  public bhou(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Asjs = new asjs(paramQQAppInterface);
    this.jdField_a_of_type_Aumm = new aumm(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager = new VasFaceManager(paramQQAppInterface);
    this.jdField_a_of_type_Asfa = new asfa(paramQQAppInterface);
    this.jdField_a_of_type_Azrc = new azrc(paramQQAppInterface);
    this.jdField_a_of_type_Bhmb = new bhmb(paramQQAppInterface);
    this.jdField_a_of_type_Avjn = new avjn(paramQQAppInterface);
    this.jdField_a_of_type_Bhsv = new bhsv(paramQQAppInterface, paramQQAppInterface.getEntityManagerFactory().createEntityManager());
    this.jdField_a_of_type_Bhov = new bhov();
    a(paramQQAppInterface);
  }
  
  public static String a(int paramInt)
  {
    int i = paramInt & 0xF;
    String str = null;
    if (i == 1)
    {
      str = arjt.c().mNotifyPaymentText;
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
      str = arjt.c().mExpiredNotifyPaymentText;
      break;
      paramInt = 2131694908;
      continue;
      paramInt = 2131719134;
      continue;
      paramInt = 2131690606;
    }
    label112:
    return "";
  }
  
  public static boolean a()
  {
    if (bhzh.a().a())
    {
      if (NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication()) == 0)
      {
        bhzh.a().a(null, false);
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
      AppNetConnInfo.registerConnectionChangeReceiver(paramQQAppInterface.getApp(), this.jdField_a_of_type_Bhov);
      return;
    }
    catch (Error paramQQAppInterface) {}
  }
  
  public void onDestroy()
  {
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Bhov);
    this.jdField_a_of_type_Aumm.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasFaceManager.onDestroy();
    this.jdField_a_of_type_Bhsv.a();
    this.jdField_a_of_type_Bhmb.onDestroy();
    this.jdField_a_of_type_Avjn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhou
 * JD-Core Version:    0.7.0.1
 */