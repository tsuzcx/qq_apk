import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnpf
  implements View.OnClickListener
{
  bnpf(bnpe parambnpe) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mRuntime.a() != null) && (this.a.mRuntime.a() != null))
    {
      String str = bmth.a("qzone", String.valueOf(1), this.a.mRuntime.a().getAccount(), this.a.mRuntime.a().getAccount());
      this.a.mRuntime.a().loadUrl(str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpf
 * JD-Core Version:    0.7.0.1
 */