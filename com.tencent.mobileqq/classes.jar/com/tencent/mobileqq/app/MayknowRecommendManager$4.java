package com.tencent.mobileqq.app;

import com.tencent.mobileqq.studymode.StudyModeChangeListener;

class MayknowRecommendManager$4
  implements StudyModeChangeListener
{
  MayknowRecommendManager$4(MayknowRecommendManager paramMayknowRecommendManager) {}
  
  public void a(boolean paramBoolean)
  {
    ((FriendListHandler)MayknowRecommendManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(107, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.4
 * JD-Core Version:    0.7.0.1
 */