import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class avzz
  extends WebViewPlugin
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  
  public avzz()
  {
    this.mPluginNameSpace = "medalwall";
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "clearRedPoint from web!");
    }
    aqmz.a().a();
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
        c(this.jdField_a_of_type_JavaLangString);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("MedalApi", 2, "shareMsg error: " + paramString.toString());
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_JavaLangString = new JSONObject(paramString).optString("callback");
        startActivityForResult(new Intent(this.jdField_a_of_type_AndroidContentContext, PermisionPrivacyActivity.class), (byte)100);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("MedalApi", 2, "shareMsg error: " + paramString.toString());
  }
  
  private void c(String paramString)
  {
    String str = this.mRuntime.a().getCurrentAccountUin();
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + str, 4).getBoolean("medal_switch_disable", false);
    if (!TextUtils.isEmpty(paramString)) {
      if (!bool) {
        break label74;
      }
    }
    label74:
    for (str = "{\"isOn\":0}";; str = "{\"isOn\":1}")
    {
      callJs(paramString, new String[] { str });
      return;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ("medalwall".equals(paramString2))
    {
      if ((paramJsBridgeListener != null) && (paramJsBridgeListener.a)) {}
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      if (!"getMedalSwitch".equals(paramString3)) {
        break label54;
      }
      a(paramVarArgs[0]);
    }
    for (;;)
    {
      bool = true;
      return bool;
      label54:
      if ("jumpToMedalSettings".equals(paramString3)) {
        b(paramVarArgs[0]);
      } else if ("clearRedPoint".equals(paramString3)) {
        a();
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 100) {
      c(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzz
 * JD-Core Version:    0.7.0.1
 */