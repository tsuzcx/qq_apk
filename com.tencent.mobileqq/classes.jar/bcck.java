import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class bcck
  implements View.OnClickListener
{
  public bcck(bcad parambcad) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.a(15, 1, 0L);
      com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter.needJump = false;
      com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter.hasClickJumpBtn = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcck
 * JD-Core Version:    0.7.0.1
 */