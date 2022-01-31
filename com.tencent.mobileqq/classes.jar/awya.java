import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class awya
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  awya(awxz paramawxz, LinearLayout paramLinearLayout) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    awxz.a(this.jdField_a_of_type_Awxz, this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awya
 * JD-Core Version:    0.7.0.1
 */