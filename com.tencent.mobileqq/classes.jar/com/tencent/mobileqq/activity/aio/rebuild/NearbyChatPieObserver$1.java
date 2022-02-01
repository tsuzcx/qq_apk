package com.tencent.mobileqq.activity.aio.rebuild;

import aidd;
import aidn;
import axny;
import bdlf;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class NearbyChatPieObserver$1
  implements Runnable
{
  public NearbyChatPieObserver$1(aidn paramaidn, boolean paramBoolean, String paramString, axny paramaxny) {}
  
  public void run()
  {
    bdlf localbdlf = new bdlf(aidn.a(this.this$0).app).a("dc00899").b("grp_lbs").c("data_card");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "msg_suc";; str = "msg_fail")
    {
      localbdlf.d(str).e(aidn.a(this.this$0).sessionInfo.curFriendUin).a(new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Axny.b()) }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPieObserver.1
 * JD-Core Version:    0.7.0.1
 */