import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asxb
  implements View.OnClickListener
{
  asxb(aswz paramaswz) {}
  
  public void onClick(View paramView)
  {
    this.a.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxb
 * JD-Core Version:    0.7.0.1
 */