package com.tencent.mobileqq.activity.aio;

import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;

class BaseChatItemLayout$1
  implements Runnable
{
  BaseChatItemLayout$1(BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout.LayoutParams paramLayoutParams, BaseChatItemLayoutViewBasicAbility paramBaseChatItemLayoutViewBasicAbility, ImageView paramImageView) {}
  
  public void run()
  {
    this.a.addRule(15, 0);
    this.a.topMargin = (this.b.getTop() + (this.b.getHeight() - BaseChatItemLayout.V) / 2);
    this.c.setLayoutParams(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseChatItemLayout.1
 * JD-Core Version:    0.7.0.1
 */