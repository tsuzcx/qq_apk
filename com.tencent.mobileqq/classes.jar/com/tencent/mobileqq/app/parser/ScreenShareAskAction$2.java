package com.tencent.mobileqq.app.parser;

import android.support.v4.app.FragmentActivity;
import com.tencent.av.ui.ScreenShareAskArkBottomUpDialog.OnConfirmListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.statistics.ReportController;

class ScreenShareAskAction$2
  implements ScreenShareAskArkBottomUpDialog.OnConfirmListener
{
  ScreenShareAskAction$2(ScreenShareAskAction paramScreenShareAskAction, FragmentActivity paramFragmentActivity, BaseChatPie paramBaseChatPie, String paramString) {}
  
  public void a()
  {
    PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppParserScreenShareAskAction.a, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, true, "AIOShareScreen", null);
    ReportController.b(null, "dc00898", "", "", "0X800B8A6", "0X800B8A6", 0, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.ScreenShareAskAction.2
 * JD-Core Version:    0.7.0.1
 */