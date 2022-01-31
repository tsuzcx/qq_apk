import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class bkqh
  implements Animation.AnimationListener
{
  bkqh(bkqa parambkqa, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bkqa.a(this.jdField_a_of_type_Bkqa, false);
    bkqa.b(this.jdField_a_of_type_Bkqa).setVisibility(8);
    bkqa.a(this.jdField_a_of_type_Bkqa).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!bkqa.a(this.jdField_a_of_type_Bkqa).get())) {
      bkqa.a(this.jdField_a_of_type_Bkqa, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bkqa.a(this.jdField_a_of_type_Bkqa, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqh
 * JD-Core Version:    0.7.0.1
 */