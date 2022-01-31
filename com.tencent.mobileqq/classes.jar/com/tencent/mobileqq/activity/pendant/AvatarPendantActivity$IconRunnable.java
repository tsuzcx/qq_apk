package com.tencent.mobileqq.activity.pendant;

import android.os.Bundle;
import bbby;
import bbwf;
import bbwg;
import bbwi;
import bbwl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AvatarPendantActivity$IconRunnable
  implements Runnable
{
  WeakReference<bbwf> a;
  WeakReference<QQAppInterface> b;
  
  AvatarPendantActivity$IconRunnable(AvatarPendantActivity paramAvatarPendantActivity, bbwf parambbwf, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(parambbwf);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.a.get() != null))
    {
      bbwl localbbwl = ((bbwi)((QQAppInterface)this.b.get()).getManager(47)).a(1);
      if (localbbwl.a(bbby.a) == null)
      {
        Object localObject = new File(bbby.b + "/icon.zip");
        localObject = new bbwg(bbby.a, (File)localObject);
        ((bbwg)localObject).p = false;
        Bundle localBundle = new Bundle();
        localbbwl.a((bbwg)localObject, (bbwf)this.a.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.IconRunnable
 * JD-Core Version:    0.7.0.1
 */