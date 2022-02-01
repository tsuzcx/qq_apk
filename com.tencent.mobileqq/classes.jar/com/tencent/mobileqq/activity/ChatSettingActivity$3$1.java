package com.tencent.mobileqq.activity;

import adra;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import axxt;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import java.util.List;

public class ChatSettingActivity$3$1
  implements Runnable
{
  public ChatSettingActivity$3$1(adra paramadra, List paramList) {}
  
  public void run()
  {
    NowSummaryCard.MiniCard localMiniCard = (NowSummaryCard.MiniCard)this.jdField_a_of_type_JavaUtilList.get(0);
    Drawable localDrawable = this.jdField_a_of_type_Adra.a.getResources().getDrawable(2130845399);
    axxt.a().a(ChatSettingActivity.a(this.jdField_a_of_type_Adra.a), localMiniCard.logo.get(), localDrawable, localDrawable, null, true);
    ChatSettingActivity.a(this.jdField_a_of_type_Adra.a, localMiniCard.nick.get());
    ChatSettingActivity.a(this.jdField_a_of_type_Adra.a).setText(ChatSettingActivity.b(this.jdField_a_of_type_Adra.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.3.1
 * JD-Core Version:    0.7.0.1
 */