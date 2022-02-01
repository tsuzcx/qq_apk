package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.friends.intimate.IntimateInfoManager;

class IntimateInfoView$4
  implements Runnable
{
  IntimateInfoView$4(IntimateInfoView paramIntimateInfoView) {}
  
  public void run()
  {
    if ((IntimateInfoView.a(this.this$0) != null) && (this.this$0.a != null)) {
      ((IntimateInfoManager)this.this$0.a.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).a(IntimateInfoView.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.4
 * JD-Core Version:    0.7.0.1
 */