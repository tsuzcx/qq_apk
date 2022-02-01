package androidx.core.view;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

class ViewCompat$AccessibilityPaneVisibilityManager
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap();
  
  @RequiresApi(19)
  private void checkPaneVisibility(View paramView, boolean paramBoolean)
  {
    if (paramView.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (paramBoolean != bool)
      {
        if (bool) {
          ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(paramView, 16);
        }
        this.mPanesToVisible.put(paramView, Boolean.valueOf(bool));
      }
      return;
    }
  }
  
  @RequiresApi(19)
  private void registerForLayoutCallback(View paramView)
  {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  @RequiresApi(19)
  private void unregisterForLayoutCallback(View paramView)
  {
    paramView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
  
  @RequiresApi(19)
  void addAccessibilityPane(View paramView)
  {
    WeakHashMap localWeakHashMap = this.mPanesToVisible;
    if (paramView.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localWeakHashMap.put(paramView, Boolean.valueOf(bool));
      paramView.addOnAttachStateChangeListener(this);
      if (paramView.isAttachedToWindow()) {
        registerForLayoutCallback(paramView);
      }
      return;
    }
  }
  
  @RequiresApi(19)
  public void onGlobalLayout()
  {
    Iterator localIterator = this.mPanesToVisible.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      checkPaneVisibility((View)localEntry.getKey(), ((Boolean)localEntry.getValue()).booleanValue());
    }
  }
  
  @RequiresApi(19)
  public void onViewAttachedToWindow(View paramView)
  {
    registerForLayoutCallback(paramView);
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
  
  @RequiresApi(19)
  void removeAccessibilityPane(View paramView)
  {
    this.mPanesToVisible.remove(paramView);
    paramView.removeOnAttachStateChangeListener(this);
    unregisterForLayoutCallback(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.ViewCompat.AccessibilityPaneVisibilityManager
 * JD-Core Version:    0.7.0.1
 */