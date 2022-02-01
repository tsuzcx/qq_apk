import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axtt
  implements View.OnClickListener
{
  public axtt(NearbyGuideActivity paramNearbyGuideActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (!this.a.isFinishing()))
    {
      this.a.a.dismiss();
      this.a.a = null;
      this.a.e("0X800590A");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtt
 * JD-Core Version:    0.7.0.1
 */