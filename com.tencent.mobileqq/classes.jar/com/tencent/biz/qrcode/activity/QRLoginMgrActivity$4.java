package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class QRLoginMgrActivity$4
  implements Runnable
{
  QRLoginMgrActivity$4(QRLoginMgrActivity paramQRLoginMgrActivity, int paramInt) {}
  
  public void run()
  {
    try
    {
      if (!this.this$0.isFinishing())
      {
        if ((QRLoginMgrActivity.b(this.this$0) != null) && (QRLoginMgrActivity.b(this.this$0).isShowing()))
        {
          QRLoginMgrActivity.b(this.this$0).dismiss();
          QRLoginMgrActivity.b(this.this$0).cancel();
          QRLoginMgrActivity.a(this.this$0, null);
        }
        QRLoginMgrActivity.a(this.this$0, new QQProgressDialog(QRLoginMgrActivity.a(this.this$0), this.this$0.getTitleBarHeight()));
        QRLoginMgrActivity.b(this.this$0).c(2131915649);
        int i = this.a;
        if ((i != 0) && (i == 1)) {
          QRLoginMgrActivity.b(this.this$0).c(2131892360);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    if ((QRLoginMgrActivity.b(this.this$0) != null) && (!QRLoginMgrActivity.b(this.this$0).isShowing())) {
      QRLoginMgrActivity.b(this.this$0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.4
 * JD-Core Version:    0.7.0.1
 */