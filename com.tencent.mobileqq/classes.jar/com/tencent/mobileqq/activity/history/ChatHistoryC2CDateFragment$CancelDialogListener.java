package com.tencent.mobileqq.activity.history;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import java.lang.ref.WeakReference;

class ChatHistoryC2CDateFragment$CancelDialogListener
  implements DialogInterface.OnCancelListener
{
  private final WeakReference<ChatHistoryC2CDateFragment> a;
  
  ChatHistoryC2CDateFragment$CancelDialogListener(ChatHistoryC2CDateFragment paramChatHistoryC2CDateFragment)
  {
    this.a = new WeakReference(paramChatHistoryC2CDateFragment);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ChatHistoryC2CDateFragment localChatHistoryC2CDateFragment = (ChatHistoryC2CDateFragment)this.a.get();
    if ((localChatHistoryC2CDateFragment != null) && (localChatHistoryC2CDateFragment.getActivity() != null) && (!localChatHistoryC2CDateFragment.getActivity().isFinishing())) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment.CancelDialogListener
 * JD-Core Version:    0.7.0.1
 */