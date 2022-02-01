package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssistantSettingActivity$9
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$9(AssistantSettingActivity paramAssistantSettingActivity, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sticker_switch_");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).commit();
    boolean bool;
    if ((paramBoolean) && (EmojiStickerManager.a())) {
      bool = true;
    } else {
      bool = false;
    }
    EmojiStickerManager.f = bool;
    if (EmojiStickerManager.f) {
      VasWebviewUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app.getCurrentUin(), "Stick", "ClickSwitchOn", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.9
 * JD-Core Version:    0.7.0.1
 */