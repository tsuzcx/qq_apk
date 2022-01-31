import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

class bils
  implements Animation.AnimationListener
{
  bils(bill parambill, boolean paramBoolean, int paramInt, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    bill.a(this.jdField_a_of_type_Bill, false);
    bill.b(this.jdField_a_of_type_Bill).setVisibility(8);
    bill.a(this.jdField_a_of_type_Bill).setVisibility(8);
    if ((this.jdField_a_of_type_Boolean) && (!bill.a(this.jdField_a_of_type_Bill).get())) {
      bill.a(this.jdField_a_of_type_Bill, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    bill.a(this.jdField_a_of_type_Bill, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bils
 * JD-Core Version:    0.7.0.1
 */