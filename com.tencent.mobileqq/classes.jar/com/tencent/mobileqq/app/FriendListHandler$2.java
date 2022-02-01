package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class FriendListHandler$2
  implements Runnable
{
  FriendListHandler$2(FriendListHandler paramFriendListHandler) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "decodePush0x210_0x111,do getMayKnowRecommend");
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("from", "push");
    this.this$0.getMayKnowRecommend(null, null, 6, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler.2
 * JD-Core Version:    0.7.0.1
 */