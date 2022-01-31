import android.view.View;
import android.view.animation.AlphaAnimation;

public class besu
{
  public static void a(View paramView)
  {
    if (paramView.isEnabled())
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.5F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setFillAfter(true);
      paramView.startAnimation(localAlphaAnimation);
    }
  }
  
  public static void b(View paramView)
  {
    if (paramView.isEnabled())
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
      localAlphaAnimation.setDuration(200L);
      localAlphaAnimation.setFillAfter(true);
      paramView.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besu
 * JD-Core Version:    0.7.0.1
 */