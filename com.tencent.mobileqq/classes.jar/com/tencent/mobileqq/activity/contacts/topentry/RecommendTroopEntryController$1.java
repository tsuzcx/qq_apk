package com.tencent.mobileqq.activity.contacts.topentry;

import android.widget.FrameLayout;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class RecommendTroopEntryController$1
  implements RecommendTroopAdapter.IRecommendTroopAdapterCallback
{
  RecommendTroopEntryController$1(RecommendTroopEntryController paramRecommendTroopEntryController) {}
  
  public void a(String paramString, int paramInt)
  {
    ((MayknowRecommendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).c(paramString);
    if (paramInt == 0)
    {
      this.a.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController$OnCTEntryDataChangeListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryController$OnCTEntryDataChangeListener.a();
    }
    RecommendTroopEntryController.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopEntryController.1
 * JD-Core Version:    0.7.0.1
 */