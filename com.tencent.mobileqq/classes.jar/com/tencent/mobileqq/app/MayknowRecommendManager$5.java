package com.tencent.mobileqq.app;

import com.tencent.mobileqq.studymode.StudyModeChangeListener;

class MayknowRecommendManager$5
  implements StudyModeChangeListener
{
  MayknowRecommendManager$5(MayknowRecommendManager paramMayknowRecommendManager) {}
  
  public void onChange(boolean paramBoolean)
  {
    ((FriendListHandler)MayknowRecommendManager.c(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(105, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.5
 * JD-Core Version:    0.7.0.1
 */