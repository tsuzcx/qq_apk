package com.tencent.mobileqq.activity.pendant;

import android.os.Bundle;
import bdbg;
import bdvu;
import bdvv;
import bdvx;
import bdwa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AvatarPendantActivity$IconRunnable
  implements Runnable
{
  WeakReference<bdvu> a;
  WeakReference<QQAppInterface> b;
  
  AvatarPendantActivity$IconRunnable(AvatarPendantActivity paramAvatarPendantActivity, bdvu parambdvu, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(parambdvu);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.a.get() != null))
    {
      bdwa localbdwa = ((bdvx)((QQAppInterface)this.b.get()).getManager(47)).a(1);
      if (localbdwa.a(bdbg.a) == null)
      {
        Object localObject = new File(bdbg.b + "/icon.zip");
        localObject = new bdvv(bdbg.a, (File)localObject);
        ((bdvv)localObject).p = false;
        Bundle localBundle = new Bundle();
        localbdwa.a((bdvv)localObject, (bdvu)this.a.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.IconRunnable
 * JD-Core Version:    0.7.0.1
 */