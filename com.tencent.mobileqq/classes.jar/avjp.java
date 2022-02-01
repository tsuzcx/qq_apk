import android.os.Handler;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.anim.FullPopAnimLowVersion.6;

public class avjp
  extends avjo
  implements avmj
{
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 0.0F, 1, 0.3F);
    localScaleAnimation.setDuration(300L);
    localScaleAnimation.setAnimationListener(new avjq(this));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.startAnimation(localScaleAnimation);
  }
  
  public void a()
  {
    ThreadManagerV2.getUIHandlerV2().post(new FullPopAnimLowVersion.6(this));
    a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjp
 * JD-Core Version:    0.7.0.1
 */