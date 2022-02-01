import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class belg
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  belg(bele parambele, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    bele.a(this.jdField_a_of_type_Bele).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bele.b(this.jdField_a_of_type_Bele).setVisibility(4);
    bele.a(this.jdField_a_of_type_Bele, this.jdField_a_of_type_Boolean, bele.a(this.jdField_a_of_type_Bele), bele.c(this.jdField_a_of_type_Bele));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     belg
 * JD-Core Version:    0.7.0.1
 */