package com.tencent.biz.qrcode.activity;

import bhht;

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
          QRLoginMgrActivity.a(this.this$0, new bhht(QRLoginMgrActivity.a(this.this$0), this.this$0.getTitleBarHeight()));
          QRLoginMgrActivity.a(this.this$0).c(2131717646);
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
      QRLoginMgrActivity.a(this.this$0).c(2131694279);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.4
 * JD-Core Version:    0.7.0.1
 */