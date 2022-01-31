package com.tencent.biz.qrcode.activity;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.theme.ThemeUtil;

class QRDisplayActivity$4
  implements Runnable
{
  QRDisplayActivity$4(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int i = this.this$0.jdField_c_of_type_AndroidViewView.getHeight();
    int j = this.this$0.b.getHeight();
    View localView;
    LinearLayout.LayoutParams localLayoutParams;
    if (j < i)
    {
      localView = this.this$0.findViewById(2131373932);
      localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      if (this.this$0.jdField_c_of_type_Int != 2) {
        break label96;
      }
      localLayoutParams.topMargin = 0;
      localLayoutParams.bottomMargin = 0;
    }
    for (;;)
    {
      if ("1103".equals(ThemeUtil.curThemeId)) {
        localView.setBackgroundDrawable(null);
      }
      localView.setLayoutParams(localLayoutParams);
      return;
      label96:
      if (this.this$0.jdField_c_of_type_Int == 5)
      {
        int k = localLayoutParams.topMargin;
        localLayoutParams.topMargin = ((i - j) / 2 + k);
      }
      else
      {
        localLayoutParams.topMargin = 50;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.4
 * JD-Core Version:    0.7.0.1
 */