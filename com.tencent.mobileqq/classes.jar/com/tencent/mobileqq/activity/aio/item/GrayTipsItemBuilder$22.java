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
    int j = 1;
    int i;
    if (this.jdField_a_of_type_JavaLangString.startsWith("mqqapi")) {
      if ((this.jdField_a_of_type_JavaLangString.contains("c2c")) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0))
      {
        paramView = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext);
        paramView.addButton(2131720000);
        paramView.addCancelButton(2131690800);
        paramView.setOnDismissListener(new GrayTipsItemBuilder.22.1(this));
        paramView.setOnButtonClickListener(new GrayTipsItemBuilder.22.2(this, paramView));
        paramView.show();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
        i = 1;
      }
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      label144:
      Object localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == 0)
      {
        ReportController.b(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(2), String.valueOf(i), this.b);
        return;
        if ((!this.jdField_a_of_type_JavaLangString.contains("discussion")) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != 3000)) {
          break label519;
        }
        paramView = ActionSheet.create(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext);
        paramView.addButton(2131720010);
        paramView.addCancelButton(2131690800);
        paramView.setOnDismissListener(new GrayTipsItemBuilder.22.3(this));
        paramView.setOnButtonClickListener(new GrayTipsItemBuilder.22.4(this, paramView));
        paramView.show();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
        i = 1;
        continue;
        if (!this.jdField_a_of_type_JavaLangString.startsWith("http")) {
          break label519;
        }
        paramView = this.jdField_a_of_type_JavaLangString;
        if (TextUtils.isEmpty(paramView)) {
          break label516;
        }
        if (paramView.contains("?"))
        {
          localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
          paramView = paramView + "&sid=" + ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
      }
      label516:
      for (;;)
      {
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        ((Intent)localObject).putExtra("hide_left_button", true);
        ((Intent)localObject).putExtra("show_right_close_button", true);
        ((Intent)localObject).putExtra("finish_animation_up_down", true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        i = 2;
        break;
        localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
        paramView = paramView + "?sid=" + ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGrayTipsItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        continue;
        j = 2;
        break label144;
      }
      label519:
      i = 1;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.22
 * JD-Core Version:    0.7.0.1
 */