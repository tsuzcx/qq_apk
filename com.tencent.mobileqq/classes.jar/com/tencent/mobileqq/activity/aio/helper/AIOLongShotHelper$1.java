package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class AIOLongShotHelper$1
  implements Runnable
{
  AIOLongShotHelper$1(AIOLongShotHelper paramAIOLongShotHelper, boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = AIOLongShotHelper.a(this.this$0).f;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if ((!this.a) && (!this.b))
      {
        QQToast.makeText(AIOLongShotHelper.a(this.this$0).e, 1, HardCodeUtil.a(2131898367), 0).show();
        AIOLongShotHelper.a("0X800A50D");
      }
      AIOLongShotHelper.a(this.this$0, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.1
 * JD-Core Version:    0.7.0.1
 */