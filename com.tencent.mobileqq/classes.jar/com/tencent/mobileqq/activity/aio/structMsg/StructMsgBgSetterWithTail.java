package com.tencent.mobileqq.activity.aio.structMsg;

import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.MessageForStructing;

public class StructMsgBgSetterWithTail
  implements IStructMsgBgSetter
{
  public void a(MessageForStructing paramMessageForStructing, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, boolean paramBoolean)
  {
    int i;
    if (paramMessageForStructing.isSend())
    {
      if (paramBoolean) {
        i = 2130852131;
      } else {
        i = 2130852132;
      }
    }
    else if (paramBoolean) {
      i = 2130851949;
    } else {
      i = 2130851950;
    }
    AIOUtils.a(paramViewHolder.h, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.structMsg.StructMsgBgSetterWithTail
 * JD-Core Version:    0.7.0.1
 */