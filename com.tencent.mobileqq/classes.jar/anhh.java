import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class anhh
{
  public String a;
  public WeakReference<WebViewPlugin> a;
  private WeakReference<anhg> b;
  
  public anhh(anhg paramanhg, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramanhg);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(anhi paramanhi, anhj paramanhj)
  {
    anhg localanhg = (anhg)this.b.get();
    WebViewPlugin localWebViewPlugin;
    if ((localanhg != null) && (paramanhi != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramanhj != null) {
          paramanhj.d = System.currentTimeMillis();
        }
        if (anhi.a(paramanhi) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { anhi.a(paramanhi).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + anhi.a(paramanhi));
      }
      if (anhg.a(localanhg) != null)
      {
        anhg.a(localanhg).remove(anhi.a(paramanhi));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + anhi.a(paramanhi));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhh
 * JD-Core Version:    0.7.0.1
 */