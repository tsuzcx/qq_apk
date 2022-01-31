import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arex
  extends WebViewPlugin
{
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private bcpq jdField_a_of_type_Bcpq;
  protected wxu a;
  
  public arex()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new arez(this);
    this.mPluginNameSpace = "groupVideo";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GroupVideoManager.GVideoWebPlugin", 2, "url:" + paramString1 + " pkgName:" + paramString2 + " method:" + paramString3 + " args:" + paramVarArgs);
    }
    if ((!TextUtils.equals(paramString2, "groupVideo")) || (paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    do
    {
      return false;
      int i;
      if (TextUtils.equals(paramString3, "closeGroupVideoAPI")) {
        try
        {
          paramJsBridgeListener = getJsonFromJSBridge(paramString1);
          if (paramJsBridgeListener == null) {
            break;
          }
          i = paramJsBridgeListener.optInt("type");
          paramJsBridgeListener = new Intent("tencent.video.webjs.cmd");
          paramJsBridgeListener.putExtra("type", i);
          switch (i)
          {
          case 1: 
          case 2: 
            this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramJsBridgeListener);
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
        }
      }
      if (TextUtils.equals(paramString3, "openRoom"))
      {
        try
        {
          Object localObject = getJsonFromJSBridge(paramString1);
          if (localObject != null)
          {
            paramJsBridgeListener = ((JSONObject)localObject).optString("roomCode");
            i = ((JSONObject)localObject).optInt("isGroupCode");
            paramString1 = ((JSONObject)localObject).optString("fromId");
            paramString2 = ((JSONObject)localObject).optString("backType");
            paramString3 = ((JSONObject)localObject).optString("action");
            paramVarArgs = ((JSONObject)localObject).optString("openType");
            localObject = ((JSONObject)localObject).optString("extra");
            this.jdField_a_of_type_Wxu.a(paramJsBridgeListener, i, paramString3, paramString1, paramString2, paramVarArgs, (String)localObject);
            arfe.a("group_video", new arey(this, paramString3));
          }
        }
        catch (Exception paramJsBridgeListener)
        {
          for (;;)
          {
            paramJsBridgeListener.printStackTrace();
          }
        }
        return true;
      }
    } while (!TextUtils.equals(paramString3, "preload"));
    try
    {
      QLog.e("GroupVideoManager.GVideoWebPlugin", 2, "preload url:" + paramString1);
      this.jdField_a_of_type_Wxu.e(null);
      return true;
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        paramJsBridgeListener.printStackTrace();
      }
    }
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.jdField_a_of_type_AndroidContentContext = this.mRuntime.a().getApplicationContext();
    this.jdField_a_of_type_Wxu = wxu.a();
    this.jdField_a_of_type_Wxu.a();
    if (QLog.isColorLevel()) {
      QLog.i("GroupVideoManager.GVideoWebPlugin", 2, "GVideoWebPlugin onCreate");
    }
    IntentFilter localIntentFilter = new IntentFilter(arfw.a("com.tencent.od"));
    localIntentFilter.addAction(arfw.b("com.tencent.od"));
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Bcpq = new bcpq(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Wxu != null) {
      this.jdField_a_of_type_Wxu.b();
    }
    try
    {
      this.jdField_a_of_type_Bcpq.dismiss();
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arex
 * JD-Core Version:    0.7.0.1
 */