import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.tencent.mobileqq.startup.step.SetSplash;

public final class bccg
  implements ValueAnimator.AnimatorUpdateListener
{
  public bccg(int paramInt1, int paramInt2, int paramInt3, View paramView, bccr parambccr) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (this.jdField_a_of_type_Int > 0) {}
    for (int i = (int)(this.jdField_a_of_type_Int * f);; i = 0)
    {
      int j = this.b;
      int k = (int)((this.b - this.c) * f);
      paramValueAnimator = new Rect(0, i, this.jdField_a_of_type_AndroidViewView.getRight(), j - k + i);
      ViewCompat.setClipBounds(this.jdField_a_of_type_AndroidViewView, paramValueAnimator);
      if ((f > 0.6D) && (!SetSplash.d()))
      {
        SetSplash.a(true);
        SetSplash.b(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Bccr);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bccg
 * JD-Core Version:    0.7.0.1
 */