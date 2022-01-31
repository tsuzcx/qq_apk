import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class bbgu
  extends ExploreByTouchHelper
{
  public bbgu(ClearableEditText paramClearableEditText, View paramView)
  {
    super(paramView);
  }
  
  public int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    if ((ClearableEditText.c(this.a)) && (paramFloat1 > this.a.getWidth() - this.a.getPaddingRight() - this.a.a.getIntrinsicWidth())) {
      return 0;
    }
    return -1;
  }
  
  public void getVisibleVirtualViews(List<Integer> paramList)
  {
    if (ClearableEditText.c(this.a)) {
      paramList.add(Integer.valueOf(0));
    }
  }
  
  public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ClearableEditTextHelper", 2, "onPerformActionForVirtualView virtualViewId:" + paramInt1);
    }
    return false;
  }
  
  public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramInt == 0) {
      paramAccessibilityEvent.setContentDescription(ajjy.a(2131636150));
    }
  }
  
  public void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if (paramInt == 0)
    {
      paramAccessibilityNodeInfoCompat.setContentDescription(ajjy.a(2131636149));
      paramAccessibilityNodeInfoCompat.addAction(16);
      paramAccessibilityNodeInfoCompat.setBoundsInParent(new Rect(this.a.getWidth() - this.a.getPaddingRight() - this.a.a.getIntrinsicWidth(), this.a.getPaddingTop(), this.a.getWidth() - this.a.getPaddingRight(), this.a.getHeight() - this.a.getPaddingBottom()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbgu
 * JD-Core Version:    0.7.0.1
 */