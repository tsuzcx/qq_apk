package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import mqq.manager.TicketManager;

class GrayTipsItemBuilder$22
  extends ClickableSpan
{
  GrayTipsItemBuilder$22(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    boolean bool = this.jdField_a_of_type_JavaLangString.startsWith("mqqapi");
    int j = 1;
    if (bool)
    {
      if ((this.jdField_a_of_type_JavaLangString.contains("c2c")) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0))
      {
        paramView = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext);
        paramView.addButton(2131719732);
        paramView.addCancelButton(2131690728);
        paramView.setOnDismissListener(new GrayTipsItemBuilder.22.1(this));
        paramView.setOnButtonClickListener(new GrayTipsItemBuilder.22.2(this, paramView));
        paramView.show();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
      }
      else if ((this.jdField_a_of_type_JavaLangString.contains("discussion")) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 3000))
      {
        paramView = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext);
        paramView.addButton(2131719742);
        paramView.addCancelButton(2131690728);
        paramView.setOnDismissListener(new GrayTipsItemBuilder.22.3(this));
        paramView.setOnButtonClickListener(new GrayTipsItemBuilder.22.4(this, paramView));
        paramView.show();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
      }
    }
    else if (this.jdField_a_of_type_JavaLangString.startsWith("http"))
    {
      Object localObject = this.jdField_a_of_type_JavaLangString;
      paramView = (View)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        StringBuilder localStringBuilder;
        if (((String)localObject).contains("?"))
        {
          paramView = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("&sid=");
          localStringBuilder.append(paramView.getSkey(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
          paramView = localStringBuilder.toString();
        }
        else
        {
          paramView = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("?sid=");
          localStringBuilder.append(paramView.getSkey(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
          paramView = localStringBuilder.toString();
        }
      }
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      i = 2;
      break label492;
    }
    int i = 1;
    label492:
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 0) {
      j = 2;
    }
    ReportController.b(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(2), String.valueOf(i), this.b);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.22
 * JD-Core Version:    0.7.0.1
 */