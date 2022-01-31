import android.view.View;
import android.view.animation.AlphaAnimation;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class aogu
  implements Runnable
{
  public aogu(VideoFilterViewPager paramVideoFilterViewPager, View paramView) {}
  
  public void run()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    localAlphaAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new aogv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogu
 * JD-Core Version:    0.7.0.1
 */