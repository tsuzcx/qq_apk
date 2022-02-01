package com.tencent.mobileqq.activity.pendant;

import android.os.Bundle;
import bgks;
import bhhe;
import bhhf;
import bhhh;
import bhhk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AvatarPendantActivity$IconRunnable
  implements Runnable
{
  WeakReference<bhhe> a;
  WeakReference<QQAppInterface> b;
  
  AvatarPendantActivity$IconRunnable(AvatarPendantActivity paramAvatarPendantActivity, bhhe parambhhe, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(parambhhe);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.a.get() != null))
    {
      bhhk localbhhk = ((bhhh)((QQAppInterface)this.b.get()).getManager(47)).a(1);
      if (localbhhk.a(bgks.a) == null)
      {
        Object localObject = new File(bgks.b + "/icon.zip");
        localObject = new bhhf(bgks.a, (File)localObject);
        ((bhhf)localObject).p = false;
        Bundle localBundle = new Bundle();
        localbhhk.a((bhhf)localObject, (bhhe)this.a.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.IconRunnable
 * JD-Core Version:    0.7.0.1
 */