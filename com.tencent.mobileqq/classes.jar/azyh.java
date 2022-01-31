import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;

class azyh
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  azyh(azyg paramazyg, LinearLayout paramLinearLayout) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    azyg.a(this.jdField_a_of_type_Azyg, this.jdField_a_of_type_AndroidWidgetLinearLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azyh
 * JD-Core Version:    0.7.0.1
 */