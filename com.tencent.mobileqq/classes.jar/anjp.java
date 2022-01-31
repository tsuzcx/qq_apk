import android.os.RemoteException;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.IQZonePluginManager;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.plugin.QZonePluginMangerHelper.OnQzonePluginClientReadyListner;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.webviewplugin.QZoneLiveJsPlugin;
import org.json.JSONException;
import org.json.JSONObject;

public class anjp
  implements QZonePluginMangerHelper.OnQzonePluginClientReadyListner
{
  public anjp(QZoneLiveJsPlugin paramQZoneLiveJsPlugin, JSONObject paramJSONObject, boolean paramBoolean, String paramString) {}
  
  public void a(IQZonePluginManager paramIQZonePluginManager)
  {
    if (paramIQZonePluginManager == null) {
      return;
    }
    try
    {
      localPluginRecord = paramIQZonePluginManager.a("qzone_live_video_plugin_hack.apk");
      if ((localPluginRecord == null) || (localPluginRecord.a != 4)) {
        break label104;
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", true);
    }
    catch (JSONException paramIQZonePluginManager)
    {
      for (;;)
      {
        PluginRecord localPluginRecord;
        paramIQZonePluginManager.printStackTrace();
        return;
        if ((localPluginRecord != null) && ((localPluginRecord.a == 2) || (NetworkState.isWifiConn())))
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", false);
          if (this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneLiveJsPlugin", 2, " needInstall:" + this.jdField_a_of_type_Boolean + ",需要安装插件");
            }
            paramIQZonePluginManager.a(localPluginRecord.f, null, 0);
          }
        }
      }
    }
    catch (RemoteException paramIQZonePluginManager)
    {
      paramIQZonePluginManager.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QZoneLiveJsPlugin", 2, " 返回结果：" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    this.jdField_a_of_type_CooperationQzoneWebviewpluginQZoneLiveJsPlugin.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
    return;
    label104:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjp
 * JD-Core Version:    0.7.0.1
 */