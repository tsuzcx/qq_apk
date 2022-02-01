import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bnst
  implements View.OnClickListener
{
  bnst(bnss parambnss) {}
  
  public void onClick(View paramView)
  {
    bnss.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnst
 * JD-Core Version:    0.7.0.1
 */