import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aygf
  implements View.OnClickListener
{
  aygf(ayfx paramayfx) {}
  
  public void onClick(View paramView)
  {
    bkzi localbkzi = bkzi.a(this.a.a);
    localbkzi.a(2131717316, 1);
    localbkzi.c(2131690697);
    localbkzi.a(new aygg(this, localbkzi));
    localbkzi.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygf
 * JD-Core Version:    0.7.0.1
 */