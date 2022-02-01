package com.tencent.mobileqq.activity.aio.intimate.view;

import com.tencent.mobileqq.activity.aio.intimate.BaseIntimateView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.friends.intimate.IntimateInfoManager;

class IntimateContentItemFriendInfoView$1
  implements Runnable
{
  IntimateContentItemFriendInfoView$1(IntimateContentItemFriendInfoView paramIntimateContentItemFriendInfoView) {}
  
  public void run()
  {
    if ((this.this$0.d != null) && (this.this$0.h.n() != null)) {
      ((IntimateInfoManager)this.this$0.h.n().getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).a(this.this$0.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView.1
 * JD-Core Version:    0.7.0.1
 */