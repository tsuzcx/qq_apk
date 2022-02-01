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
    int i;
    if (!paramMessageForStructing.structingMsg.hasFlag(4))
    {
      if (paramMessageForStructing.isSend())
      {
        if (paramBoolean) {
          i = 2130850340;
        } else {
          i = 2130850341;
        }
      }
      else if (paramBoolean) {
        i = 2130850164;
      } else {
        i = 2130850165;
      }
      AIOUtils.a(paramViewHolder.a, i);
      return;
    }
    if (paramBoolean) {
      i = 2130838269;
    } else {
      i = 2130838253;
    }
    paramView.setBackgroundResource(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.structMsg.StructMsgBgSetterWithTailWhenMsgHasHeadIcon
 * JD-Core Version:    0.7.0.1
 */