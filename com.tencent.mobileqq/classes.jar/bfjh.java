import android.app.Activity;
import android.view.View;
import com.tencent.widget.FadeIconImageView;
import cooperation.qqfav.widget.LocationDetailActivity;
import mqq.app.AppRuntime;

public class bfjh
  extends bfja
{
  public bfjh(LocationDetailActivity paramLocationDetailActivity, Activity paramActivity, bfjd parambfjd, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    super(paramActivity, parambfjd, paramInt1, paramInt2, paramAppRuntime);
  }
  
  public void onClick(View paramView)
  {
    if (LocationDetailActivity.a(this.a))
    {
      bfid.a(true);
      if (LocationDetailActivity.a(this.a) != null) {
        LocationDetailActivity.a(this.a).setVisibility(8);
      }
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfjh
 * JD-Core Version:    0.7.0.1
 */