package com.tencent.biz.qrcode.activity;

import bety;

class QRLoginMgrActivity$4
  implements Runnable
{
  QRLoginMgrActivity$4(QRLoginMgrActivity paramQRLoginMgrActivity, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (!this.this$0.isFinishing())
        {
          if ((QRLoginMgrActivity.a(this.this$0) != null) && (QRLoginMgrActivity.a(this.this$0).isShowing()))
          {
            QRLoginMgrActivity.a(this.this$0).dismiss();
            QRLoginMgrActivity.a(this.this$0).cancel();
            QRLoginMgrActivity.a(this.this$0, null);
          }
          QRLoginMgrActivity.a(this.this$0, new bety(QRLoginMgrActivity.a(this.this$0), this.this$0.getTitleBarHeight()));
          QRLoginMgrActivity.a(this.this$0).c(2131719164);
          int i = this.a;
          switch (i)
          {
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        continue;
      }
      if ((QRLoginMgrActivity.a(this.this$0) != null) && (!QRLoginMgrActivity.a(this.this$0).isShowing())) {
        QRLoginMgrActivity.a(this.this$0).show();
      }
      return;
      QRLoginMgrActivity.a(this.this$0).c(2131695090);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.4
 * JD-Core Version:    0.7.0.1
 */