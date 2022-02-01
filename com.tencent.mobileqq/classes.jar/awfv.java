import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class awfv
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  WeakReference<WebView> jdField_a_of_type_JavaLangRefWeakReference;
  
  public awfv(WebView paramWebView, long paramLong, String paramString)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebView);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onNoMatchMethod");
    }
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null) {
      return;
    }
    localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':1,'result':'no such method'})");
  }
  
  public void a(Object paramObject)
  {
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView == null) {
      return;
    }
    if (paramObject == null)
    {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':0});");
      return;
    }
    if (((paramObject instanceof Number)) || ((paramObject instanceof Boolean)) || ((paramObject instanceof JSONObject))) {}
    for (paramObject = paramObject.toString();; paramObject = "'" + paramObject.toString().replace("\\", "\\\\").replace("'", "\\'") + "'")
    {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':0,'result':" + paramObject + "});");
      return;
    }
  }
  
  public void a(String paramString)
  {
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView != null) {
      localWebView.loadUrl("javascript:" + paramString);
    }
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("JB", 4, "onPermissionDenied");
    }
    WebView localWebView = (WebView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localWebView != null) {
      localWebView.loadUrl("javascript:window.JsBridge&&JsBridge.callback(" + this.jdField_a_of_type_Long + ",{'r':2,'result':'Permission denied'})");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfv
 * JD-Core Version:    0.7.0.1
 */