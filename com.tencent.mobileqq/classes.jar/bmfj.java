import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmfj
  implements View.OnClickListener
{
  bmfj(bmfh parambmfh) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mRuntime.a() != null) {
      this.a.mRuntime.a().loadUrl("javascript:" + bmfh.a(this.a) + "()");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfj
 * JD-Core Version:    0.7.0.1
 */