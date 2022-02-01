package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.widget.QQBlur.BackgroundViewDirtyListener;

class BaseChatPie$4
  implements QQBlur.BackgroundViewDirtyListener
{
  private View b = this.a.aZ.findViewById(2131440610);
  
  BaseChatPie$4(BaseChatPie paramBaseChatPie) {}
  
  public boolean isDirty()
  {
    return (this.a.U.isDirty()) || (this.a.aU.isDirty()) || (this.b.isDirty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.4
 * JD-Core Version:    0.7.0.1
 */