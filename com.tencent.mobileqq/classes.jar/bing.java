import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bing
  implements View.OnClickListener
{
  bing(binf parambinf) {}
  
  public void onClick(View paramView)
  {
    this.a.mInActivity.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bing
 * JD-Core Version:    0.7.0.1
 */