package com.tencent.mobileqq.activity.pendant;

import android.os.Bundle;
import bfua;
import bgod;
import bgoe;
import bgog;
import bgoj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AvatarPendantActivity$IconRunnable
  implements Runnable
{
  WeakReference<bgod> a;
  WeakReference<QQAppInterface> b;
  
  AvatarPendantActivity$IconRunnable(AvatarPendantActivity paramAvatarPendantActivity, bgod parambgod, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(parambgod);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.a.get() != null))
    {
      bgoj localbgoj = ((bgog)((QQAppInterface)this.b.get()).getManager(47)).a(1);
      if (localbgoj.a(bfua.a) == null)
      {
        Object localObject = new File(bfua.b + "/icon.zip");
        localObject = new bgoe(bfua.a, (File)localObject);
        ((bgoe)localObject).p = false;
        Bundle localBundle = new Bundle();
        localbgoj.a((bgoe)localObject, (bgod)this.a.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.IconRunnable
 * JD-Core Version:    0.7.0.1
 */