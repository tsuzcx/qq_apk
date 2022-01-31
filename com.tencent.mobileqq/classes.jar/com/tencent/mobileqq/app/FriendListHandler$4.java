package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class FriendListHandler$4
  implements Runnable
{
  FriendListHandler$4(FriendListHandler paramFriendListHandler) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "decodePush0x210_0x111,do getMayKnowRecommend");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("from", "push");
    this.this$0.a(null, null, 6, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler.4
 * JD-Core Version:    0.7.0.1
 */