package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.logindev.LoginDevInfoAdapter;
import com.tencent.biz.qrcode.logindev.LoginDevItem;
import java.util.Iterator;
import java.util.List;

class QRLoginMgrActivity$6$1
  implements Runnable
{
  QRLoginMgrActivity$6$1(QRLoginMgrActivity.6 param6, List paramList) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      if (QRLoginMgrActivity.c(this.b.a) != -1L)
      {
        localObject = this.a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          LoginDevItem localLoginDevItem = (LoginDevItem)((Iterator)localObject).next();
          if (localLoginDevItem.a == QRLoginMgrActivity.c(this.b.a)) {
            localLoginDevItem.g = QRLoginMgrActivity.d(this.b.a);
          }
        }
      }
      if (QRLoginMgrActivity.e(this.b.a) != null) {
        QRLoginMgrActivity.e(this.b.a).a(this.a);
      }
    }
    else
    {
      this.b.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */