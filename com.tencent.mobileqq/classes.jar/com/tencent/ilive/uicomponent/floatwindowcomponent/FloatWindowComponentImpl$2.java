package com.tencent.ilive.uicomponent.floatwindowcomponent;

import android.view.View;
import com.tencent.falco.base.floatwindow.interfaces.OnInvokeView;
import com.tencent.ilive.uicomponent.floatwindowcomponent_interface.FloatWindowHandleCallback;

class FloatWindowComponentImpl$2
  implements OnInvokeView
{
  FloatWindowComponentImpl$2(FloatWindowComponentImpl paramFloatWindowComponentImpl) {}
  
  public void invoke(View paramView)
  {
    if (FloatWindowComponentImpl.access$100(this.this$0) != null) {
      FloatWindowComponentImpl.access$100(this.this$0).invokePlayerContainer(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.floatwindowcomponent.FloatWindowComponentImpl.2
 * JD-Core Version:    0.7.0.1
 */