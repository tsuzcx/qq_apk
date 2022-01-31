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

public class arpf
  extends WebViewPlugin
{
  private ConcurrentHashMap<String, arpg> a;
  private ConcurrentHashMap<String, arpg> b;
  
  public arpf()
  {
    this.mPluginNameSpace = "x5";
  }
  
  private int a(Context paramContext, String paramString)
  {
    if (bcgq.b())
    {
      if ((!TextUtils.isEmpty(paramString)) && (bcgq.a(paramString)) && (!paramString.contains("asyncMode=3")) && (!paramString.contains("sonic=1")))
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
  
  private void a(Context paramContext, WebView paramWebView, arpg paramarpg)
  {
    int i = a(paramContext, paramarpg.jdField_a_of_type_JavaLangString);
    if (i == 4) {
      a(paramWebView, paramarpg);
    }
    b(i, paramarpg.b);
  }
  
  private void a(arpg paramarpg)
  {
    this.b.put(paramarpg.jdField_a_of_type_JavaLangString, paramarpg);
    b(5, paramarpg.b);
  }
  
  private void a(WebView paramWebView, arpg paramarpg)
  {
    this.a.put(paramarpg.jdField_a_of_type_JavaLangString, paramarpg);
    ThreadManager.post(new X5ApiPlugin.1(this, paramarpg, paramWebView), 5, null, true);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.b != null) && (this.a != null))
    {
      Object localObject = this.b.values().iterator();
      if (((Iterator)localObject).hasNext())
      {
        localObject = (arpg)((Iterator)localObject).next();
        this.b.remove(((arpg)localObject).jdField_a_of_type_JavaLangString);
        this.a.put(((arpg)localObject).jdField_a_of_type_JavaLangString, localObject);
        a(this.mRuntime.a(), (arpg)localObject);
        b(4, ((arpg)localObject).b);
      }
    }
  }
  
  private boolean a()
  {
    Object localObject = this.mRuntime.a();
    if (localObject != null)
    {
      localObject = (bcfo)((WebViewFragment)localObject).b().a(-2);
      return (localObject != null) && (!((bcfo)localObject).k);
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
        b(0, ((arpg)this.a.remove(paramString)).b);
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
        paramString1 = new arpg();
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
 * Qualified Name:     arpf
 * JD-Core Version:    0.7.0.1
 */