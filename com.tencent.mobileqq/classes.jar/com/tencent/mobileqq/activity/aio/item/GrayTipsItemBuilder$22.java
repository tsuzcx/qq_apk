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
    boolean bool = this.a.startsWith("mqqapi");
    int j = 1;
    if (bool)
    {
      if ((this.a.contains("c2c")) && (this.c.d.a == 0))
      {
        paramView = ActionSheet.create(this.c.c);
        paramView.addButton(2131917335);
        paramView.addCancelButton(2131887648);
        paramView.setOnDismissListener(new GrayTipsItemBuilder.22.1(this));
        paramView.setOnButtonClickListener(new GrayTipsItemBuilder.22.2(this, paramView));
        paramView.show();
        ReportController.b(this.c.a, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
      }
      else if ((this.a.contains("discussion")) && (this.c.d.a == 3000))
      {
        paramView = ActionSheet.create(this.c.c);
        paramView.addButton(2131917345);
        paramView.addCancelButton(2131887648);
        paramView.setOnDismissListener(new GrayTipsItemBuilder.22.3(this));
        paramView.setOnButtonClickListener(new GrayTipsItemBuilder.22.4(this, paramView));
        paramView.show();
        ReportController.b(this.c.a, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
      }
    }
    else if (this.a.startsWith("http"))
    {
      Object localObject = this.a;
      paramView = (View)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        StringBuilder localStringBuilder;
        if (((String)localObject).contains("?"))
        {
          paramView = (TicketManager)this.c.a.getManager(2);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("&sid=");
          localStringBuilder.append(paramView.getSkey(this.c.a.getCurrentAccountUin()));
          paramView = localStringBuilder.toString();
        }
        else
        {
          paramView = (TicketManager)this.c.a.getManager(2);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("?sid=");
          localStringBuilder.append(paramView.getSkey(this.c.a.getCurrentAccountUin()));
          paramView = localStringBuilder.toString();
        }
      }
      localObject = new Intent(this.c.c, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      ((Intent)localObject).putExtra("hide_left_button", true);
      ((Intent)localObject).putExtra("show_right_close_button", true);
      ((Intent)localObject).putExtra("finish_animation_up_down", true);
      this.c.c.startActivity((Intent)localObject);
      i = 2;
      break label492;
    }
    int i = 1;
    label492:
    paramView = this.c.a;
    if (this.c.d.a != 0) {
      j = 2;
    }
    ReportController.b(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(2), String.valueOf(i), this.b);
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