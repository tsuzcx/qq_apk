package com.tencent.biz.pubaccount.subscript;

import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

class SubscriptFeedsActivity$6
  implements Runnable
{
  SubscriptFeedsActivity$6(SubscriptFeedsActivity paramSubscriptFeedsActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      int[] arrayOfInt = new int[2];
      this.this$0.rightViewText.getLocationInWindow(arrayOfInt);
      int i = this.a;
      int j = arrayOfInt[0];
      int k = this.b;
      int m = AIOUtils.dp2px(2.0F, this.this$0.getResources());
      SubscriptFeedsActivity.a(this.this$0).showAsDropDown(this.this$0.rightViewText, i - j - k - m, -AIOUtils.dp2px(5.0F, this.this$0.getResources()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SubscriptFeedsActivity", 2, "showSubscriptCenterGuideWindow, " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.6
 * JD-Core Version:    0.7.0.1
 */