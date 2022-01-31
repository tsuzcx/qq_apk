import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QZoneLiveJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class anbo
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  public anbo(QZoneLiveJsPlugin paramQZoneLiveJsPlugin, JSONObject paramJSONObject, String paramString, boolean paramBoolean) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    boolean bool = false;
    if (paramPluginManagerClient == null) {}
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneLiveJsPlugin", 2, "context 为空，返回：" + this.jdField_a_of_type_OrgJsonJSONObject);
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", false);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneLiveJsPlugin", 2, "pluginManagerClient 为空，返回：" + this.jdField_a_of_type_OrgJsonJSONObject);
      }
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneLiveJsPlugin.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      return;
    }
    catch (JSONException paramPluginManagerClient)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("QZoneLiveJsPlugin", 2, "", paramPluginManagerClient);
      return;
      if (((PluginBaseInfo)localObject).mState != 4) {
        break label301;
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", true);
      if (!QLog.isColorLevel()) {
        break label272;
      }
      QLog.i("QZoneLiveJsPlugin", 2, "插件已安装，返回：" + this.jdField_a_of_type_OrgJsonJSONObject);
      label272:
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneLiveJsPlugin.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      return;
      label301:
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", false);
      if (!QLog.isColorLevel()) {
        break label371;
      }
      QLog.i("QZoneLiveJsPlugin", 2, "插件未安装,state=" + ((PluginBaseInfo)localObject).mState + "needInstall：" + this.jdField_a_of_type_Boolean + "返回：" + this.jdField_a_of_type_OrgJsonJSONObject);
      label371:
      if (!this.jdField_a_of_type_Boolean) {
        break label449;
      }
      int i = NetworkState.getNetworkType();
      if (!QLog.isColorLevel()) {
        break label424;
      }
      Object localObject = new StringBuilder().append("NetworkState.NET_TYPE_WIFI == type:");
      if (1 != i) {
        break label409;
      }
      bool = true;
      label409:
      QLog.i("QZoneLiveJsPlugin", 2, bool);
      label424:
      if (1 != i) {
        break label449;
      }
      if (!QLog.isColorLevel()) {
        break label443;
      }
      QLog.i("QZoneLiveJsPlugin", 2, "开始下载");
      label443:
      paramPluginManagerClient.installPlugin("qzone_live_video_plugin.apk");
      label449:
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneLiveJsPlugin.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
    }
    localObject = paramPluginManagerClient.queryPlugin("qzone_live_video_plugin.apk");
    if (localObject == null)
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", false);
      if (QLog.isColorLevel()) {
        QLog.i("QZoneLiveJsPlugin", 2, "pluginInfo 为空，返回：" + this.jdField_a_of_type_OrgJsonJSONObject);
      }
      this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneLiveJsPlugin.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbo
 * JD-Core Version:    0.7.0.1
 */