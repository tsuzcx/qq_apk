package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import mqq.os.MqqHandler;

class MayknowRecommendManager$2
  extends FriendObserver
{
  MayknowRecommendManager$2(MayknowRecommendManager paramMayknowRecommendManager) {}
  
  protected void onAddReqStatesChanged(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_success", paramBoolean);
    localBundle.putString("key_req_uin", paramString);
    paramString = MayknowRecommendManager.b(this.a).obtainMessage(9, 0, 0, localBundle);
    MayknowRecommendManager.b(this.a).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */