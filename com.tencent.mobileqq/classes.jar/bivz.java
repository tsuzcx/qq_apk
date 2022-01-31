import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;

class bivz
  implements View.OnClickListener
{
  bivz(bivx parambivx) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mRuntime.a() != null) {
      this.a.mRuntime.a().loadUrl("javascript:" + bivx.a(this.a) + "()");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bivz
 * JD-Core Version:    0.7.0.1
 */