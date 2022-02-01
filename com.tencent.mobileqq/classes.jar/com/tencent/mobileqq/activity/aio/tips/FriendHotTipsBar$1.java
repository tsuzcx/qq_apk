package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FriendHotTipsBar$1
  implements View.OnClickListener
{
  FriendHotTipsBar$1(FriendHotTipsBar paramFriendHotTipsBar) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(FriendHotTipsBar.a(this.a), "CliOper", "", "", "Free_call", "Clk_free_call_tips", 0, 0, "", "", "", "");
    FriendHotTipsBar.c(FriendHotTipsBar.a(this.a), FriendHotTipsBar.a(this.a).jdField_a_of_type_JavaLangString);
    FriendHotTipsBar.a(this.a).a();
    String str2;
    String str1;
    if (FriendHotTipsBar.a(this.a).jdField_a_of_type_Int == 1006)
    {
      str2 = FriendHotTipsBar.a(this.a).jdField_a_of_type_JavaLangString;
      str1 = null;
    }
    else
    {
      str1 = FriendHotTipsBar.a(this.a).jdField_a_of_type_JavaLangString;
      str2 = null;
    }
    ChatActivityUtils.a(FriendHotTipsBar.a(this.a), FriendHotTipsBar.a(this.a), FriendHotTipsBar.a(this.a).jdField_a_of_type_Int, str1, FriendHotTipsBar.a(this.a).d, str2, true, FriendHotTipsBar.a(this.a).b, true, true, null, "from_internal");
    ReportController.b(FriendHotTipsBar.a(this.a), "CliOper", "", "", "Two_call", "Two_call_launch", 0, 0, "8", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar.1
 * JD-Core Version:    0.7.0.1
 */