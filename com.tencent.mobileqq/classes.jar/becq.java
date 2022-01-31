import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.lang.ref.WeakReference;

public class becq
{
  public WeakReference<CustomWebView> a;
  WeakReference<AppInterface> b;
  WeakReference<Activity> c;
  WeakReference<bebx> d = null;
  WeakReference<WebViewFragment> e = null;
  
  public becq(Activity paramActivity, AppInterface paramAppInterface)
  {
    this.c = new WeakReference(paramActivity);
    this.b = new WeakReference(paramAppInterface);
    if ((paramActivity instanceof bebx)) {
      this.d = new WeakReference((bebx)paramActivity);
    }
  }
  
  public Activity a()
  {
    return (Activity)this.c.get();
  }
  
  public bebx a(Activity paramActivity)
  {
    if (this.d != null) {
      return (bebx)this.d.get();
    }
    return null;
  }
  
  public CustomWebView a()
  {
    if (this.a != null) {
      return (CustomWebView)this.a.get();
    }
    return null;
  }
  
  public AppInterface a()
  {
    return (AppInterface)this.b.get();
  }
  
  public WebViewFragment a()
  {
    if (this.e != null) {
      return (WebViewFragment)this.e.get();
    }
    return null;
  }
  
  public void a(bebx parambebx)
  {
    if (parambebx != null) {
      this.d = new WeakReference(parambebx);
    }
  }
  
  public void a(WebViewFragment paramWebViewFragment)
  {
    if (paramWebViewFragment != null)
    {
      this.e = new WeakReference(paramWebViewFragment);
      this.d = new WeakReference(paramWebViewFragment);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becq
 * JD-Core Version:    0.7.0.1
 */