package com.tencent.mobileqq.activity.pendant;

import android.os.Bundle;
import bhcs;
import bhyn;
import bhyo;
import bhyq;
import bhyt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class AvatarPendantActivity$IconRunnable
  implements Runnable
{
  WeakReference<bhyn> a;
  WeakReference<QQAppInterface> b;
  
  AvatarPendantActivity$IconRunnable(AvatarPendantActivity paramAvatarPendantActivity, bhyn parambhyn, QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(parambhyn);
    this.b = new WeakReference(paramQQAppInterface);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "checkAvatarPendantMarketIcon start...");
    }
    if ((this.b.get() != null) && (this.a.get() != null))
    {
      bhyt localbhyt = ((bhyq)((QQAppInterface)this.b.get()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
      if (localbhyt.a(bhcs.a) == null)
      {
        Object localObject = new File(bhcs.b + "/icon.zip");
        localObject = new bhyo(bhcs.a, (File)localObject);
        ((bhyo)localObject).p = false;
        Bundle localBundle = new Bundle();
        localbhyt.a((bhyo)localObject, (bhyn)this.a.get(), localBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.IconRunnable
 * JD-Core Version:    0.7.0.1
 */