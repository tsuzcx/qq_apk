import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.identity.AccountIdentityManager.2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

public class aomk
  extends aona
{
  private static volatile aomk jdField_a_of_type_Aomk;
  private aomq jdField_a_of_type_Aomq;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  
  public static aomk a()
  {
    if (jdField_a_of_type_Aomk == null) {}
    try
    {
      if (jdField_a_of_type_Aomk == null) {
        jdField_a_of_type_Aomk = new aomk();
      }
      return jdField_a_of_type_Aomk;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    if (this.jdField_a_of_type_Aomq != null) {}
    try
    {
      paramContext.unregisterReceiver(this.jdField_a_of_type_Aomq);
      this.jdField_a_of_type_Aomq = null;
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.d("AccountIdentityManager", 1, new Object[] { "DismissListener unregisterReceiver error : ", paramContext.getMessage() });
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, cmd0x9ae.RspBody paramRspBody, ayra paramayra)
  {
    boolean bool1 = paramRspBody.bool_has_been_authenticated.get();
    boolean bool2 = paramRspBody.bool_need_auth_tips.get();
    Object localObject = (cmd0x9ae.AuthTips)paramRspBody.msg_auth_tips.get();
    String str1 = ((cmd0x9ae.AuthTips)localObject).string_lbutton.get();
    String str2 = ((cmd0x9ae.AuthTips)localObject).string_rbutton.get();
    String str5 = ((cmd0x9ae.AuthTips)localObject).string_tips_action.get();
    String str3 = ((cmd0x9ae.AuthTips)localObject).string_tips_action_url.get();
    String str4 = ((cmd0x9ae.AuthTips)localObject).string_tips_context.get();
    localObject = ((cmd0x9ae.AuthTips)localObject).string_tips_title.get();
    paramRspBody = paramRspBody.bytes_jwt.get().toStringUtf8();
    String str6 = paramQQAppInterface.getAccount();
    if (QLog.isColorLevel()) {
      QLog.d("AccountIdentityManager", 2, new Object[] { "success, isAuthenticated : ", Boolean.valueOf(bool1), " needAuth : ", Boolean.valueOf(bool2), " leftText : ", str1, " rightText : ", str2, " tipsAction : ", str5, " url : ", str3, " content : ", str4, " title : ", localObject, " jwt : ", paramRspBody });
    }
    if (TextUtils.isEmpty(paramRspBody))
    {
      QLog.e("AccountIdentityManager", 1, "error : jwt is empty");
      paramayra.onFailedResponse("OidbSvc.0x9ae_13", -1, null);
    }
    do
    {
      return;
      str5 = aonc.a(paramRspBody);
      if (str5 == null)
      {
        QLog.e("AccountIdentityManager", 1, "error : jwt parse error");
        paramayra.onFailedResponse("OidbSvc.0x9ae_13", -1, null);
        return;
      }
      bhhr.a(BaseApplicationImpl.getContext(), str6, true, "account_identity_time", paramRspBody);
      if (!bool1) {
        break;
      }
    } while (!aonc.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    return;
    if (aonc.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog))
    {
      QLog.d("AccountIdentityManager", 1, "refreshAuthorityState showDialog, but dialog is showing");
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new AccountIdentityManager.2(this, str1, str2, str3, str4, (String)localObject, str5, paramQQAppInterface), 700L);
  }
  
  private void b(Activity paramActivity)
  {
    if (aonc.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog))
    {
      if (!aonc.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, paramActivity)) {
        break label29;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    label29:
    while (BaseActivity.sTopActivity == null) {
      return;
    }
    b(BaseActivity.sTopActivity.app);
  }
  
  public void a()
  {
    a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void a(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isLogin())) {
      QLog.d("AccountIdentityManager", 1, "checkAccountIdentityState, appInterface is null or is not login");
    }
    do
    {
      do
      {
        return;
        if (!aonc.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountIdentityManager", 2, "checkAccountIdentityState, dialog is showing");
      return;
      String str = paramQQAppInterface.getAccount();
      if (!aonc.a((String)bhhr.a(BaseApplicationImpl.getContext(), str, "account_identity_time", ""), NetConnInfoCenter.getServerTime())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AccountIdentityManager", 2, "checkAccountIdentityState, is not time");
    return;
    b(paramQQAppInterface);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, QQAppInterface paramQQAppInterface)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing()))
    {
      QLog.e("AccountIdentityManager", 1, "create dialog, but activity is finishing");
      return;
    }
    boolean bool2 = aonc.a(paramString6);
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = aonc.a(localBaseActivity, paramString1, paramString2, paramString4, paramString5, bool1, new aomm(this, bool2, localBaseActivity, paramQQAppInterface), new aomn(this, localBaseActivity, paramString3, bool2, paramQQAppInterface));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new aomo(this, localBaseActivity));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnCancelListener(new aomp(this, localBaseActivity));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      if (!bool2) {
        break label176;
      }
    }
    label176:
    for (paramString1 = "0X800B275";; paramString1 = "0X800B272")
    {
      bdla.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
      return;
      bool1 = false;
      break;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isLogin()))
    {
      QLog.d("AccountIdentityManager", 1, "refreshAuthorityState, appInterface is null or is not login");
      return;
    }
    bcvh.a(paramQQAppInterface, new aoml(this, paramQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomk
 * JD-Core Version:    0.7.0.1
 */