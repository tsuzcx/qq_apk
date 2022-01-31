import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.lang.ref.WeakReference;

public class bcdp
{
  public WeakReference<CustomWebView> a;
  WeakReference<AppInterface> b;
  WeakReference<Activity> c;
  WeakReference<bccw> d = null;
  WeakReference<WebViewFragment> e = null;
  
  public bcdp(Activity paramActivity, AppInterface paramAppInterface)
  {
    this.c = new WeakReference(paramActivity);
    this.b = new WeakReference(paramAppInterface);
    if ((paramActivity instanceof bccw)) {
      this.d = new WeakReference((bccw)paramActivity);
    }
  }
  
  public Activity a()
  {
    return (Activity)this.c.get();
  }
  
  public bccw a(Activity paramActivity)
  {
    if (this.d != null) {
      return (bccw)this.d.get();
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
  
  public void a(bccw parambccw)
  {
    if (parambccw != null) {
      this.d = new WeakReference(parambccw);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcdp
 * JD-Core Version:    0.7.0.1
 */