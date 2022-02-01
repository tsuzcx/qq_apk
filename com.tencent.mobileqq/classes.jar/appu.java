import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class appu
  implements View.OnClickListener
{
  appu(appt paramappt) {}
  
  public void onClick(View paramView)
  {
    if ((appt.a(this.a) == 0) && (!TextUtils.isEmpty(appt.a(this.a))))
    {
      appt.a(this.a).put(appt.b(this.a), Integer.valueOf(1));
      WebViewFragment localWebViewFragment = this.a.mRuntime.a();
      if (localWebViewFragment != null) {
        localWebViewFragment.webView.loadUrl(appt.a(this.a));
      }
      appt.a(this.a, null);
    }
    appt.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appu
 * JD-Core Version:    0.7.0.1
 */