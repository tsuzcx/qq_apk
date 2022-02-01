package com.tencent.av.service;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

class QQServiceForAV$9
  extends AvatarObserver
{
  QQServiceForAV$9(QQServiceForAV paramQQServiceForAV) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    Intent localIntent = new Intent("com.tencent.qqhead.getheadresp2");
    localIntent.putExtra("uin", paramString);
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.a();
    if (this.a.t.contains(paramString)) {
      localQQAppInterface.getApp().sendBroadcast(localIntent);
    }
    this.a.t.remove(paramString);
    if (this.a.c()) {
      localQQAppInterface.removeObserver(this.a.u);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QQServiceForAV.9
 * JD-Core Version:    0.7.0.1
 */