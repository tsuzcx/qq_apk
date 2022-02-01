package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.QQBlur.BackgroundViewDirtyListener;

class BaseChatPie$32
  implements QQBlur.BackgroundViewDirtyListener
{
  BaseChatPie$32(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public boolean isDirty()
  {
    Object localObject = this.b.aZ;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = this.b.aZ.findViewById(this.a);
      bool1 = bool2;
      if (localObject != null) {
        bool1 = ((View)localObject).isDirty();
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.32
 * JD-Core Version:    0.7.0.1
 */