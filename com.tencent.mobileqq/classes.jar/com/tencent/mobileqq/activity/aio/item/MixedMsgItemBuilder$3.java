package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.AnimationTextView.OnDoubleClick;

class MixedMsgItemBuilder$3
  implements AnimationTextView.OnDoubleClick
{
  MixedMsgItemBuilder$3(MixedMsgItemBuilder paramMixedMsgItemBuilder) {}
  
  public void a(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    if (this.a.c()) {
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)paramView.getContext();
    ChatFragment localChatFragment = null;
    if (localBaseActivity != null) {
      localChatFragment = localBaseActivity.getChatFragment();
    }
    if (localChatFragment == null)
    {
      ChatActivityUtils.a(this.a.d, paramView, (BaseActivity)this.a.e);
      return;
    }
    ChatActivityUtils.a(this.a.d, paramView, (BaseActivity)this.a.e, this.a.f.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */