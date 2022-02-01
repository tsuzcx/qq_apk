package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import androidx.annotation.NonNull;

class AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper
  implements AccessibilityManager.AccessibilityStateChangeListener
{
  AccessibilityManagerCompat.AccessibilityStateChangeListener mListener;
  
  AccessibilityManagerCompat$AccessibilityStateChangeListenerWrapper(@NonNull AccessibilityManagerCompat.AccessibilityStateChangeListener paramAccessibilityStateChangeListener)
  {
    this.mListener = paramAccessibilityStateChangeListener;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AccessibilityStateChangeListenerWrapper)) {
      return false;
    }
    paramObject = (AccessibilityStateChangeListenerWrapper)paramObject;
    return this.mListener.equals(paramObject.mListener);
  }
  
  public int hashCode()
  {
    return this.mListener.hashCode();
  }
  
  public void onAccessibilityStateChanged(boolean paramBoolean)
  {
    this.mListener.onAccessibilityStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper
 * JD-Core Version:    0.7.0.1
 */