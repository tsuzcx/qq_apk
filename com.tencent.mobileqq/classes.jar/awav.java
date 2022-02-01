import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class awav
  extends WebViewPlugin
{
  private final aady a = aady.a();
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("studyroom".equals(paramString2)) && ("predownload".equals(paramString3)))
    {
      this.a.j();
      return true;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awav
 * JD-Core Version:    0.7.0.1
 */