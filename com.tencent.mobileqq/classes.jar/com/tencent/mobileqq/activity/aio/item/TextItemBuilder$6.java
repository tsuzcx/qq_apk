package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.MessageForText;

class TextItemBuilder$6
  implements DialogInterface.OnClickListener
{
  TextItemBuilder$6(TextItemBuilder paramTextItemBuilder, MessageForText paramMessageForText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(this.b.d, this.b.e, this.b.f, this.a.msg, this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */