import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;

class bjvk
  implements View.OnClickListener
{
  bjvk(bjvj parambjvj) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mRuntime.a() != null) && (this.a.mRuntime.a() != null))
    {
      paramView = bizq.a("qzone", String.valueOf(1), this.a.mRuntime.a().getAccount(), this.a.mRuntime.a().getAccount());
      this.a.mRuntime.a().loadUrl(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjvk
 * JD-Core Version:    0.7.0.1
 */