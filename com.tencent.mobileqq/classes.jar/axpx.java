import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;

class axpx
  extends AnimatorListenerAdapter
{
  axpx(axpw paramaxpw, URLDrawable paramURLDrawable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_Axpw.a.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
    ObjectAnimator.ofFloat(this.jdField_a_of_type_Axpw.a, "alpha", new float[] { 0.1F, 1.0F }).setDuration(1500L).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpx
 * JD-Core Version:    0.7.0.1
 */