package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

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
          QRLoginMgrActivity.a(this.this$0, new QQProgressDialog(QRLoginMgrActivity.a(this.this$0), this.this$0.getTitleBarHeight()));
          QRLoginMgrActivity.a(this.this$0).c(2131718505);
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
      QRLoginMgrActivity.a(this.this$0).c(2131694694);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.4
 * JD-Core Version:    0.7.0.1
 */