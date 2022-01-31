package com.tencent.mobileqq.activity.pendant;

import android.os.Bundle;
import bdfp;
import bead;
import beae;
import beag;
import beaj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AvatarPendantActivity$IconRunnable
  implements Runnable
{
  WeakReference<bead> a;
  WeakReference<QQAppInterface> b;
  
  AvatarPendantActivity$IconRunnable(AvatarPendantActivity paramAvatarPendantActivity, bead parambead, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(parambead);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.a.get() != null))
    {
      beaj localbeaj = ((beag)((QQAppInterface)this.b.get()).getManager(47)).a(1);
      if (localbeaj.a(bdfp.a) == null)
      {
        Object localObject = new File(bdfp.b + "/icon.zip");
        localObject = new beae(bdfp.a, (File)localObject);
        ((beae)localObject).p = false;
        Bundle localBundle = new Bundle();
        localbeaj.a((beae)localObject, (bead)this.a.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.IconRunnable
 * JD-Core Version:    0.7.0.1
 */