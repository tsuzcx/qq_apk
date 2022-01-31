import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class atjv
  extends View.AccessibilityDelegate
{
  atjv(atjj paramatjj, ClickableSpan paramClickableSpan) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
    if ((paramInt == 1) && (this.jdField_a_of_type_AndroidTextStyleClickableSpan != null)) {
      this.jdField_a_of_type_AndroidTextStyleClickableSpan.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atjv
 * JD-Core Version:    0.7.0.1
 */