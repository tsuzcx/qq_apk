import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class bjsx
  extends View.AccessibilityDelegate
{
  bjsx(bjsv parambjsv) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjsx
 * JD-Core Version:    0.7.0.1
 */