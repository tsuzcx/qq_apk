import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqq.widget.ConfigClearableEditText;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bina
  extends ExploreByTouchHelper
{
  public bina(ConfigClearableEditText paramConfigClearableEditText, View paramView)
  {
    super(paramView);
  }
  
  public int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    if ((ConfigClearableEditText.a(this.a)) && (paramFloat1 > ConfigClearableEditText.a(this.a))) {
      return 0;
    }
    return -1;
  }
  
  public void getVisibleVirtualViews(List<Integer> paramList)
  {
    if (ConfigClearableEditText.a(this.a)) {
      paramList.add(Integer.valueOf(0));
    }
  }
  
  public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigClearableEditTextHelper", 2, "onPerformActionForVirtualView virtualViewId:" + paramInt1);
    }
    return false;
  }
  
  public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramInt == 0) {
      paramAccessibilityEvent.setContentDescription(anvx.a(2131701921));
    }
  }
  
  public void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (paramInt == 0)
    {
      paramAccessibilityNodeInfoCompat.setContentDescription(anvx.a(2131701922));
      paramAccessibilityNodeInfoCompat.addAction(16);
      paramInt = ConfigClearableEditText.a(this.a);
      paramAccessibilityNodeInfoCompat.setBoundsInParent(new Rect(paramInt, this.a.getPaddingTop(), this.a.a.getIntrinsicWidth() + paramInt, this.a.getHeight() - this.a.getPaddingBottom()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bina
 * JD-Core Version:    0.7.0.1
 */