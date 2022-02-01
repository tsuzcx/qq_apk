package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$9
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$9(AssistantSettingActivity paramAssistantSettingActivity, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sticker_switch_" + this.jdField_a_of_type_JavaLangString, paramBoolean).commit();
    if ((paramBoolean) && (EmojiStickerManager.a())) {}
    for (boolean bool = true;; bool = false)
    {
      EmojiStickerManager.f = bool;
      if (EmojiStickerManager.f) {
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app.getCurrentUin(), "Stick", "ClickSwitchOn", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.9
 * JD-Core Version:    0.7.0.1
 */