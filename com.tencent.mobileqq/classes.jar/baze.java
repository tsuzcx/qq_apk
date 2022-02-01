import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class baze
  extends VasWebviewJsPlugin
{
  public byte a;
  private String a;
  
  public baze()
  {
    this.jdField_a_of_type_Byte = 1;
    this.mPluginNameSpace = "RealName";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RealName", 2, "handleJsRequest url: " + paramString1 + " pkgName: " + paramString2 + " method: " + paramString3 + " args: " + paramVarArgs[0]);
    }
    if (!paramString2.equalsIgnoreCase("RealName")) {
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      return false;
    }
    if (paramString3.equalsIgnoreCase("getCountryCode"))
    {
      paramJsBridgeListener = paramVarArgs[0];
      try
      {
        this.jdField_a_of_type_JavaLangString = new JSONObject(paramJsBridgeListener).getString("callbackId");
        paramJsBridgeListener = (BaseActivity)this.mRuntime.a();
        if (paramJsBridgeListener == null) {
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          paramJsBridgeListener.printStackTrace();
        }
        return false;
      }
      startActivityForResult(new Intent(paramJsBridgeListener, CountryActivity.class), this.jdField_a_of_type_Byte);
    }
    for (;;)
    {
      return true;
      if (paramString3.equalsIgnoreCase("onAuthResult"))
      {
        paramJsBridgeListener = paramVarArgs[0];
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener);
          int i = paramJsBridgeListener.getInt("result");
          paramJsBridgeListener = paramJsBridgeListener.optString("from", "");
          paramString1 = new Bundle();
          paramString1.putInt("result", i);
          paramString1.putString("source", paramJsBridgeListener);
          QIPCClientHelper.getInstance().getClient().callServer("REAL_NAME", "ON_WEB_AUTH_RESULT", paramString1);
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            paramJsBridgeListener.printStackTrace();
          }
          return false;
        }
      }
      else if (paramString3.equalsIgnoreCase("getDeviceInfo"))
      {
        paramJsBridgeListener = paramVarArgs[0];
        try
        {
          paramJsBridgeListener = new JSONObject(paramJsBridgeListener).getString("callbackId");
          paramString1 = this.mRuntime.a();
          paramString1 = ((TicketManager)paramString1.getManager(2)).getA2(paramString1.getAccount());
          paramString2 = new String(NetConnInfoCenter.GUID);
          paramString3 = new JSONObject();
          try
          {
            paramString3.put("appid", String.valueOf(AppSetting.a()));
            paramString3.put("imei", blhc.a("ef0716"));
            paramString3.put("guid", paramString2);
            paramString3.put("A2", paramString1);
            callJs(paramJsBridgeListener, new String[] { paramString3.toString() });
          }
          catch (JSONException paramJsBridgeListener) {}
          if (QLog.isDevelopLevel()) {
            paramJsBridgeListener.printStackTrace();
          }
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (QLog.isColorLevel()) {
            paramJsBridgeListener.printStackTrace();
          }
        }
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    byte b = 0;
    JSONObject localJSONObject = new JSONObject();
    Object localObject = "";
    String str1 = "";
    if ((paramByte == this.jdField_a_of_type_Byte) && (paramInt == -1)) {
      if (paramIntent != null)
      {
        str1 = paramIntent.getStringExtra("k_name");
        String str2 = paramIntent.getStringExtra("k_code");
        paramIntent = str2;
        localObject = str1;
        paramByte = b;
        if (QLog.isColorLevel())
        {
          QLog.i("RealName", 2, "onActivity countryName is: " + str1 + " countryCode: " + str2);
          paramByte = b;
          localObject = str1;
          paramIntent = str2;
        }
      }
    }
    try
    {
      for (;;)
      {
        localJSONObject.put("retCode", paramByte);
        localJSONObject.put("country", localObject);
        localJSONObject.put("value", paramIntent);
        callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
        if (QLog.isColorLevel()) {
          QLog.i("RealName", 2, "onActivityResult, intent is null.");
        }
        paramByte = -1;
        paramIntent = str1;
      }
    }
    catch (JSONException paramIntent)
    {
      while (!QLog.isDevelopLevel()) {}
      paramIntent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baze
 * JD-Core Version:    0.7.0.1
 */