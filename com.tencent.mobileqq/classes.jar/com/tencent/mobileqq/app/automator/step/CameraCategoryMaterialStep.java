package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import blul;
import blvn;
import bmbk;
import bmbx;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import dov.com.qq.im.ae.download.AEResInfo;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  private long a()
  {
    return bmbk.a().a("lasttime", 0L, 0);
  }
  
  private String a()
  {
    return bmbk.a().a("last_entry_version", "", 4);
  }
  
  private void a(String paramString)
  {
    bmbk.a().a("last_entry_version", paramString, 4);
  }
  
  private void b(long paramLong)
  {
    bmbk.a().a("lasttime", paramLong, 0);
  }
  
  public int a()
  {
    blul localblul;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localblul = (blul)this.a.app.getBusinessHandler(159);
      if (System.currentTimeMillis() - a() > 86400000L)
      {
        b(System.currentTimeMillis());
        a(AppSetting.a());
        localblul.a("MqStoryCamera");
        localblul.a("MqEmoCamera");
        localblul.b();
        localblul.a();
        blvn.a().b(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
      }
    }
    for (;;)
    {
      return super.a();
      if (!AppSetting.a().equals(a()))
      {
        a(AppSetting.a());
        localblul.a();
        blvn.a().b(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
        continue;
        bmbx.d("QQInitHandler", "[CameraCategoryMaterialStep] Build.VERSION.SDK_INT < 5.0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */