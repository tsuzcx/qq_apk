package com.tencent.mobileqq.armap;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;

class CaiShenActivity$10
  implements Runnable
{
  CaiShenActivity$10(CaiShenActivity paramCaiShenActivity, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      if (!this.val$isSucc)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ARTreasurePlayControl", 2, "initMode when camera openfail");
        }
        this.this$0.mHandler.removeMessages(2001);
        CaiShenActivity.access$300(this.this$0).a = 1;
        if (CaiShenActivity.access$600(this.this$0) != null)
        {
          CaiShenActivity.access$600(this.this$0).setZOrderMediaOverlay(false);
          CaiShenActivity.access$600(this.this$0).setZOrderOnTop(true);
        }
        this.this$0.hideGuide();
        CaiShenActivity.access$700(this.this$0, true);
        if (!this.this$0.isFinishing())
        {
          if (CaiShenActivity.access$800(this.this$0) == null)
          {
            CaiShenActivity.access$802(this.this$0, DialogUtil.a(this.this$0, 230, this.this$0.getResources().getString(2131438776), this.this$0.getResources().getString(2131438777), this.this$0.getResources().getString(2131438773), "", null, new CaiShenActivity.10.1(this)));
            CaiShenActivity.access$800(this.this$0).setOnDismissListener(new CaiShenActivity.10.2(this));
          }
          CaiShenActivity.access$800(this.this$0).show();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("ARTreasurePlayControl", 2, "initMode when camera opensuccess");
        }
        CaiShenActivity.access$300(this.this$0).a = 0;
        CaiShenActivity.access$700(this.this$0, false);
        CaiShenActivity.access$300(this.this$0).b();
        if ((CaiShenActivity.access$800(this.this$0) != null) && (CaiShenActivity.access$800(this.this$0).isShowing()))
        {
          CaiShenActivity.access$800(this.this$0).setOnDismissListener(null);
          CaiShenActivity.access$800(this.this$0).dismiss();
          CaiShenActivity.access$802(this.this$0, null);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CaiShenActivity", 2, "exception when onStartPreview", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.10
 * JD-Core Version:    0.7.0.1
 */