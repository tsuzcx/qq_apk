import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class bdsa
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bdsa(bdrz parambdrz, LinearLayout paramLinearLayout) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bdrz.a(this.jdField_a_of_type_Bdrz, this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsa
 * JD-Core Version:    0.7.0.1
 */