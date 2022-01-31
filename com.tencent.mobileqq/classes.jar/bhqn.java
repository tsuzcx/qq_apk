import android.os.RemoteException;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

class bhqn
  implements bhjk
{
  bhqn(bhql parambhql, JSONObject paramJSONObject, boolean paramBoolean, String paramString) {}
  
  public void onQzonePluginClientReady(bhhr parambhhr)
  {
    if (parambhhr == null) {
      return;
    }
    try
    {
      localPluginRecord = parambhhr.a("qzone_live_video_plugin_hack.apk");
      if ((localPluginRecord == null) || (localPluginRecord.state != 4)) {
        break label104;
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", true);
    }
    catch (JSONException parambhhr)
    {
      for (;;)
      {
        PluginRecord localPluginRecord;
        parambhhr.printStackTrace();
        return;
        if ((localPluginRecord != null) && ((localPluginRecord.state == 2) || (NetworkState.isWifiConn())))
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", false);
          if (this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneLiveJsPlugin", 2, " needInstall:" + this.jdField_a_of_type_Boolean + ",需要安装插件");
            }
            parambhhr.a(localPluginRecord.id, null, 0);
          }
        }
      }
    }
    catch (RemoteException parambhhr)
    {
      parambhhr.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QZoneLiveJsPlugin", 2, " 返回结果：" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    this.jdField_a_of_type_Bhql.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
    return;
    label104:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhqn
 * JD-Core Version:    0.7.0.1
 */