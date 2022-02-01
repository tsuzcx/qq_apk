package com.tencent.mobileqq.activity.aio.structMsg;

import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.MessageForStructing;

public class EmptyStructMsgBgSetter
  implements IStructMsgBgSetter
{
  public void a(MessageForStructing paramMessageForStructing, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, boolean paramBoolean)
  {
    paramView.setBackgroundDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.structMsg.EmptyStructMsgBgSetter
 * JD-Core Version:    0.7.0.1
 */