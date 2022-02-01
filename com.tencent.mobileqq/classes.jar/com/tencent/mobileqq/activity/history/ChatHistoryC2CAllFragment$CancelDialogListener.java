package com.tencent.mobileqq.activity.history;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class ChatHistoryC2CAllFragment$CancelDialogListener
  implements DialogInterface.OnCancelListener
{
  private final WeakReference<ChatHistoryC2CAllFragment> a;
  
  ChatHistoryC2CAllFragment$CancelDialogListener(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment)
  {
    this.a = new WeakReference(paramChatHistoryC2CAllFragment);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ChatHistoryC2CAllFragment localChatHistoryC2CAllFragment = (ChatHistoryC2CAllFragment)this.a.get();
    if ((localChatHistoryC2CAllFragment != null) && (localChatHistoryC2CAllFragment.getBaseActivity() != null) && (!localChatHistoryC2CAllFragment.getBaseActivity().isFinishing())) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.CancelDialogListener
 * JD-Core Version:    0.7.0.1
 */