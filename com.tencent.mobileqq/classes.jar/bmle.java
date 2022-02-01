import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bmle
  extends bmmk
{
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {}
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((!"getQZoneLiveStatus".equals(paramString3)) || (paramVarArgs == null) || (paramVarArgs.length <= 0));
          try
          {
            paramString1 = new JSONObject(paramVarArgs[0]);
            paramJsBridgeListener = paramString1.optString("callback");
            bool = paramString1.optBoolean("needInstall");
            if (QLog.isColorLevel()) {
              QLog.i("QZoneLiveJsPlugin", 2, "H5参数：" + paramString1);
            }
            paramString1 = new JSONObject();
            paramString2 = bmei.a();
            if (QLog.isColorLevel()) {
              QLog.i("QZoneLiveJsPlugin", 2, "pluginid ：" + paramString2);
            }
            if (!TextUtils.isEmpty(paramString2)) {
              break;
            }
            paramString1.put("isInstalled", false);
            if (QLog.isColorLevel()) {
              QLog.i("QZoneLiveJsPlugin", 2, "pluginid 为空，返回：" + paramString1);
            }
            this.a.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            return false;
          }
          catch (Exception paramJsBridgeListener) {}
        } while (!QLog.isColorLevel());
        QLog.e("QZoneLiveJsPlugin", 2, "", paramJsBridgeListener);
        return false;
        if (!"qzone_live_video_plugin.apk".equals(paramString2)) {
          break;
        }
      } while (TextUtils.isEmpty(paramJsBridgeListener));
      paramString2 = this.a.mRuntime.a();
      if (paramString2 == null)
      {
        paramString1.put("isInstalled", false);
        if (QLog.isColorLevel()) {
          QLog.i("QZoneLiveJsPlugin", 2, "context 为空，返回：" + paramString1);
        }
        this.a.callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
        return false;
      }
      PluginManagerHelper.getPluginInterface(paramString2, new bmlf(this, paramString1, paramJsBridgeListener, bool));
      return false;
    } while ((!paramString2.equals("qzone_live_video_plugin_hack.apk")) || (TextUtils.isEmpty(paramJsBridgeListener)));
    bmea.a(BaseApplicationImpl.getContext(), new bmlg(this, paramString1, bool, paramJsBridgeListener));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmle
 * JD-Core Version:    0.7.0.1
 */