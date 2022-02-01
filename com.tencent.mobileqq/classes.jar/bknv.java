import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.widget.RangeButtonView;
import java.util.ArrayList;
import java.util.List;

public class bknv
  extends ExploreByTouchHelper
{
  public bknv(RangeButtonView paramRangeButtonView, View paramView)
  {
    super(paramView);
  }
  
  public Rect a(int paramInt)
  {
    Point localPoint = (Point)RangeButtonView.a(this.a).a().get(paramInt);
    paramInt = RangeButtonView.a(this.a).a() / 2;
    return new Rect(localPoint.x - paramInt, localPoint.y - paramInt, localPoint.x + paramInt, localPoint.y + paramInt);
  }
  
  public int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    return RangeButtonView.a(this.a, (int)paramFloat1, (int)paramFloat2, RangeButtonView.a(this.a).a() / 2, RangeButtonView.a(this.a).a() / 2, false);
  }
  
  public void getVisibleVirtualViews(List<Integer> paramList)
  {
    int i = 0;
    while (i < RangeButtonView.a(this.a).size())
    {
      paramList.add(Integer.valueOf(i));
      i += 1;
    }
  }
  
  public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    switch (paramInt2)
    {
    }
    do
    {
      return false;
    } while ((RangeButtonView.a(this.a) == null) || (RangeButtonView.a(this.a) == null));
    if ((paramInt1 != RangeButtonView.a(this.a)) && (paramInt1 != -1))
    {
      if (RangeButtonView.a(this.a) != null) {
        RangeButtonView.a(this.a).a(RangeButtonView.a(this.a), paramInt1);
      }
      RangeButtonView.a(this.a, paramInt1);
      this.a.invalidate();
    }
    return true;
  }
  
  public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    if ((RangeButtonView.b(this.a) != null) && (RangeButtonView.b(this.a).size() > paramInt)) {
      paramAccessibilityEvent.setContentDescription((CharSequence)RangeButtonView.b(this.a).get(paramInt));
    }
  }
  
  public void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if ((RangeButtonView.b(this.a) != null) && (RangeButtonView.b(this.a).size() > paramInt))
    {
      String str2 = (String)RangeButtonView.b(this.a).get(paramInt);
      String str1 = str2;
      if (paramInt == RangeButtonView.a(this.a)) {
        str1 = str2 + anni.a(2131711472);
      }
      paramAccessibilityNodeInfoCompat.setContentDescription(str1);
    }
    paramAccessibilityNodeInfoCompat.addAction(16);
    paramAccessibilityNodeInfoCompat.setBoundsInParent(a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bknv
 * JD-Core Version:    0.7.0.1
 */