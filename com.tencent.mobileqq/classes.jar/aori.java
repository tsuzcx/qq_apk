import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
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
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

public class aori
{
  private static volatile aori jdField_a_of_type_Aori;
  private aoro jdField_a_of_type_Aoro;
  private bhpc jdField_a_of_type_Bhpc;
  
  private Context a()
  {
    Object localObject;
    if (this.jdField_a_of_type_Bhpc == null) {
      localObject = null;
    }
    Context localContext;
    do
    {
      do
      {
        return localObject;
        localContext = this.jdField_a_of_type_Bhpc.getContext();
        localObject = localContext;
      } while ((localContext instanceof Activity));
      localObject = localContext;
    } while (!(localContext instanceof ContextThemeWrapper));
    return ((ContextThemeWrapper)localContext).getBaseContext();
  }
  
  public static aori a()
  {
    if (jdField_a_of_type_Aori == null) {}
    try
    {
      if (jdField_a_of_type_Aori == null) {
        jdField_a_of_type_Aori = new aori();
      }
      return jdField_a_of_type_Aori;
    }
    finally {}
  }
  
  private <T> T a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString2).opt(paramString1);
      if (paramString1 != null) {
        return paramString1;
      }
    }
    catch (JSONException paramString1)
    {
      QLog.e("AccountIdentityManager", 1, new Object[] { "getValueFromPayload JSONException : ", paramString1.getMessage() });
      return null;
    }
    catch (ClassCastException paramString1)
    {
      for (;;)
      {
        QLog.e("AccountIdentityManager", 1, new Object[] { "getValueFromPayload ClassCastException : ", paramString1.getMessage() });
      }
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (jdField_a_of_type_Aori != null) {
      jdField_a_of_type_Aori.b(paramActivity);
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Bhpc = null;
    if (this.jdField_a_of_type_Aoro != null) {}
    try
    {
      paramContext.unregisterReceiver(this.jdField_a_of_type_Aoro);
      this.jdField_a_of_type_Aoro = null;
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
  
  private void a(QQAppInterface paramQQAppInterface, cmd0x9ae.RspBody paramRspBody, ayxn paramayxn)
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
      paramayxn.a("OidbSvc.0x9ae_13", -1, null);
    }
    do
    {
      return;
      str5 = aors.a(paramRspBody, "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvpgaMJnHS3HZLto4PIoH\n8LLs/QBNSWe0jEMxWulLOPfpC3jh+jbuVAv/65lDoJEoisvBNB5eAkILd9iI8IIQ\nAaW8ehqYat32ggZTtuJ52NZWLAZtMIMk/eL2Un+o+/7ZA+P3u8aCzbruWZyR01lw\n31GchZfLcv5BeGEDHvGyrArsjAnWsoW8/jJhdqbiVBIsgMh+k+n2rEKX1iG81ATb\nktbp2mTBLxpJSExuM3FhEOPTiosz4TTbuC5oI4VMKpqsUWYkav66v3f3jKkof1ym\nUiC+tqkuDzHcRDRzy8BKCwIrv290FOY5TixXHbNcKupks4Z82H9kE/dUNb+gjssz\nIQIDAQAB\n-----END PUBLIC KEY-----");
      if (str5 == null)
      {
        QLog.e("AccountIdentityManager", 1, "error : jwt parse error");
        paramayxn.a("OidbSvc.0x9ae_13", -1, null);
        return;
      }
      bhsi.a(BaseApplicationImpl.getContext(), str6, true, "account_identity_time", paramRspBody);
      if (!bool1) {
        break;
      }
    } while (!a());
    this.jdField_a_of_type_Bhpc.dismiss();
    return;
    if (a())
    {
      QLog.d("AccountIdentityManager", 1, "refreshAuthorityState showDialog, but dialog is showing");
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new AccountIdentityManager.2(this, str1, str2, str3, str4, (String)localObject, str5, paramQQAppInterface), 700L);
  }
  
  private boolean a(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = aors.a(paramString, "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvpgaMJnHS3HZLto4PIoH\n8LLs/QBNSWe0jEMxWulLOPfpC3jh+jbuVAv/65lDoJEoisvBNB5eAkILd9iI8IIQ\nAaW8ehqYat32ggZTtuJ52NZWLAZtMIMk/eL2Un+o+/7ZA+P3u8aCzbruWZyR01lw\n31GchZfLcv5BeGEDHvGyrArsjAnWsoW8/jJhdqbiVBIsgMh+k+n2rEKX1iG81ATb\nktbp2mTBLxpJSExuM3FhEOPTiosz4TTbuC5oI4VMKpqsUWYkav66v3f3jKkof1ym\nUiC+tqkuDzHcRDRzy8BKCwIrv290FOY5TixXHbNcKupks4Z82H9kE/dUNb+gjssz\nIQIDAQAB\n-----END PUBLIC KEY-----");
      if (paramString != null) {
        try
        {
          paramString = new JSONObject(paramString);
          long l1 = paramString.optLong("iat");
          long l2 = paramString.optLong("exp");
          if ((paramLong > l1) && (paramLong < l2)) {
            return true;
          }
        }
        catch (JSONException paramString)
        {
          QLog.e("AccountIdentityManager", 1, new Object[] { "parse payload error : ", paramString.getMessage() });
        }
      }
    }
    return false;
  }
  
  private void b(Activity paramActivity)
  {
    if ((a()) && (a() == paramActivity)) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
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
        if (!a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AccountIdentityManager", 2, "checkAccountIdentityState, dialog is showing");
      return;
      String str = paramQQAppInterface.getAccount();
      if (!a((String)bhsi.a(BaseApplicationImpl.getContext(), str, "account_identity_time", ""), NetConnInfoCenter.getServerTime())) {
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
    boolean bool2 = a(paramString6);
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      this.jdField_a_of_type_Bhpc = bhlq.a(localBaseActivity, paramString5, paramString4, paramString1, paramString2, bool1, 5, new aork(this, bool2, localBaseActivity, paramQQAppInterface), new aorl(this, localBaseActivity, paramString3, bool2, paramQQAppInterface));
      this.jdField_a_of_type_Bhpc.setOnDismissListener(new aorm(this, localBaseActivity));
      this.jdField_a_of_type_Bhpc.setOnCancelListener(new aorn(this, localBaseActivity));
      this.jdField_a_of_type_Bhpc.show();
      if (!bool2) {
        break label178;
      }
    }
    label178:
    for (paramString1 = "0X800B275";; paramString1 = "0X800B272")
    {
      bdll.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, "", "", "", "");
      return;
      bool1 = false;
      break;
    }
  }
  
  boolean a()
  {
    int i;
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing()))
    {
      i = 1;
      if (a() != BaseActivity.sTopActivity) {
        break label86;
      }
    }
    label86:
    for (int j = 1;; j = 0)
    {
      if ((i != 0) && (j == 0))
      {
        QLog.d("AccountIdentityManager", 1, "curTopActivity is not same as dialogContext");
        this.jdField_a_of_type_Bhpc.dismiss();
        if (BaseActivity.sTopActivity != null) {
          b(BaseActivity.sTopActivity.app);
        }
      }
      if ((i == 0) || (j == 0)) {
        break label91;
      }
      return true;
      i = 0;
      break;
    }
    label91:
    return false;
  }
  
  public boolean a(String paramString)
  {
    paramString = (Boolean)a("force", paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.booleanValue();
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface == null) || (!paramQQAppInterface.isLogin()))
    {
      QLog.d("AccountIdentityManager", 1, "refreshAuthorityState, appInterface is null or is not login");
      return;
    }
    bcvd.a(paramQQAppInterface, new aorj(this, paramQQAppInterface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aori
 * JD-Core Version:    0.7.0.1
 */