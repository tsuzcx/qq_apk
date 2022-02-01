import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class apzz
  implements View.OnClickListener
{
  apzz(apzy paramapzy) {}
  
  public void onClick(View paramView)
  {
    if ((apzy.a(this.a) == 0) && (!TextUtils.isEmpty(apzy.a(this.a))))
    {
      apzy.a(this.a).put(apzy.b(this.a), Integer.valueOf(1));
      WebViewFragment localWebViewFragment = this.a.mRuntime.a();
      if (localWebViewFragment != null) {
        localWebViewFragment.webView.loadUrl(apzy.a(this.a));
      }
      apzy.a(this.a, null);
    }
    apzy.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzz
 * JD-Core Version:    0.7.0.1
 */