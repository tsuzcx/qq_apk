import android.view.View;
import android.view.View.AccessibilityDelegate;

final class azvh
  extends View.AccessibilityDelegate
{
  azvh(azvj paramazvj) {}
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    super.sendAccessibilityEvent(paramView, paramInt);
    if ((paramInt == 1) && (this.a != null)) {
      this.a.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azvh
 * JD-Core Version:    0.7.0.1
 */