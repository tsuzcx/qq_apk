package com.tencent.ilive.uicomponent.floatwindowcomponent;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.falco.base.floatwindow.interfaces.OnFloatWindowCallbacks;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowHandleCallback;

class FloatWindowComponentImpl$1
  implements OnFloatWindowCallbacks
{
  FloatWindowComponentImpl$1(FloatWindowComponentImpl paramFloatWindowComponentImpl) {}
  
  public void createdResult(boolean paramBoolean, int paramInt, View paramView) {}
  
  public void dismiss()
  {
    FloatWindowComponentImpl.access$002(this.this$0, false);
    if (FloatWindowComponentImpl.access$100(this.this$0) != null) {
      FloatWindowComponentImpl.access$100(this.this$0).onDismissed(FloatWindowComponentImpl.access$200(this.this$0));
    }
  }
  
  public void drag(@NonNull View paramView, @NonNull MotionEvent paramMotionEvent)
  {
    FloatWindowComponentImpl.access$302(this.this$0, false);
  }
  
  public void dragEnd(@NonNull View paramView)
  {
    FloatWindowComponentImpl.access$302(this.this$0, true);
    if (FloatWindowComponentImpl.access$100(this.this$0) != null) {
      FloatWindowComponentImpl.access$100(this.this$0).onDragEnd(paramView);
    }
  }
  
  public void hide(@NonNull View paramView) {}
  
  public void show(@NonNull View paramView)
  {
    FloatWindowComponentImpl.access$002(this.this$0, true);
    this.this$0.showTime = SystemClock.uptimeMillis();
    if (FloatWindowComponentImpl.access$100(this.this$0) != null) {
      FloatWindowComponentImpl.access$100(this.this$0).onShow();
    }
  }
  
  public void touchEvent(@NonNull View paramView, @NonNull MotionEvent paramMotionEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.floatwindowcomponent.FloatWindowComponentImpl.1
 * JD-Core Version:    0.7.0.1
 */