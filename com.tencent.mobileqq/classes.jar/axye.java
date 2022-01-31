import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class axye
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  axye(axyd paramaxyd, LinearLayout paramLinearLayout) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    axyd.a(this.jdField_a_of_type_Axyd, this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axye
 * JD-Core Version:    0.7.0.1
 */