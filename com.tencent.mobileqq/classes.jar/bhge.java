import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.ParticipleView;
import java.lang.ref.WeakReference;
import java.util.List;

public final class bhge
  extends ExploreByTouchHelper
{
  private WeakReference<View> a;
  
  private bhge(View paramView)
  {
    super(paramView);
    this.a = new WeakReference(paramView);
  }
  
  public int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    View localView = (View)this.a.get();
    if ((localView instanceof ParticipleView))
    {
      int i = ParticipleView.a((ParticipleView)localView, paramFloat1, paramFloat2);
      if (i >= 0) {
        return i;
      }
    }
    return -2147483648;
  }
  
  public void getVisibleVirtualViews(List<Integer> paramList)
  {
    Object localObject = (View)this.a.get();
    if ((localObject instanceof ParticipleView))
    {
      localObject = ParticipleView.b((ParticipleView)localObject);
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        paramList.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
  
  public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt2 == 16)
    {
      paramBundle = (View)this.a.get();
      if ((paramBundle instanceof ParticipleView))
      {
        paramBundle = ParticipleView.a((ParticipleView)paramBundle);
        if (paramBundle != null)
        {
          paramBundle.invalidateVirtualView(paramInt1);
          paramBundle.sendEventForVirtualView(paramInt1, 1);
        }
      }
      return true;
    }
    return false;
  }
  
  public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    Object localObject = (View)this.a.get();
    if ((localObject instanceof ParticipleView))
    {
      localObject = ParticipleView.b((ParticipleView)localObject);
      if (paramInt < ((List)localObject).size()) {
        paramAccessibilityEvent.setContentDescription(((bhgd)((List)localObject).get(paramInt)).a.toPlainText());
      }
    }
  }
  
  public void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    Object localObject = (View)this.a.get();
    if ((localObject instanceof ParticipleView))
    {
      localObject = ParticipleView.b((ParticipleView)localObject);
      if ((paramInt < ((List)localObject).size()) && (paramInt != -2147483648))
      {
        localObject = (bhgd)((List)localObject).get(paramInt);
        if (bhgd.a((bhgd)localObject).size() > 0)
        {
          RectF localRectF = (RectF)bhgd.a((bhgd)localObject).get(0);
          paramAccessibilityNodeInfoCompat.setContentDescription(((bhgd)localObject).a.toPlainText());
          paramAccessibilityNodeInfoCompat.addAction(16);
          paramAccessibilityNodeInfoCompat.setBoundsInParent(new Rect((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhge
 * JD-Core Version:    0.7.0.1
 */