import android.os.RemoteException;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.plugin.PluginRecord;
import cooperation.qzone.util.NetworkState;
import org.json.JSONException;
import org.json.JSONObject;

class bghu
  implements bgaz
{
  bghu(bghs parambghs, JSONObject paramJSONObject, boolean paramBoolean, String paramString) {}
  
  public void onQzonePluginClientReady(bfzg parambfzg)
  {
    if (parambfzg == null) {
      return;
    }
    try
    {
      localPluginRecord = parambfzg.a("qzone_live_video_plugin_hack.apk");
      if ((localPluginRecord == null) || (localPluginRecord.state != 4)) {
        break label104;
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", true);
    }
    catch (JSONException parambfzg)
    {
      for (;;)
      {
        PluginRecord localPluginRecord;
        parambfzg.printStackTrace();
        return;
        if ((localPluginRecord != null) && ((localPluginRecord.state == 2) || (NetworkState.isWifiConn())))
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put("isInstalled", false);
          if (this.jdField_a_of_type_Boolean)
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneLiveJsPlugin", 2, " needInstall:" + this.jdField_a_of_type_Boolean + ",需要安装插件");
            }
            parambfzg.a(localPluginRecord.id, null, 0);
          }
        }
      }
    }
    catch (RemoteException parambfzg)
    {
      parambfzg.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.i("QZoneLiveJsPlugin", 2, " 返回结果：" + this.jdField_a_of_type_OrgJsonJSONObject);
    }
    this.jdField_a_of_type_Bghs.a.callJs(this.jdField_a_of_type_JavaLangString, new String[] { this.jdField_a_of_type_OrgJsonJSONObject.toString() });
    return;
    label104:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bghu
 * JD-Core Version:    0.7.0.1
 */