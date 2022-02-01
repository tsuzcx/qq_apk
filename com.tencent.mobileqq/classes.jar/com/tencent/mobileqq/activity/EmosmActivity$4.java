package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class EmosmActivity$4
  implements View.OnClickListener
{
  EmosmActivity$4(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (EmosmUtils.a(this.a))
      {
        this.a.jdField_a_of_type_Boolean = true;
        EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.app.getAccount(), 2);
        ReportController.b(this.a.app, "CliOper", "", "", "EmosSetting", "ForwardEmojiHome", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.4
 * JD-Core Version:    0.7.0.1
 */