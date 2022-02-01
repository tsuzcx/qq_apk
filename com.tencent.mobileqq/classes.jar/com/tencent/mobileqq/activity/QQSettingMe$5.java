package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.QQTheme;

class QQSettingMe$5
  implements Runnable
{
  QQSettingMe$5(QQSettingMe paramQQSettingMe, boolean paramBoolean) {}
  
  public void run()
  {
    if ((!this.a) && (QQTheme.e()))
    {
      this.this$0.a(Boolean.valueOf(false));
      QQSettingMe.a(this.this$0).setImageResource(2130846234);
      QQSettingMe.b(this.this$0).setImageResource(2130846250);
      QQSettingMe.b(this.this$0).setTextColor(-16777216);
      if (QQSettingMe.c(this.this$0) != null) {
        QQSettingMe.c(this.this$0).setTextColor(-16777216);
      }
      localTextView = (TextView)QQSettingMe.a(this.this$0).findViewById(2131365972);
      localTextView.setTextColor(Color.parseColor("#FFB0B3BF"));
      ((ImageView)QQSettingMe.a(this.this$0).findViewById(2131365959)).setColorFilter(localTextView.getCurrentTextColor());
      return;
    }
    this.this$0.a(Boolean.valueOf(this.a));
    QQSettingMe.a(this.this$0).setImageResource(2130846233);
    QQSettingMe.b(this.this$0).setImageResource(2130846249);
    QQSettingMe.b(this.this$0).setTextColor(QQSettingMe.a(this.this$0).getResources().getColor(2131166492));
    if (QQSettingMe.c(this.this$0) != null) {
      QQSettingMe.c(this.this$0).setTextColor(QQSettingMe.a(this.this$0).getResources().getColor(2131166492));
    }
    TextView localTextView = (TextView)QQSettingMe.a(this.this$0).findViewById(2131365972);
    localTextView.setTextColor(QQSettingMe.a(this.this$0).getResources().getColor(2131166490));
    ((ImageView)QQSettingMe.a(this.this$0).findViewById(2131365959)).setColorFilter(localTextView.getCurrentTextColor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.5
 * JD-Core Version:    0.7.0.1
 */