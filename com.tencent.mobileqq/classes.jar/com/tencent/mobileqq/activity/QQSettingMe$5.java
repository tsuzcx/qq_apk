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
    if ((!this.a) && (QQTheme.isDefaultTheme()))
    {
      this.this$0.a(Boolean.valueOf(false));
      QQSettingMe.d(this.this$0).setImageResource(2130847704);
      QQSettingMe.e(this.this$0).setImageResource(2130847720);
      QQSettingMe.g(this.this$0).setTextColor(-16777216);
      if (QQSettingMe.h(this.this$0) != null) {
        QQSettingMe.h(this.this$0).setTextColor(-16777216);
      }
      localTextView = (TextView)QQSettingMe.i(this.this$0).findViewById(2131432241);
      localTextView.setTextColor(Color.parseColor("#FFB0B3BF"));
      ((ImageView)QQSettingMe.i(this.this$0).findViewById(2131432228)).setColorFilter(localTextView.getCurrentTextColor());
      return;
    }
    this.this$0.a(Boolean.valueOf(this.a));
    QQSettingMe.d(this.this$0).setImageResource(2130847703);
    QQSettingMe.e(this.this$0).setImageResource(2130847719);
    QQSettingMe.g(this.this$0).setTextColor(QQSettingMe.f(this.this$0).getResources().getColor(2131167334));
    if (QQSettingMe.h(this.this$0) != null) {
      QQSettingMe.h(this.this$0).setTextColor(QQSettingMe.f(this.this$0).getResources().getColor(2131167334));
    }
    TextView localTextView = (TextView)QQSettingMe.i(this.this$0).findViewById(2131432241);
    localTextView.setTextColor(QQSettingMe.f(this.this$0).getResources().getColor(2131167332));
    ((ImageView)QQSettingMe.i(this.this$0).findViewById(2131432228)).setColorFilter(localTextView.getCurrentTextColor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.5
 * JD-Core Version:    0.7.0.1
 */