import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.util.concurrent.ConcurrentHashMap;

class anlf
  implements View.OnClickListener
{
  anlf(anle paramanle) {}
  
  public void onClick(View paramView)
  {
    if ((anle.a(this.a) == 0) && (!TextUtils.isEmpty(anle.a(this.a))))
    {
      anle.a(this.a).put(anle.b(this.a), Integer.valueOf(1));
      paramView = this.a.mRuntime.a();
      if (paramView != null) {
        paramView.a.loadUrl(anle.a(this.a));
      }
      anle.a(this.a, null);
    }
    anle.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlf
 * JD-Core Version:    0.7.0.1
 */