import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aygr
  implements View.OnClickListener
{
  aygr(ayfx paramayfx) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.a.onBackEvent())
    {
      this.a.a.finish();
      this.a.a.c(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygr
 * JD-Core Version:    0.7.0.1
 */