import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class bjxn
  extends bjxz
{
  private static final String a;
  private static String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = bjxr.class.getSimpleName();
  }
  
  private void a(begz parambegz, String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      b = paramArrayOfString.getString("callback");
      parambegz = new Bundle();
      parambegz.putInt("key_personal_album_enter_model", 0);
      parambegz.putBoolean("key_pass_result_by_bundle", true);
      parambegz.putString("key_accept_album_anonymity", paramArrayOfString.optString("acceptType"));
      parambegz.putString("key_deny_delect_tips", paramArrayOfString.optString("denyTips"));
      parambegz.putBoolean("key_can_new_album", false);
      parambegz.putString("key_from_type", paramArrayOfString.optString("fromType"));
      paramArrayOfString = bjea.a();
      paramArrayOfString.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a().getCurrentAccountUin();
      parambegz.putBoolean("key_need_change_to_jpg", false);
      bjdt.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime.a(), paramArrayOfString, parambegz, bjdt.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin, this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, 7));
      return;
    }
    catch (Exception parambegz)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w(jdField_a_of_type_JavaLangString, 2, "handlePickQzoneAlbum,decode param error");
    }
  }
  
  public void a(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    }
    do
    {
      return;
    } while ((TextUtils.isEmpty(b)) || (paramIntent == null));
    String str1 = paramIntent.getStringExtra("key_selected_albuminfo.id");
    String str2 = paramIntent.getStringExtra("key_selected_albuminfo.name");
    paramIntent.getStringExtra("key_selected_albuminfo.cover");
    paramIntent.getIntExtra("key_selected_albuminfo.permission", 0);
    paramByte = paramIntent.getIntExtra("key_selected_albuminfo.type", 0);
    paramInt = paramIntent.getIntExtra("key_selected_albuminfo.anonymity", 0);
    paramIntent = new JSONObject();
    try
    {
      paramIntent.put("albumid", str1);
      paramIntent.put("albumtype", paramByte);
      paramIntent.put("albumname", str2);
      paramIntent.put("albumanonymity", paramInt);
      if (QLog.isDevelopLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 4, paramIntent.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.callJs(b, new String[] { paramIntent.toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin == null) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime == null)) {}
    while (!paramString3.equalsIgnoreCase("PickQzoneAlbum")) {
      return false;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPlugin.mRuntime, paramVarArgs);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjxn
 * JD-Core Version:    0.7.0.1
 */