package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class DBFixMsgSendCallback$2$1
  implements Runnable
{
  DBFixMsgSendCallback$2$1(DBFixMsgSendCallback.2 param2, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a)
    {
      QLog.d("DBFixMsgSendCallback", 1, "copy db success!");
      QQToast.makeText(this.b.c.getApp(), "拷贝成功！", 1).show();
      return;
    }
    QLog.d("DBFixMsgSendCallback", 1, "copy db fail!");
    QQToast.makeText(this.b.c.getApp(), "拷贝失败，请重试！", 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.DBFixMsgSendCallback.2.1
 * JD-Core Version:    0.7.0.1
 */