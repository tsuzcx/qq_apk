package com.tencent.mobileqq.activity.pendant;

import android.os.Bundle;
import bbcm;
import bbwt;
import bbwu;
import bbww;
import bbwz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AvatarPendantActivity$IconRunnable
  implements Runnable
{
  WeakReference<bbwt> a;
  WeakReference<QQAppInterface> b;
  
  AvatarPendantActivity$IconRunnable(AvatarPendantActivity paramAvatarPendantActivity, bbwt parambbwt, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(parambbwt);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.a.get() != null))
    {
      bbwz localbbwz = ((bbww)((QQAppInterface)this.b.get()).getManager(47)).a(1);
      if (localbbwz.a(bbcm.a) == null)
      {
        Object localObject = new File(bbcm.b + "/icon.zip");
        localObject = new bbwu(bbcm.a, (File)localObject);
        ((bbwu)localObject).p = false;
        Bundle localBundle = new Bundle();
        localbbwz.a((bbwu)localObject, (bbwt)this.a.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.IconRunnable
 * JD-Core Version:    0.7.0.1
 */