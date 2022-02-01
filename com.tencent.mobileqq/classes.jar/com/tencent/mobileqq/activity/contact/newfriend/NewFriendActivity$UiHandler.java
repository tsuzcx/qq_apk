package com.tencent.mobileqq.activity.contact.newfriend;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class NewFriendActivity$UiHandler
  extends Handler
{
  private WeakReference<NewFriendActivity> a;
  
  public NewFriendActivity$UiHandler(NewFriendActivity paramNewFriendActivity)
  {
    this.a = new WeakReference(paramNewFriendActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    NewFriendActivity localNewFriendActivity = (NewFriendActivity)this.a.get();
    if (localNewFriendActivity == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 1: 
      localNewFriendActivity.a(paramMessage.arg1);
      return;
    }
    localNewFriendActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity.UiHandler
 * JD-Core Version:    0.7.0.1
 */