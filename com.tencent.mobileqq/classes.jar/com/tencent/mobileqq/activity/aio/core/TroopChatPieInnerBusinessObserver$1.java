package com.tencent.mobileqq.activity.aio.core;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.QQAnonymousDialog;
import mqq.os.MqqHandler;

class TroopChatPieInnerBusinessObserver$1
  implements Runnable
{
  TroopChatPieInnerBusinessObserver$1(TroopChatPieInnerBusinessObserver paramTroopChatPieInnerBusinessObserver) {}
  
  public void run()
  {
    if (TroopChatPieInnerBusinessObserver.a(this.this$0).jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog != null) {
      TroopChatPieInnerBusinessObserver.a(this.this$0).jdField_a_of_type_ComTencentBizAnonymousQQAnonymousDialog.dismiss();
    }
    TroopChatPieInnerBusinessObserver.a(this.this$0).v(true);
    TroopChatPieInnerBusinessObserver.a(this.this$0).jdField_a_of_type_MqqOsMqqHandler.postDelayed(new TroopChatPieInnerBusinessObserver.1.1(this), 100L);
    if (!AnonymousChatHelper.a(TroopChatPieInnerBusinessObserver.a(this.this$0), TroopChatPieInnerBusinessObserver.a(this.this$0))) {
      TroopChatPieInnerBusinessObserver.a(this.this$0).jdField_a_of_type_MqqOsMqqHandler.postDelayed(new TroopChatPieInnerBusinessObserver.1.2(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPieInnerBusinessObserver.1
 * JD-Core Version:    0.7.0.1
 */