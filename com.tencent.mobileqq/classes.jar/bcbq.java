import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bcbq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bcbq(bcbo parambcbo, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    bcbo.a(this.jdField_a_of_type_Bcbo).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bcbo.b(this.jdField_a_of_type_Bcbo).setVisibility(4);
    bcbo.a(this.jdField_a_of_type_Bcbo, this.jdField_a_of_type_Boolean, bcbo.a(this.jdField_a_of_type_Bcbo), bcbo.c(this.jdField_a_of_type_Bcbo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbq
 * JD-Core Version:    0.7.0.1
 */