package com.tencent.mobileqq.activity.pendant;

import android.os.Bundle;
import baau;
import batl;
import batm;
import bato;
import batr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AvatarPendantActivity$IconRunnable
  implements Runnable
{
  WeakReference<batl> a;
  WeakReference<QQAppInterface> b;
  
  AvatarPendantActivity$IconRunnable(AvatarPendantActivity paramAvatarPendantActivity, batl parambatl, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(parambatl);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.a.get() != null))
    {
      batr localbatr = ((bato)((QQAppInterface)this.b.get()).getManager(47)).a(1);
      if (localbatr.a(baau.a) == null)
      {
        Object localObject = new File(baau.b + "/icon.zip");
        localObject = new batm(baau.a, (File)localObject);
        ((batm)localObject).p = false;
        Bundle localBundle = new Bundle();
        localbatr.a((batm)localObject, (batl)this.a.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.IconRunnable
 * JD-Core Version:    0.7.0.1
 */