import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;

class bfmd
  implements View.OnClickListener
{
  bfmd(bfmb parambfmb) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mRuntime.a() != null) {
      this.a.mRuntime.a().loadUrl("javascript:" + bfmb.a(this.a) + "()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmd
 * JD-Core Version:    0.7.0.1
 */