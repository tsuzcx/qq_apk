import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class bilb
  implements Animation.AnimationListener
{
  bilb(biku parambiku, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    biku.a(this.jdField_a_of_type_Biku, false);
    biku.b(this.jdField_a_of_type_Biku).setVisibility(8);
    biku.a(this.jdField_a_of_type_Biku).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!biku.a(this.jdField_a_of_type_Biku).get())) {
      biku.a(this.jdField_a_of_type_Biku, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    biku.a(this.jdField_a_of_type_Biku, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilb
 * JD-Core Version:    0.7.0.1
 */