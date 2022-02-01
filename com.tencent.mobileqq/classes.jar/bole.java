import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class bole
  implements Animation.AnimationListener
{
  bole(bokv parambokv, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bokv.a(this.jdField_a_of_type_Bokv, false);
    bokv.b(this.jdField_a_of_type_Bokv).setVisibility(8);
    bokv.a(this.jdField_a_of_type_Bokv).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!bokv.a(this.jdField_a_of_type_Bokv).get())) {
      bokv.a(this.jdField_a_of_type_Bokv, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bokv.a(this.jdField_a_of_type_Bokv, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bole
 * JD-Core Version:    0.7.0.1
 */