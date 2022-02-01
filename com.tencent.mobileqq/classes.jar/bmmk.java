import android.app.Activity;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.FadeIconImageView;
import cooperation.qqfav.widget.LocationDetailActivity;
import mqq.app.AppRuntime;

public class bmmk
  extends bmme
{
  public bmmk(LocationDetailActivity paramLocationDetailActivity, Activity paramActivity, bmmg parambmmg, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    super(paramActivity, parambmmg, paramInt1, paramInt2, paramAppRuntime);
  }
  
  public void onClick(View paramView)
  {
    if (LocationDetailActivity.a(this.a))
    {
      bmlc.a(true);
      if (LocationDetailActivity.a(this.a) != null) {
        LocationDetailActivity.a(this.a).setVisibility(8);
      }
    }
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmmk
 * JD-Core Version:    0.7.0.1
 */