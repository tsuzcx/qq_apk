import android.graphics.drawable.AnimationDrawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

public class aogy
  implements Animation.AnimationListener
{
  public aogy(VideoFilterViewPager paramVideoFilterViewPager, ImageView paramImageView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
    if ((paramAnimation instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramAnimation).start();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogy
 * JD-Core Version:    0.7.0.1
 */