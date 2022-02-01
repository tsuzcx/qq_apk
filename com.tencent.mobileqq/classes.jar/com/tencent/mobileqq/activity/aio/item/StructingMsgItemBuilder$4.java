package com.tencent.mobileqq.activity.aio.item;

import bgrd;
import bgre;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;

class StructingMsgItemBuilder$4
  implements Runnable
{
  StructingMsgItemBuilder$4(StructingMsgItemBuilder paramStructingMsgItemBuilder, bgrd parambgrd, bgre parambgre) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bgrd.d == 1L) && (this.jdField_a_of_type_Bgrd.b.equalsIgnoreCase(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)))
    {
      this.jdField_a_of_type_Bgre.a(6L, this.jdField_a_of_type_Bgrd.a);
      ((BaseActivity)this.this$0.jdField_a_of_type_AndroidContentContext).runOnUiThread(new StructingMsgItemBuilder.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */