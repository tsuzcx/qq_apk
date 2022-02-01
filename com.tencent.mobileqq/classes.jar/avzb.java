import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.AVGameShareJsApiPlugin.1;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class avzb
  extends WebViewPlugin
{
  public avzb()
  {
    this.mPluginNameSpace = "avgame";
  }
  
  private void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      QLog.d("AVGameShareJsApiPlugin", 1, "Call joinRoom, args:" + paramVarArgs);
      try
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]).optString("key");
        Intent localIntent = new Intent(this.mRuntime.a(), JumpActivity.class);
        localIntent.setData(Uri.parse("mqqapi://avgame/join_room?key=" + paramVarArgs));
        this.mRuntime.a().startActivity(localIntent);
        return;
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("AVGameShareJsApiPlugin", 1, "Call joinRoom fail: " + paramVarArgs.getMessage());
        return;
      }
    }
    QLog.e("AVGameShareJsApiPlugin", 1, "Call joinRoom fail, args empty");
  }
  
  private void b(String... paramVarArgs)
  {
    try
    {
      QLog.d("AVGameShareJsApiPlugin", 1, "Call createRoom");
      Intent localIntent = new Intent(this.mRuntime.a(), JumpActivity.class);
      StringBuilder localStringBuilder = new StringBuilder(50);
      localStringBuilder.append("mqqapi://avgame/create_room?gameType=");
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        localStringBuilder.append(Integer.valueOf(paramVarArgs.optString("gameType")).intValue());
        if (paramVarArgs.has("fromType"))
        {
          localStringBuilder.append("&fromType=");
          localStringBuilder.append(Integer.valueOf(paramVarArgs.optString("fromType")).intValue());
        }
      }
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      this.mRuntime.a().startActivity(localIntent);
      return;
    }
    catch (Exception paramVarArgs)
    {
      QLog.e("AVGameShareJsApiPlugin", 1, "Call createRoom fail: " + paramVarArgs.getMessage());
    }
  }
  
  private void c(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      QLog.d("AVGameShareJsApiPlugin", 1, "Call handleShareArk, args:" + paramVarArgs);
      try
      {
        Object localObject1 = this.mRuntime.a().getIntent();
        String str2 = ((Intent)localObject1).getStringExtra("avgame_share_link");
        String str1 = str2;
        if (TextUtils.isEmpty(str2)) {
          str1 = "https://www.qq.com";
        }
        str2 = ((Intent)localObject1).getStringExtra("avgame_share_name");
        Object localObject2 = new JSONObject(paramVarArgs[0]);
        paramVarArgs = ((JSONObject)localObject2).optString("awardTitle");
        localObject1 = ((JSONObject)localObject2).optString("awardDesc");
        localObject2 = ((JSONObject)localObject2).optString("awardIconUrl");
        String str3 = this.mRuntime.a().getCurrentAccountUin();
        ThreadManager.getUIHandler().postDelayed(new AVGameShareJsApiPlugin.1(this, str3, str1, str2, paramVarArgs, (String)localObject1, (String)localObject2), 200L);
        return;
      }
      catch (Exception paramVarArgs)
      {
        QLog.e("AVGameShareJsApiPlugin", 1, "Call handleShareArk fail: " + paramVarArgs.getMessage());
        return;
      }
    }
    QLog.e("AVGameShareJsApiPlugin", 1, "Call handleShareArk fail, args empty");
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, url is empty");
      return false;
    }
    QLog.d("AVGameShareJsApiPlugin", 1, "Call AVGameShareJsApiPlugin handleJsRequest, url" + paramString1 + " pkgName:" + paramString2);
    if ("avgame".equals(paramString2))
    {
      if ("joinRoom".equals(paramString3))
      {
        a(paramVarArgs);
        return true;
      }
      if ("createRoom".equals(paramString3))
      {
        b(paramVarArgs);
        return true;
      }
      if ("shareAward".equals(paramString3))
      {
        c(paramVarArgs);
        return true;
      }
      QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, method not match");
      return false;
    }
    QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, package not match");
    return false;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzb
 * JD-Core Version:    0.7.0.1
 */