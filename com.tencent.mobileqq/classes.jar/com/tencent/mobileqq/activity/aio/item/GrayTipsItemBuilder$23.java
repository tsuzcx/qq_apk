package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportController;

class GrayTipsItemBuilder$23
  extends ClickableSpan
{
  GrayTipsItemBuilder$23(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if ((this.a.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localIntent = new Intent(this.a.jdField_a_of_type_AndroidContentContext, EditActivity.class);
      paramView = ((DiscussionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if ((paramView == null) || (!paramView.hasRenamed())) {
        break label194;
      }
    }
    label194:
    for (paramView = paramView.discussionName;; paramView = "")
    {
      localIntent.putExtra("title", 2131691870);
      localIntent.putExtra("action", 102);
      localIntent.putExtra("limit", 48);
      localIntent.putExtra("current", paramView);
      localIntent.putExtra("canPostNull", false);
      localIntent.putExtra("multiLine", false);
      localIntent.putExtra("selfSet_leftViewText", this.a.jdField_a_of_type_AndroidContentContext.getString(2131690601));
      ((Activity)this.a.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 6002);
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800666A", "0X800666A", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.23
 * JD-Core Version:    0.7.0.1
 */