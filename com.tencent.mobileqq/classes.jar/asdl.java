import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

class asdl
  extends AnimatorListenerAdapter
{
  asdl(asdk paramasdk, asdo paramasdo, URLDrawable paramURLDrawable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Asdk.a() != null)
    {
      this.jdField_a_of_type_Asdo.b.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
      paramAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_Asdo.b, "alpha", new float[] { 0.2F, 1.0F });
      paramAnimator.setInterpolator(new DecelerateInterpolator());
      paramAnimator.setDuration(300L).start();
      return;
    }
    this.jdField_a_of_type_Asdo.b.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asdl
 * JD-Core Version:    0.7.0.1
 */