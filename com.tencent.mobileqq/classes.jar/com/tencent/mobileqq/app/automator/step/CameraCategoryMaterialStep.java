package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import bnot;
import bnpt;
import bnpu;
import bnyp;
import bnzb;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  private long a()
  {
    return bnyp.a().a("lasttime", 0L, 0);
  }
  
  private String a()
  {
    return bnyp.a().a("last_entry_version", "", 4);
  }
  
  private void a(String paramString)
  {
    bnyp.a().a("last_entry_version", paramString, 4);
  }
  
  private void b(long paramLong)
  {
    bnyp.a().a("lasttime", paramLong, 0);
  }
  
  public int a()
  {
    bnot localbnot;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localbnot = (bnot)this.a.app.a(159);
      if (System.currentTimeMillis() - a() > 86400000L)
      {
        b(System.currentTimeMillis());
        a(AppSetting.a());
        localbnot.a("MqStoryCamera");
        localbnot.a("MqEmoCamera");
        localbnot.b();
        localbnot.a();
        bnpu.a().b(bnpt.b, null, false);
      }
    }
    for (;;)
    {
      return super.a();
      if (!AppSetting.a().equals(a()))
      {
        a(AppSetting.a());
        localbnot.a();
        bnpu.a().b(bnpt.b, null, false);
        continue;
        bnzb.d("QQInitHandler", "[CameraCategoryMaterialStep] Build.VERSION.SDK_INT < 5.0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */