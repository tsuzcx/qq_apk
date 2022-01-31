import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

public class asfh
  implements View.OnClickListener
{
  public asfh(CommonTabFragment paramCommonTabFragment) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfh
 * JD-Core Version:    0.7.0.1
 */