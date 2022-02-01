package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$9
  implements Runnable
{
  QQSettingMe$9(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    int i = (int)this.this$0.a.getResources().getDimension(2131296854);
    Object localObject = new int[2];
    this.this$0.d.getLocationOnScreen((int[])localObject);
    int j = this.this$0.g.getWidth();
    int k = this.this$0.d.getWidth();
    if ((j != 0) && (k != 0)) {
      i -= (j - k) / 2;
    }
    for (;;)
    {
      localObject = this.this$0.h.getLayoutParams();
      if ((i > 0) && ((localObject instanceof RelativeLayout.LayoutParams)))
      {
        ((RelativeLayout.LayoutParams)localObject).leftMargin = i;
        this.this$0.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "setBottomBtnMarginLeft, diffMargin = " + i);
      }
      return;
      i = (int)this.this$0.a.getResources().getDimension(2131296859);
      QLog.e("QQSettingRedesign", 1, "setBottomBtnMarginLeft, but getWidth return 0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.9
 * JD-Core Version:    0.7.0.1
 */