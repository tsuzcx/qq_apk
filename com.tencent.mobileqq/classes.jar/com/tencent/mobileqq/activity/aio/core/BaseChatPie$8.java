package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.ViewGroup;
import bhhn;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.bubble.ChatXListView;

class BaseChatPie$8
  implements bhhn
{
  private View mPreview = this.this$0.mAIORootView.findViewById(2131372918);
  
  BaseChatPie$8(BaseChatPie paramBaseChatPie) {}
  
  public boolean isDirty()
  {
    return (this.this$0.listView.isDirty()) || (this.this$0.mAnimContainer.isDirty()) || (this.mPreview.isDirty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.8
 * JD-Core Version:    0.7.0.1
 */