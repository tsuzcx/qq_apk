import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class aqdk
  implements View.OnClickListener
{
  aqdk(aqdj paramaqdj) {}
  
  public void onClick(View paramView)
  {
    if ((aqdj.a(this.a) == 0) && (!TextUtils.isEmpty(aqdj.a(this.a))))
    {
      aqdj.a(this.a).put(aqdj.b(this.a), Integer.valueOf(1));
      WebViewFragment localWebViewFragment = this.a.mRuntime.a();
      if (localWebViewFragment != null) {
        localWebViewFragment.webView.loadUrl(aqdj.a(this.a));
      }
      aqdj.a(this.a, null);
    }
    aqdj.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdk
 * JD-Core Version:    0.7.0.1
 */