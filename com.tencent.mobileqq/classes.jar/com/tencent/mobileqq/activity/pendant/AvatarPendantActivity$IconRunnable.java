package com.tencent.mobileqq.activity.pendant;

import android.os.Bundle;
import bhkt;
import biht;
import bihu;
import bihw;
import bihz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AvatarPendantActivity$IconRunnable
  implements Runnable
{
  WeakReference<biht> a;
  WeakReference<QQAppInterface> b;
  
  AvatarPendantActivity$IconRunnable(AvatarPendantActivity paramAvatarPendantActivity, biht parambiht, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(parambiht);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.a.get() != null))
    {
      bihz localbihz = ((bihw)((QQAppInterface)this.b.get()).getManager(47)).a(1);
      if (localbihz.a(bhkt.a) == null)
      {
        Object localObject = new File(bhkt.b + "/icon.zip");
        localObject = new bihu(bhkt.a, (File)localObject);
        ((bihu)localObject).p = false;
        Bundle localBundle = new Bundle();
        localbihz.a((bihu)localObject, (biht)this.a.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.IconRunnable
 * JD-Core Version:    0.7.0.1
 */