import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class amfz
{
  public String a;
  public WeakReference<WebViewPlugin> a;
  private WeakReference<amfy> b;
  
  public amfz(amfy paramamfy, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramamfy);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(amga paramamga, amgb paramamgb)
  {
    amfy localamfy = (amfy)this.b.get();
    WebViewPlugin localWebViewPlugin;
    if ((localamfy != null) && (paramamga != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramamgb != null) {
          paramamgb.d = System.currentTimeMillis();
        }
        if (amga.a(paramamga) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { amga.a(paramamga).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + amga.a(paramamga));
      }
      if (amfy.a(localamfy) != null)
      {
        amfy.a(localamfy).remove(amga.a(paramamga));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + amga.a(paramamga));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfz
 * JD-Core Version:    0.7.0.1
 */