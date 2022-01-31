import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class azyk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  azyk(azyi paramazyi, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    azyi.a(this.jdField_a_of_type_Azyi).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    azyi.b(this.jdField_a_of_type_Azyi).setVisibility(4);
    azyi.a(this.jdField_a_of_type_Azyi, this.jdField_a_of_type_Boolean, azyi.a(this.jdField_a_of_type_Azyi), azyi.c(this.jdField_a_of_type_Azyi));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azyk
 * JD-Core Version:    0.7.0.1
 */