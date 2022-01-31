import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class bkuo
  implements Animation.AnimationListener
{
  bkuo(bkuh parambkuh, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bkuh.a(this.jdField_a_of_type_Bkuh, false);
    bkuh.b(this.jdField_a_of_type_Bkuh).setVisibility(8);
    bkuh.a(this.jdField_a_of_type_Bkuh).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!bkuh.a(this.jdField_a_of_type_Bkuh).get())) {
      bkuh.a(this.jdField_a_of_type_Bkuh, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bkuh.a(this.jdField_a_of_type_Bkuh, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuo
 * JD-Core Version:    0.7.0.1
 */