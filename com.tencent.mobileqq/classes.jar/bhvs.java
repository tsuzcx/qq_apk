import android.annotation.TargetApi;
import android.view.View;
import android.view.View.AccessibilityDelegate;

class bhvs
  extends View.AccessibilityDelegate
{
  bhvs(bhvq parambhvq) {}
  
  @TargetApi(14)
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    if (paramInt != 32) {
      super.sendAccessibilityEvent(paramView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhvs
 * JD-Core Version:    0.7.0.1
 */