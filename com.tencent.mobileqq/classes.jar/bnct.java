import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class bnct
  implements Animation.AnimationListener
{
  bnct(bncm parambncm, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bncm.a(this.jdField_a_of_type_Bncm, false);
    bncm.b(this.jdField_a_of_type_Bncm).setVisibility(8);
    bncm.a(this.jdField_a_of_type_Bncm).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!bncm.a(this.jdField_a_of_type_Bncm).get())) {
      bncm.a(this.jdField_a_of_type_Bncm, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bncm.a(this.jdField_a_of_type_Bncm, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnct
 * JD-Core Version:    0.7.0.1
 */