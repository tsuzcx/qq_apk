package com.tencent.mobileqq.activity.contact.troop;

import ajhg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class TroopNotifyAndRecommendView$9
  implements Runnable
{
  TroopNotifyAndRecommendView$9(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void run()
  {
    int i = 0;
    if (this.this$0.a == null) {
      return;
    }
    this.this$0.b = this.this$0.a.getMessageFacade().getMsgList(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    ajhg.a(this.this$0.b, this.this$0.a);
    ArrayList localArrayList = new ArrayList();
    while (i < this.this$0.b.size())
    {
      localArrayList.add(this.this$0.b.get(this.this$0.b.size() - i - 1));
      i += 1;
    }
    this.this$0.b = localArrayList;
    ThreadManager.getUIHandler().post(new TroopNotifyAndRecommendView.9.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9
 * JD-Core Version:    0.7.0.1
 */