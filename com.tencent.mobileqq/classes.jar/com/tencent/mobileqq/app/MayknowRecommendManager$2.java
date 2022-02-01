package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class MayknowRecommendManager$2
  extends FriendListObserver
{
  MayknowRecommendManager$2(MayknowRecommendManager paramMayknowRecommendManager) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "onAddFriend " + paramString);
    }
    paramString = MayknowRecommendManager.a(this.a).obtainMessage(8, 0, 0, paramString);
    MayknowRecommendManager.a(this.a).sendMessage(paramString);
  }
  
  protected void onAddReqStatesChanged(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_success", paramBoolean);
    localBundle.putString("key_req_uin", paramString);
    paramString = MayknowRecommendManager.a(this.a).obtainMessage(9, 0, 0, localBundle);
    MayknowRecommendManager.a(this.a).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */