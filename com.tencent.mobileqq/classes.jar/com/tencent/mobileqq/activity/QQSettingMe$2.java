package com.tencent.mobileqq.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class QQSettingMe$2
  implements Runnable
{
  QQSettingMe$2(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    this.this$0.a(Boolean.valueOf(false));
    QQSettingMe.a(this.this$0).setImageResource(2130845953);
    QQSettingMe.b(this.this$0).setImageResource(2130845969);
    this.this$0.a.setTextColor(-16777216);
    if (this.this$0.b != null) {
      this.this$0.b.setTextColor(-16777216);
    }
    TextView localTextView = (TextView)this.this$0.e.findViewById(2131376394);
    localTextView.setTextColor(Color.parseColor("#FFB0B3BF"));
    ((ImageView)this.this$0.e.findViewById(2131368253)).setColorFilter(localTextView.getCurrentTextColor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.2
 * JD-Core Version:    0.7.0.1
 */