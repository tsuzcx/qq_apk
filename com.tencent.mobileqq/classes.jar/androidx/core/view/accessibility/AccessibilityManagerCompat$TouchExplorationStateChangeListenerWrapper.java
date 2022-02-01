package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(19)
final class AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper
  implements AccessibilityManager.TouchExplorationStateChangeListener
{
  final AccessibilityManagerCompat.TouchExplorationStateChangeListener mListener;
  
  AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(@NonNull AccessibilityManagerCompat.TouchExplorationStateChangeListener paramTouchExplorationStateChangeListener)
  {
    this.mListener = paramTouchExplorationStateChangeListener;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof TouchExplorationStateChangeListenerWrapper)) {
      return false;
    }
    paramObject = (TouchExplorationStateChangeListenerWrapper)paramObject;
    return this.mListener.equals(paramObject.mListener);
  }
  
  public int hashCode()
  {
    return this.mListener.hashCode();
  }
  
  public void onTouchExplorationStateChanged(boolean paramBoolean)
  {
    this.mListener.onTouchExplorationStateChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper
 * JD-Core Version:    0.7.0.1
 */