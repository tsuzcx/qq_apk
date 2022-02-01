import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;
import org.json.JSONObject;

public class awgy
  extends WebViewPlugin
{
  public awgy()
  {
    this.mPluginNameSpace = "login";
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity instanceof BasePluginActivity); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("login".equals(paramString2)) && ("openSmsPage".equals(paramString3))) {}
    for (;;)
    {
      int j;
      int i;
      try
      {
        addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = paramJsBridgeListener.optString("countryCode");
        paramString2 = paramJsBridgeListener.optString("uin");
        paramString3 = paramJsBridgeListener.optString("phone");
        j = paramJsBridgeListener.optInt("mentrance");
        int k = Integer.parseInt(paramJsBridgeListener.optString("verifySeq"));
        if (paramJsBridgeListener.optInt("isFromOpenSdk", 0) != 1) {
          break label260;
        }
        i = 1;
        if (i != 0)
        {
          paramJsBridgeListener = new Intent(a(), AuthDevVerifyCodeActivity2.class);
          paramJsBridgeListener.putExtra("phone_num", paramString3);
          paramJsBridgeListener.putExtra("country_code", paramString1);
          paramJsBridgeListener.putExtra("mobile_type", 0);
          paramJsBridgeListener.putExtra("from_login", true);
          paramJsBridgeListener.putExtra("uin", paramString2);
          paramJsBridgeListener.putExtra("seq", k);
          startActivityForResult(paramJsBridgeListener, (byte)12);
          paramJsBridgeListener = "";
          if (j == 1)
          {
            paramJsBridgeListener = "1";
            bdll.a(null, "dc00898", "", "", "0X800ADE1", "0X800ADE1", 0, 0, paramJsBridgeListener, "", "", "");
            return true;
          }
        }
        else
        {
          paramJsBridgeListener = new Intent(a(), AuthDevVerifyCodeActivity.class);
          continue;
          return false;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.e("LoginPlugin", 1, new Object[] { "deal login jsbridge error : ", paramJsBridgeListener.getMessage() });
      }
      if (j == 2)
      {
        paramJsBridgeListener = "2";
        continue;
        label260:
        i = 0;
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgy
 * JD-Core Version:    0.7.0.1
 */