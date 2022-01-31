package com.tencent.biz.qrcode.activity;

import bcqf;

class QRLoginMgrActivity$5
  implements Runnable
{
  QRLoginMgrActivity$5(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void run()
  {
    try
    {
      if ((QRLoginMgrActivity.a(this.this$0) != null) && (QRLoginMgrActivity.a(this.this$0).isShowing()))
      {
        QRLoginMgrActivity.a(this.this$0).dismiss();
        QRLoginMgrActivity.a(this.this$0).cancel();
      }
      QRLoginMgrActivity.a(this.this$0, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.5
 * JD-Core Version:    0.7.0.1
 */