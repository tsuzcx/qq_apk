package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

class ComponentActivity$2
  implements LifecycleEventObserver
{
  ComponentActivity$2(ComponentActivity paramComponentActivity) {}
  
  public void onStateChanged(@NonNull LifecycleOwner paramLifecycleOwner, @NonNull Lifecycle.Event paramEvent)
  {
    if (paramEvent == Lifecycle.Event.ON_STOP)
    {
      paramLifecycleOwner = this.this$0.getWindow();
      if (paramLifecycleOwner == null) {
        break label33;
      }
    }
    label33:
    for (paramLifecycleOwner = paramLifecycleOwner.peekDecorView();; paramLifecycleOwner = null)
    {
      if (paramLifecycleOwner != null) {
        paramLifecycleOwner.cancelPendingInputEvents();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.activity.ComponentActivity.2
 * JD-Core Version:    0.7.0.1
 */