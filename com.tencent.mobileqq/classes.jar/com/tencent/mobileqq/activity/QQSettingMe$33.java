package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

class QQSettingMe$33
  implements Runnable
{
  QQSettingMe$33(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    int j = 0;
    int k = this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getBaseContext().getResources().getDimensionPixelSize(2131298524);
    if (this.this$0.b.getVisibility() == 0) {
      j = 0 + ScreenUtil.dip2px(53.0F);
    }
    int i = j;
    if (this.this$0.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      i = j + ScreenUtil.dip2px(35.0F);
    }
    j = i;
    if (this.this$0.c.getVisibility() == 0) {
      j = i + ScreenUtil.dip2px(17.0F);
    }
    QQSettingMe.a(this.this$0, ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(94.0F) - k - ScreenUtil.dip2px(45.0F) - j);
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(QQSettingMe.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.33
 * JD-Core Version:    0.7.0.1
 */