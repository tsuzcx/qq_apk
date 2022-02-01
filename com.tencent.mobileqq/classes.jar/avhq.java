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

public class avhq
  extends WebViewPlugin
{
  protected aanz a;
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private biau jdField_a_of_type_Biau;
  
  public avhq()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new avhs(this);
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
            this.jdField_a_of_type_Aanz.a(paramJsBridgeListener, i, paramString3, paramString1, paramString2, paramVarArgs, (String)localObject);
            avhx.a("group_video", new avhr(this, paramString3));
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
      this.jdField_a_of_type_Aanz.e(null);
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
    this.jdField_a_of_type_Aanz = aanz.a();
    this.jdField_a_of_type_Aanz.a();
    if (QLog.isColorLevel()) {
      QLog.i("GroupVideoManager.GVideoWebPlugin", 2, "GVideoWebPlugin onCreate");
    }
    IntentFilter localIntentFilter = new IntentFilter(avip.a("com.tencent.od"));
    localIntentFilter.addAction(avip.b("com.tencent.od"));
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Biau = new biau(this.mRuntime.a());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Aanz != null) {
      this.jdField_a_of_type_Aanz.b();
    }
    try
    {
      this.jdField_a_of_type_Biau.dismiss();
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhq
 * JD-Core Version:    0.7.0.1
 */