import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.ApngImage;

final class anxp
  implements Animation.AnimationListener
{
  anxp(Animation paramAnimation1, ImageView paramImageView1, Context paramContext, String paramString, TextView paramTextView1, boolean paramBoolean, TextView paramTextView2, Animation paramAnimation2, ImageView paramImageView2, TextView paramTextView3, TextView paramTextView4) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramAnimation = anxo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramAnimation);
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    while (paramAnimation != this.jdField_b_of_type_AndroidViewAnimationAnimation) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    if ((this.c != null) && (this.jdField_a_of_type_Boolean)) {
      this.c.setVisibility(8);
    }
    if ((this.d != null) && (this.jdField_a_of_type_Boolean)) {
      this.d.setVisibility(8);
    }
    ApngImage.playByTag(39);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxp
 * JD-Core Version:    0.7.0.1
 */