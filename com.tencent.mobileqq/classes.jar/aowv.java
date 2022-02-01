import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class aowv
  implements View.OnClickListener
{
  aowv(aowu paramaowu) {}
  
  public void onClick(View paramView)
  {
    if ((aowu.a(this.a) == 0) && (!TextUtils.isEmpty(aowu.a(this.a))))
    {
      aowu.a(this.a).put(aowu.b(this.a), Integer.valueOf(1));
      WebViewFragment localWebViewFragment = this.a.mRuntime.a();
      if (localWebViewFragment != null) {
        localWebViewFragment.webView.loadUrl(aowu.a(this.a));
      }
      aowu.a(this.a, null);
    }
    aowu.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowv
 * JD-Core Version:    0.7.0.1
 */