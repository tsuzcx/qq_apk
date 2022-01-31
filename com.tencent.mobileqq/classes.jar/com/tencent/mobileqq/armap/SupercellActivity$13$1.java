package com.tencent.mobileqq.armap;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;

class SupercellActivity$13$1
  implements Runnable
{
  SupercellActivity$13$1(SupercellActivity.13 param13, boolean paramBoolean) {}
  
  public void run()
  {
    if (!this.val$isSucc)
    {
      SupercellActivity.access$2200(this.this$1.this$0).removeMessages(2001);
      this.this$1.this$0.hideGuide();
      SupercellActivity.access$200(this.this$1.this$0).stopSensor();
      SupercellActivity.access$200(this.this$1.this$0).queueEvent(new SupercellActivity.13.1.1(this));
      if (QLog.isColorLevel()) {
        QLog.i("SupercellActivity", 2, "onStartPreview cameraStateOpen:" + SupercellActivity.access$2500(this.this$1.this$0));
      }
      if (SupercellActivity.access$2600(this.this$1.this$0) == null) {
        SupercellActivity.access$2602(this.this$1.this$0, DialogUtil.a(this.this$1.this$0, 230, this.this$1.this$0.getResources().getString(2131438753), this.this$1.this$0.getResources().getString(2131438754), this.this$1.this$0.getResources().getString(2131438750), "", null, new SupercellActivity.13.1.2(this)));
      }
      SupercellActivity.access$2600(this.this$1.this$0).show();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("ARTreasurePlayControl", 2, "initMode when camera opensuccess");
      }
      SupercellActivity.access$2200(this.this$1.this$0).postDelayed(new SupercellActivity.13.1.3(this), 1000L);
    } while ((SupercellActivity.access$2600(this.this$1.this$0) == null) || (!SupercellActivity.access$2600(this.this$1.this$0).isShowing()));
    SupercellActivity.access$2600(this.this$1.this$0).dismiss();
    SupercellActivity.access$2602(this.this$1.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.13.1
 * JD-Core Version:    0.7.0.1
 */