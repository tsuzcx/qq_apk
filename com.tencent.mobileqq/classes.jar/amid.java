import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class amid
  extends bmme
{
  public amid(ShortVideoPlayActivity paramShortVideoPlayActivity, Activity paramActivity, bmmg parambmmg, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    super(paramActivity, parambmmg, paramInt1, paramInt2, paramAppRuntime);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amid
 * JD-Core Version:    0.7.0.1
 */