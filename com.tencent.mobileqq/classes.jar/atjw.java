import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import cooperation.plugin.PluginInfo;
import cooperation.troop.TroopManageProxyActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class atjw
  implements yrb
{
  public atjw(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = 12;
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("isSuccess"))
      {
        paramBundle = new Intent();
        paramBundle.putExtra("troop_uin", this.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a() != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a().switchRequestCode(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin, (byte)12);
        }
        TroopManageProxyActivity.a("troop_manage_plugin.apk", PluginInfo.j, TroopManageProxyActivity.class, this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a(), paramBundle, TroopManageProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a()), "com.tencent.mobileqq.activity.TroopSetJoinTypeActivity", this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a().getAccount(), i);
      }
    }
    else {
      return;
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("gc", this.jdField_a_of_type_JavaLangString);
      paramBundle.put("ret", 1);
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.callJs(this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.m, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjw
 * JD-Core Version:    0.7.0.1
 */