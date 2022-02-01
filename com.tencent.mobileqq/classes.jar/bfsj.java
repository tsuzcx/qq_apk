import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bfsj
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bfsj(bfsh parambfsh, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    bfsh.a(this.jdField_a_of_type_Bfsh).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bfsh.b(this.jdField_a_of_type_Bfsh).setVisibility(4);
    bfsh.a(this.jdField_a_of_type_Bfsh, this.jdField_a_of_type_Boolean, bfsh.a(this.jdField_a_of_type_Bfsh), bfsh.c(this.jdField_a_of_type_Bfsh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsj
 * JD-Core Version:    0.7.0.1
 */