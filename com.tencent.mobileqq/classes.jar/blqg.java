import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blqg
  implements View.OnClickListener
{
  blqg(blqf paramblqf) {}
  
  public void onClick(View paramView)
  {
    blpx.a(blqf.a(this.a), blqf.b(this.a), "5", "27", "", "3", "", "", "");
    this.a.a.a.webView.loadUrl("jsbridge://JSTittlebarAction/managerBtnSingleClick");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqg
 * JD-Core Version:    0.7.0.1
 */