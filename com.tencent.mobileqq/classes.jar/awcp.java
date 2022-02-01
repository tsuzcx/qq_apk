import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class awcp
  extends WebViewPlugin
{
  public awcp()
  {
    this.mPluginNameSpace = "share";
  }
  
  private Activity a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity instanceof BasePluginActivity); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private boolean a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString)
  {
    bicv localbicv = bicv.a(2);
    if (localbicv == null)
    {
      QLog.e("LoginPlugin_demo", 1, "doShare wbShareHelper==null !!!");
      return false;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      localbicv.a(a(), paramString1);
    }
    for (;;)
    {
      return true;
      localbicv.b(a(), paramString2);
      continue;
      localbicv.a(a(), paramString3, paramString4, paramString5, paramString1, BitmapFactory.decodeFile(paramString2));
      continue;
      localbicv.a(a(), paramString1, paramArrayOfString);
      continue;
      localbicv.a(a(), paramString1, paramString2);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!"share".equals(paramString2)) || (!"weibo".equals(paramString3))) {
      return false;
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      int i = paramVarArgs.getInt("type");
      paramJsBridgeListener = paramVarArgs.optString("text");
      paramString1 = paramVarArgs.optString("sdcardpath");
      paramString2 = paramVarArgs.optString("title");
      paramString3 = paramVarArgs.optString("description");
      paramVarArgs = paramVarArgs.optString("actionurl");
      String[] arrayOfString = paramString1.split(",");
      QLog.d("LoginPlugin_demo", 1, new Object[] { "handleJsRequest type=", Integer.valueOf(i), ", text=", paramJsBridgeListener, ", sdcardPath=", paramString1, ", title=", paramString2 + ", description=", paramString3 + ", actionUrl=", paramVarArgs });
      boolean bool = a(i, paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs, arrayOfString);
      return bool;
    }
    catch (Exception paramJsBridgeListener)
    {
      QLog.e("LoginPlugin_demo", 1, new Object[] { "handleJsRequest error : ", paramJsBridgeListener.getMessage() });
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    bicv.a(2).a(a(), paramIntent, new awcq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcp
 * JD-Core Version:    0.7.0.1
 */