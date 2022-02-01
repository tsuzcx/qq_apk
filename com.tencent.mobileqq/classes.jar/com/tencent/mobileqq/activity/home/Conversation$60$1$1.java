package com.tencent.mobileqq.activity.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.util.Pair;

class Conversation$60$1$1
  implements DialogInterface.OnClickListener
{
  Conversation$60$1$1(Conversation.60.1 param1, ISubAccountControlService paramISubAccountControlService, Pair paramPair) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.cancelHintDialog((String)this.b.first, ((Integer)this.b.second).intValue(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.60.1.1
 * JD-Core Version:    0.7.0.1
 */