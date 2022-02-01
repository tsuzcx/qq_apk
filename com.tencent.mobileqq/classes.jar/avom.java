import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomHelper;
import cooperation.liveroom.LiveRoomPluginInstaller;

class avom
  implements PluginManagerHelper.OnPluginManagerLoadedListener
{
  avom(avol paramavol, String paramString) {}
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    PluginBaseInfo localPluginBaseInfo = paramPluginManagerClient.queryPlugin("LiveRoomPlugin.apk");
    if (QLog.isColorLevel()) {
      QLog.d("LiveRoomBusinessPlugin", 2, "get plugin info by ipc");
    }
    if ((localPluginBaseInfo != null) && (localPluginBaseInfo.mState == 4))
    {
      LiveRoomHelper.setPluginInstalledInTool();
      LiveRoomHelper.setPluginVersionInTool("" + localPluginBaseInfo.mCurVersion);
      this.jdField_a_of_type_Avol.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":0\"version\":\"" + localPluginBaseInfo.mCurVersion + "\"}" });
      if (QLog.isColorLevel()) {
        QLog.d("LiveRoomBusinessPlugin", 2, "plugin is installed: version=" + localPluginBaseInfo.mCurVersion);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Avol.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":-1}" });
      LiveRoomPluginInstaller.getInstance().installFromTool(paramPluginManagerClient, "checkSDKInstalled");
    } while (!QLog.isColorLevel());
    QLog.d("LiveRoomBusinessPlugin", 2, "plugin is not installed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avom
 * JD-Core Version:    0.7.0.1
 */