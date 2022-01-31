import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class azty
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  azty(aztx paramaztx, LinearLayout paramLinearLayout) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    aztx.a(this.jdField_a_of_type_Aztx, this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azty
 * JD-Core Version:    0.7.0.1
 */