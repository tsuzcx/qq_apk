import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;

class bgva
  implements View.OnClickListener
{
  bgva(bguy parambguy) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mRuntime.a() != null) {
      this.a.mRuntime.a().loadUrl("javascript:" + bguy.a(this.a) + "()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgva
 * JD-Core Version:    0.7.0.1
 */