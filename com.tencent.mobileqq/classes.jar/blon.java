import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class blon
  extends View.AccessibilityDelegate
{
  blon(blol paramblol) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blon
 * JD-Core Version:    0.7.0.1
 */