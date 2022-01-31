import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

public class aqhh
  implements View.OnClickListener
{
  public aqhh(CommonTabFragment paramCommonTabFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a == null) || (this.a.a.mWebview == null)) {}
    do
    {
      return;
      paramView = this.a.a.mWebview.getPluginEngine();
    } while (paramView == null);
    paramView.a(this.a.a.mWebview.getUrl(), 8589934606L, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqhh
 * JD-Core Version:    0.7.0.1
 */