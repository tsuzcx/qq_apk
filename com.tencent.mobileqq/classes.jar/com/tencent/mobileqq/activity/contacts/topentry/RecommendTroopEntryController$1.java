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
    ((MayknowRecommendManager)this.a.b.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).e(paramString);
    if (paramInt == 0)
    {
      this.a.c.setVisibility(8);
      return;
    }
    if (this.a.h != null) {
      this.a.h.a();
    }
    RecommendTroopEntryController.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.RecommendTroopEntryController.1
 * JD-Core Version:    0.7.0.1
 */