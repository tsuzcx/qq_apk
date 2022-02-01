import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class bnju
  implements Animation.AnimationListener
{
  bnju(bnjl parambnjl, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bnjl.a(this.jdField_a_of_type_Bnjl, false);
    bnjl.b(this.jdField_a_of_type_Bnjl).setVisibility(8);
    bnjl.a(this.jdField_a_of_type_Bnjl).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!bnjl.a(this.jdField_a_of_type_Bnjl).get())) {
      bnjl.a(this.jdField_a_of_type_Bnjl, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bnjl.a(this.jdField_a_of_type_Bnjl, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnju
 * JD-Core Version:    0.7.0.1
 */