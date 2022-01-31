import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.QuickLoginAuthorityActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.RSACrypt;
import oicq.wlogin_sdk.tools.util;

public class bfci
  extends SSOAccountObserver
{
  public bfci(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onFailed--action = " + paramInt1 + ", ret = " + paramInt2 + ", ssoAccount = *" + bfdz.a(paramString));
    this.a.f();
    if (paramInt2 == -1000)
    {
      this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a, this.a.getResources().getString(2131695063));
      return;
    }
    paramBundle = (ErrMsg)paramBundle.getParcelable("lastError");
    if (paramBundle == null) {}
    for (paramBundle = this.a.getString(2131695059);; paramBundle = paramBundle.getMessage())
    {
      QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, new Object[] { "ssoAccount failed, error: ", paramBundle });
      QQToast.a(BaseApplicationImpl.getContext(), paramBundle + "(" + paramInt2 + ")", 0).a();
      this.a.a(paramString);
      return;
    }
  }
  
  public void onGetA1WithA1(String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, Bundle paramBundle)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onGetA1WithA1--ret = " + paramInt1 + ", ssoAccount = *" + bfdz.a(paramString));
    paramString = "" + this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a.jdField_a_of_type_MqqManagerWtloginManager, paramString);
    this.a.jdField_a_of_type_JavaLangString = paramString;
    this.a.b = null;
    paramString = new WloginSimpleInfo();
    this.a.jdField_a_of_type_MqqManagerWtloginManager.GetBasicUserInfo(this.a.jdField_a_of_type_JavaLangString, paramString);
    paramArrayOfByte = new RSACrypt(this.a).EncryptData(this.a.jdField_a_of_type_ArrayOfByte, paramArrayOfByte);
    paramString = (ErrMsg)paramBundle.getParcelable("errMsg");
    paramBundle = this.a;
    String str = this.a.jdField_a_of_type_JavaLangString;
    if (paramString == null) {}
    for (paramString = "";; paramString = paramString.getMessage())
    {
      paramBundle.a(paramInt1, paramArrayOfByte, str, paramString);
      return;
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onGetTicketNoPasswd--ssoAccount = *" + bfdz.a(paramString));
    this.a.b = null;
    if ((this.a.jdField_a_of_type_AndroidOsBundle.containsKey("qrcode")) && (this.a.jdField_a_of_type_AndroidOsBundle.containsKey("schemacallback"))) {
      QuickLoginAuthorityActivity.a(this.a);
    }
    while (!this.a.jdField_a_of_type_AndroidOsBundle.containsKey("p")) {
      return;
    }
    aomn localaomn = (aomn)aogj.a().a(546);
    paramBundle = "";
    if (paramInt == 32) {
      paramBundle = util.buf_to_string(paramArrayOfByte);
    }
    String str1 = this.a.jdField_a_of_type_AndroidOsBundle.getString("p");
    paramArrayOfByte = str1;
    if (!TextUtils.isEmpty(str1))
    {
      paramArrayOfByte = str1;
      if (!str1.endsWith("&")) {
        paramArrayOfByte = str1 + "&";
      }
    }
    paramString = "keyindex=19&clientuin=$CLIENTUIN$&clientkey=$CLIENTKEY$".replace("$CLIENTUIN$", paramString).replace("$CLIENTKEY$", paramBundle);
    String str3 = paramArrayOfByte + paramString;
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str3));
    paramBundle = null;
    str1 = null;
    String str2 = this.a.jdField_a_of_type_AndroidOsBundle.getString("schemacallback");
    paramString = str1;
    if (!TextUtils.isEmpty(str2))
    {
      if (str2.startsWith("mttbrowser://")) {
        paramString = "com.tencent.mtt";
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label813;
      }
      paramArrayOfByte = Uri.parse(paramArrayOfByte).getQueryParameter("pt_browser");
      QLog.i("SSOAccountObserver", 1, "-->onGetTicketNoPasswd--schemacallback=" + str2 + ",pt_browser=" + paramArrayOfByte);
      if ((TextUtils.isEmpty(paramArrayOfByte)) || (!"LieBaoFast".equals(paramArrayOfByte))) {
        break label813;
      }
      paramString = "com.ijinshan.browser_fast";
    }
    label806:
    label813:
    for (;;)
    {
      for (;;)
      {
        paramInt = 0;
        if (!TextUtils.isEmpty(paramString)) {}
        try
        {
          paramArrayOfByte = this.a.getPackageManager().getPackageInfo(paramString, 0);
          if (localaomn.jdField_a_of_type_Int == 1)
          {
            paramBundle = (String)localaomn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
            if ((this.a.a(paramString, paramBundle)) && (paramArrayOfByte != null))
            {
              paramInt = 1;
              if (paramInt != 0)
              {
                localIntent.setPackage(paramString);
                localIntent.setData(Uri.parse(str3));
              }
              if ((localaomn.b != 1) || (paramInt != 0)) {
                break label754;
              }
              this.a.f();
              QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131711616), 1).a();
              paramArrayOfByte = new HashMap();
              paramArrayOfByte.put("callback", str2);
              if (paramInt == 0) {
                break label806;
              }
              paramString = "1";
              paramArrayOfByte.put("checkRes", paramString);
              azmz.a(BaseApplicationImpl.getContext()).a("", "kQuickLoginForBrowser", true, 0L, 0L, paramArrayOfByte, "");
              return;
              if (str2.startsWith("ucweb://"))
              {
                paramString = "com.UCMobile";
                break;
              }
              if (str2.startsWith("bdbrowser://"))
              {
                paramString = "com.baidu.browser.apps";
                break;
              }
              if (str2.startsWith("bdapp://"))
              {
                paramString = "com.baidu.searchbox";
                break;
              }
              if (str2.startsWith("googlechrome://"))
              {
                paramString = "com.android.chrome";
                break;
              }
              if (str2.startsWith("mzbrowser://"))
              {
                paramString = "com.android.browser";
                break;
              }
              if (str2.startsWith("lb://"))
              {
                paramString = "com.ijinshan.browser_fast";
                break;
              }
              if (str2.startsWith("qihoobrowser://"))
              {
                paramString = "com.qihoo.browser";
                break;
              }
              if (str2.startsWith("browser2345://"))
              {
                paramString = "com.browser2345";
                break;
              }
              paramString = str1;
              if (!str2.startsWith("SogouMSE://")) {
                break;
              }
              paramString = "sogou.mobile.explorer";
            }
          }
        }
        catch (PackageManager.NameNotFoundException paramArrayOfByte)
        {
          for (;;)
          {
            QLog.e("SSOAccountObserver", 1, "-->onGetTicketNoPasswd exception:" + paramArrayOfByte.getStackTrace().toString());
            paramArrayOfByte = paramBundle;
            continue;
            paramInt = 0;
            continue;
            if (paramArrayOfByte != null)
            {
              paramInt = 1;
            }
            else
            {
              paramInt = 0;
              continue;
              try
              {
                label754:
                this.a.startActivity(localIntent);
                this.a.e();
              }
              catch (Exception paramString)
              {
                for (;;)
                {
                  QLog.e("Q.quicklogin.QuickLoginAuthorityActivity", 1, "startActivity :" + paramString.getMessage());
                }
              }
              paramString = "0";
            }
          }
        }
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "-->onUserCancel--action = " + paramInt + ", ssoAccount = *" + bfdz.a(paramString));
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfci
 * JD-Core Version:    0.7.0.1
 */