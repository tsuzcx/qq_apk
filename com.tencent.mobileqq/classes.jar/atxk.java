import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class atxk
  extends VasWebviewJsPlugin
{
  public atxk()
  {
    this.mPluginNameSpace = "profie_edit";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    try
    {
      localObject = URLEncoder.encode(paramString, "UTF-8");
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          paramContext.startActivity((Intent)localObject);
          return;
        }
        catch (SecurityException paramQQAppInterface) {}
        localException = localException;
        QLog.e("ProfileEditWebViewPlugin", 2, "openNickSetWeb", localException);
      }
    }
    paramString = "https://ti.qq.com/hybrid-h5/qq/nick" + "?curNick=" + paramString;
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    ((Intent)localObject).putExtra("url", paramString);
  }
  
  protected void a(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optString("nickname");
        if (this.mRuntime.a() == null) {
          return;
        }
        if ((this.mRuntime.a() == null) || (this.mRuntime.a() == null)) {
          break;
        }
        Object localObject1 = QIPCClientHelper.getInstance().getClient();
        Object localObject2 = new Bundle();
        ((Bundle)localObject2).putString("nickname", paramString);
        localObject1 = ((EIPCClient)localObject1).callServer("CommonModule", "set_nickname", (Bundle)localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject2 = new StringBuilder().append("setNickName, result=");
        if (localObject1 != null)
        {
          i = ((EIPCResult)localObject1).code;
          QLog.d("ProfileEditWebViewPlugin", 2, i + ", nickname = " + paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        return;
      }
      int i = -1;
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("profie_edit".equals(paramString2)) && ("setnick".equals(paramString3)) && (paramVarArgs.length == 1)) {
      a(paramVarArgs[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxk
 * JD-Core Version:    0.7.0.1
 */