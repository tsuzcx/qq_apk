package com.tencent.mobileqq.activity.aio.structMsg;

import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

public class StructMsgBgSetterWithTailWhenMsgHasHeadIcon
  implements IStructMsgBgSetter
{
  public void a(MessageForStructing paramMessageForStructing, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, boolean paramBoolean)
  {
    if (!paramMessageForStructing.structingMsg.hasFlag(4))
    {
      if (paramMessageForStructing.isSend()) {
        if (paramBoolean) {
          i = 2130850413;
        }
      }
      for (;;)
      {
        AIOUtils.a(paramViewHolder.a, i);
        return;
        i = 2130850414;
        continue;
        if (paramBoolean) {
          i = 2130850237;
        } else {
          i = 2130850238;
        }
      }
    }
    if (paramBoolean) {}
    for (int i = 2130838433;; i = 2130838417)
    {
      paramView.setBackgroundResource(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.structMsg.StructMsgBgSetterWithTailWhenMsgHasHeadIcon
 * JD-Core Version:    0.7.0.1
 */