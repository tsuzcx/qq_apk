import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class amzl
{
  public String a;
  public WeakReference<WebViewPlugin> a;
  private WeakReference<amzk> b;
  
  public amzl(amzk paramamzk, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramamzk);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(amzm paramamzm, amzn paramamzn)
  {
    amzk localamzk = (amzk)this.b.get();
    WebViewPlugin localWebViewPlugin;
    if ((localamzk != null) && (paramamzm != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramamzn != null) {
          paramamzn.d = System.currentTimeMillis();
        }
        if (amzm.a(paramamzm) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { amzm.a(paramamzm).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + amzm.a(paramamzm));
      }
      if (amzk.a(localamzk) != null)
      {
        amzk.a(localamzk).remove(amzm.a(paramamzm));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + amzm.a(paramamzm));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzl
 * JD-Core Version:    0.7.0.1
 */