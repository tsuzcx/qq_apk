package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.widget.QQProgressDialog;

class QRLoginMgrActivity$5
  implements Runnable
{
  QRLoginMgrActivity$5(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void run()
  {
    try
    {
      if ((QRLoginMgrActivity.b(this.this$0) != null) && (QRLoginMgrActivity.b(this.this$0).isShowing()))
      {
        QRLoginMgrActivity.b(this.this$0).dismiss();
        QRLoginMgrActivity.b(this.this$0).cancel();
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    QRLoginMgrActivity.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.5
 * JD-Core Version:    0.7.0.1
 */