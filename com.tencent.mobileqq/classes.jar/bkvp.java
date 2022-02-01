import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bkvp
  implements View.OnClickListener
{
  bkvp(bkvo parambkvo) {}
  
  public void onClick(View paramView)
  {
    bkvg.a(bkvo.a(this.a), bkvo.b(this.a), "5", "27", "", "3", "", "", "");
    this.a.mUIStyleHandler.mHostFragment.webView.loadUrl("jsbridge://JSTittlebarAction/managerBtnSingleClick");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvp
 * JD-Core Version:    0.7.0.1
 */