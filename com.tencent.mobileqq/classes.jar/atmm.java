import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.Locale;
import org.json.JSONObject;

public class atmm
  extends WebViewPlugin
  implements atnq
{
  private EIPCResultCallback a;
  protected String a;
  private EIPCResultCallback b;
  protected String b;
  private String c;
  
  public atmm()
  {
    this.jdField_a_of_type_EipcEIPCResultCallback = new atmn(this);
    this.jdField_b_of_type_EipcEIPCResultCallback = new atmo(this);
    this.mPluginNameSpace = "listenTogether";
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, "statusChanged isDestroy:" + this.isDestroy + " data:" + paramJSONObject + " mCheckJoinCallback:" + this.jdField_a_of_type_JavaLangString + " mJoinListenCallback:" + this.jdField_b_of_type_JavaLangString);
    }
    if ((paramJSONObject != null) && (TextUtils.equals(paramJSONObject.optString("type"), "checkJoin"))) {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localJSONObject = new JSONObject();
      }
    }
    do
    {
      try
      {
        localJSONObject.put("canJoin", paramJSONObject.optInt("canJoin"));
        localJSONObject.put("isOpener", paramJSONObject.optInt("isOpener"));
        localJSONObject.put("uinType", paramJSONObject.optInt("uinType"));
        callJs(this.jdField_a_of_type_JavaLangString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("ListenTogetherPlugin", 1, "statusChanged error:" + paramJSONObject.getMessage());
        return;
      }
      if ((paramJSONObject == null) || (!TextUtils.equals(paramJSONObject.optString("type"), "joinListen"))) {
        break;
      }
    } while (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", paramJSONObject.optInt("retCode"));
      callJs(this.jdField_b_of_type_JavaLangString, new String[] { localJSONObject.toString() });
      this.jdField_b_of_type_JavaLangString = null;
      return;
    }
    catch (Throwable paramJSONObject)
    {
      for (;;)
      {
        QLog.e("ListenTogetherPlugin", 1, "statusChanged error:" + paramJSONObject.getMessage());
      }
    }
    dispatchJsEvent("musicStatusChange", paramJSONObject, null);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("listenTogether".equals(paramString2))
    {
      paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
      if (paramJsBridgeListener == null) {}
      do
      {
        do
        {
          do
          {
            do
            {
              return true;
              if (QLog.isColorLevel()) {
                QLog.d("ListenTogetherPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
              }
              this.c = paramJsBridgeListener.optString("callback");
            } while ("awakePlugin".equals(paramString3));
            if (!"statusChanged".equals(paramString3)) {
              break;
            }
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              atnn.a(paramJsBridgeListener);
              if (!"checkJoin".equals(paramJsBridgeListener.opt("type"))) {
                continue;
              }
              if (paramJsBridgeListener != null)
              {
                this.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
                return true;
              }
            }
            catch (Exception paramJsBridgeListener)
            {
              QLog.e("ListenTogetherPlugin", 1, "METHOD_STATUS_CHANGED exception e = ", paramJsBridgeListener);
              return true;
            }
            this.jdField_a_of_type_JavaLangString = null;
            return true;
          } while (!"joinListen".equals(paramJsBridgeListener.opt("type")));
          if (paramJsBridgeListener != null)
          {
            this.jdField_b_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
            return true;
          }
          this.jdField_b_of_type_JavaLangString = null;
          return true;
          if (!"isOpener".equals(paramString3)) {
            break;
          }
        } while (TextUtils.isEmpty(this.c));
        atnn.a(paramJsBridgeListener, "isOpener", this.jdField_b_of_type_EipcEIPCResultCallback);
        return true;
        if (!"isShowAtmosphere".equals(paramString3)) {
          break;
        }
      } while (TextUtils.isEmpty(this.c));
      atnn.a(paramJsBridgeListener, "isShowAtmosphere", this.jdField_a_of_type_EipcEIPCResultCallback);
      return true;
      if ("setPlayerId".equals(paramString3))
      {
        atnn.a(paramJsBridgeListener, "setPlayerId", null);
        return true;
      }
      if ("setThemeEnabled".equals(paramString3))
      {
        atnn.a(paramJsBridgeListener, "setThemeEnabled", null);
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, "onActivityResult requestCode=" + paramByte + "  resultCode=" + paramInt);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, "onCreate");
    }
    atnn.a().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherPlugin", 2, "onDestroy");
    }
    atnn.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmm
 * JD-Core Version:    0.7.0.1
 */