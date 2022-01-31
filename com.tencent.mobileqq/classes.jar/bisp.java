import android.app.Activity;
import android.view.View;
import com.tencent.widget.FadeIconImageView;
import cooperation.qqfav.widget.LocationDetailActivity;
import mqq.app.AppRuntime;

public class bisp
  extends bisi
{
  public bisp(LocationDetailActivity paramLocationDetailActivity, Activity paramActivity, bisl parambisl, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    super(paramActivity, parambisl, paramInt1, paramInt2, paramAppRuntime);
  }
  
  public void onClick(View paramView)
  {
    if (LocationDetailActivity.a(this.a))
    {
      birl.a(true);
      if (LocationDetailActivity.a(this.a) != null) {
        LocationDetailActivity.a(this.a).setVisibility(8);
      }
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bisp
 * JD-Core Version:    0.7.0.1
 */