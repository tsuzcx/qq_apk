package com.tencent.av.service;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

class QQServiceForAV$8
  extends AvatarObserver
{
  QQServiceForAV$8(QQServiceForAV paramQQServiceForAV) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    Intent localIntent = new Intent("com.tencent.qqhead.getheadresp2");
    localIntent.putExtra("uin", paramString);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (this.a.b.contains(paramString)) {
      localQQAppInterface.getApp().sendBroadcast(localIntent);
    }
    this.a.b.remove(paramString);
    if (this.a.c()) {
      localQQAppInterface.removeObserver(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.8
 * JD-Core Version:    0.7.0.1
 */