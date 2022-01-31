import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;

class bgko
  implements View.OnClickListener
{
  bgko(bgkn parambgkn) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mRuntime.a() != null) && (this.a.mRuntime.a() != null))
    {
      paramView = bfpv.a("qzone", String.valueOf(1), this.a.mRuntime.a().getAccount(), this.a.mRuntime.a().getAccount());
      this.a.mRuntime.a().loadUrl(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgko
 * JD-Core Version:    0.7.0.1
 */