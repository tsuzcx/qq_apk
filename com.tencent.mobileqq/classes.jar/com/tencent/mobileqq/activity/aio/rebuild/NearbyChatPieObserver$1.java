package com.tencent.mobileqq.activity.aio.rebuild;

import ahik;
import ahit;
import awhw;
import bcek;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class NearbyChatPieObserver$1
  implements Runnable
{
  public NearbyChatPieObserver$1(ahit paramahit, boolean paramBoolean, String paramString, awhw paramawhw) {}
  
  public void run()
  {
    bcek localbcek = new bcek(ahit.a(this.this$0).app).a("dc00899").b("grp_lbs").c("data_card");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "msg_suc";; str = "msg_fail")
    {
      localbcek.d(str).e(ahit.a(this.this$0).sessionInfo.curFriendUin).a(new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Awhw.b()) }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPieObserver.1
 * JD-Core Version:    0.7.0.1
 */