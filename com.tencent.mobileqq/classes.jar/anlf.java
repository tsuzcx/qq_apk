import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class anlf
{
  public String a;
  public WeakReference<WebViewPlugin> a;
  private WeakReference<anle> b;
  
  public anlf(anle paramanle, String paramString, WebViewPlugin paramWebViewPlugin)
  {
    this.b = new WeakReference(paramanle);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWebViewPlugin);
  }
  
  public void a(anlg paramanlg, anlh paramanlh)
  {
    anle localanle = (anle)this.b.get();
    WebViewPlugin localWebViewPlugin;
    if ((localanle != null) && (paramanlg != null))
    {
      localWebViewPlugin = (WebViewPlugin)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localWebViewPlugin != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        if (paramanlh != null) {
          paramanlh.d = System.currentTimeMillis();
        }
        if (anlg.a(paramanlg) == null) {
          break label175;
        }
        localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { anlg.a(paramanlg).toString() });
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, plugin.callJs.mResultJson:" + anlg.a(paramanlg));
      }
      if (anle.a(localanle) != null)
      {
        anle.a(localanle).remove(anlg.a(paramanlg));
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloWebDataHandler", 2, "WebDataCallBack, onSSOCallBack, remove sso from mPreloadSSODatas:" + anlg.a(paramanlg));
        }
      }
      return;
      label175:
      localWebViewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlf
 * JD-Core Version:    0.7.0.1
 */