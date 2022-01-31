import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class azyy
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  azyy(azyw paramazyw, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    azyw.a(this.jdField_a_of_type_Azyw).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    azyw.b(this.jdField_a_of_type_Azyw).setVisibility(4);
    azyw.a(this.jdField_a_of_type_Azyw, this.jdField_a_of_type_Boolean, azyw.a(this.jdField_a_of_type_Azyw), azyw.c(this.jdField_a_of_type_Azyw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azyy
 * JD-Core Version:    0.7.0.1
 */