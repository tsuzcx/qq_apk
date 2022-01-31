import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.util.concurrent.ConcurrentHashMap;

class anpo
  implements View.OnClickListener
{
  anpo(anpn paramanpn) {}
  
  public void onClick(View paramView)
  {
    if ((anpn.a(this.a) == 0) && (!TextUtils.isEmpty(anpn.a(this.a))))
    {
      anpn.a(this.a).put(anpn.b(this.a), Integer.valueOf(1));
      paramView = this.a.mRuntime.a();
      if (paramView != null) {
        paramView.a.loadUrl(anpn.a(this.a));
      }
      anpn.a(this.a, null);
    }
    anpn.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpo
 * JD-Core Version:    0.7.0.1
 */