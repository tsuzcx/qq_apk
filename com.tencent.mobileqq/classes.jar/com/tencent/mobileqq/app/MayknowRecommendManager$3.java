package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class MayknowRecommendManager$3
  extends FriendListObserver
{
  MayknowRecommendManager$3(MayknowRecommendManager paramMayknowRecommendManager) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAddFriend ");
      localStringBuilder.append(paramString);
      QLog.d("MayknowRecommendManager", 2, localStringBuilder.toString());
    }
    paramString = MayknowRecommendManager.b(this.a).obtainMessage(8, 0, 0, paramString);
    MayknowRecommendManager.b(this.a).sendMessage(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.3
 * JD-Core Version:    0.7.0.1
 */