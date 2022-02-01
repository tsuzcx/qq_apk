package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.now.utils.ImageLoader;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import java.util.List;

class ChatSettingActivity$3$1
  implements Runnable
{
  ChatSettingActivity$3$1(ChatSettingActivity.3 param3, List paramList) {}
  
  public void run()
  {
    NowSummaryCard.MiniCard localMiniCard = (NowSummaryCard.MiniCard)this.jdField_a_of_type_JavaUtilList.get(0);
    Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$3.a.getResources().getDrawable(2130845716);
    ImageLoader.a().a(ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$3.a), localMiniCard.logo.get(), localDrawable, localDrawable, null, true);
    ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$3.a, localMiniCard.nick.get());
    ChatSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$3.a).setText(ChatSettingActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$3.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.3.1
 * JD-Core Version:    0.7.0.1
 */