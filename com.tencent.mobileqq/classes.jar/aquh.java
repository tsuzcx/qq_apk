import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.jsp.X5ApiPlugin.1;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class aquh
  extends WebViewPlugin
{
  private ConcurrentHashMap<String, aqui> a;
  private ConcurrentHashMap<String, aqui> b;
  
  public aquh()
  {
    this.mPluginNameSpace = "x5";
  }
  
  private int a(Context paramContext, String paramString)
  {
    if (bbdc.b())
    {
      if ((!TextUtils.isEmpty(paramString)) && (bbdc.a(paramString)) && (!paramString.contains("asyncMode=3")) && (!paramString.contains("sonic=1")))
      {
        if ((paramContext != null) && (QbSdk.getTbsVersion(paramContext) >= 43810)) {
          return 4;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  private void a(Context paramContext, WebView paramWebView, aqui paramaqui)
  {
    int i = a(paramContext, paramaqui.jdField_a_of_type_JavaLangString);
    if (i == 4) {
      a(paramWebView, paramaqui);
    }
    b(i, paramaqui.b);
  }
  
  private void a(aqui paramaqui)
  {
    this.b.put(paramaqui.jdField_a_of_type_JavaLangString, paramaqui);
    b(5, paramaqui.b);
  }
  
  private void a(WebView paramWebView, aqui paramaqui)
  {
    this.a.put(paramaqui.jdField_a_of_type_JavaLangString, paramaqui);
    ThreadManager.post(new X5ApiPlugin.1(this, paramaqui, paramWebView), 5, null, true);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.b != null) && (this.a != null))
    {
      Object localObject = this.b.values().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (aqui)((Iterator)localObject).next();
        this.b.remove(((aqui)localObject).jdField_a_of_type_JavaLangString);
        this.a.put(((aqui)localObject).jdField_a_of_type_JavaLangString, localObject);
        a(this.mRuntime.a(), (aqui)localObject);
        b(4, ((aqui)localObject).b);
      }
    }
  }
  
  private boolean a()
  {
    Object localObject = this.mRuntime.a();
    if (localObject != null)
    {
      localObject = (bbca)((WebViewFragment)localObject).b().a(-2);
      return (localObject != null) && (!((bbca)localObject).k);
    }
    return false;
  }
  
  private void b()
  {
    if (this.a == null) {
      this.a = new ConcurrentHashMap();
    }
    if (this.b == null) {
      this.b = new ConcurrentHashMap();
    }
  }
  
  private void b(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      if (this.a.containsKey(paramString)) {
        b(0, ((aqui)this.a.remove(paramString)).b);
      }
      a(a());
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"x5".equals(paramString2)) {
      return false;
    }
    if (("preload".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = new aqui();
        paramString1.jdField_a_of_type_JavaLangString = paramJsBridgeListener.optString("url");
        paramString1.b = paramJsBridgeListener.optString("callback");
        paramString1.jdField_a_of_type_Boolean = paramJsBridgeListener.optBoolean("doWhenPageFinish", false);
        b();
        if (paramString1.jdField_a_of_type_Boolean) {
          if (a()) {
            a(this.mRuntime.a(), this.mRuntime.a(), paramString1);
          } else {
            a(paramString1);
          }
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      a(this.mRuntime.a(), this.mRuntime.a(), paramString1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aquh
 * JD-Core Version:    0.7.0.1
 */