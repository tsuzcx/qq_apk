package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.util.ArrayList;

class SendMultiPictureHelper$6$1
  implements Runnable
{
  SendMultiPictureHelper$6$1(SendMultiPictureHelper.6 param6) {}
  
  public void run()
  {
    if (NetworkUtil.isNetSupport(this.a.a.a)) {
      return;
    }
    this.a.a.s = true;
    SendMultiPictureHelper.a(this.a.a);
    this.a.a.b.getFileManagerNotifyCenter().deleteObserver(this.a.a.v);
    int i = 1;
    while (i < this.a.a.d.size())
    {
      this.a.a.a((SendMultiPictureHelper.SendingFileInfo)this.a.a.d.get(i), this.a.a.k, this.a.a.i, this.a.a.h);
      this.a.a.c.setMessage(String.format(this.a.a.o, new Object[] { Integer.valueOf(this.a.a.e + i), Integer.valueOf(this.a.a.f), Integer.valueOf(0) }));
      i += 1;
    }
    this.a.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper.6.1
 * JD-Core Version:    0.7.0.1
 */