package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import boqe;
import borf;
import borg;
import bozz;
import bpam;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  private long a()
  {
    return bozz.a().a("lasttime", 0L, 0);
  }
  
  private String a()
  {
    return bozz.a().a("last_entry_version", "", 4);
  }
  
  private void a(String paramString)
  {
    bozz.a().a("last_entry_version", paramString, 4);
  }
  
  private void b(long paramLong)
  {
    bozz.a().a("lasttime", paramLong, 0);
  }
  
  public int a()
  {
    boqe localboqe;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localboqe = (boqe)this.a.app.a(159);
      if (System.currentTimeMillis() - a() > 86400000L)
      {
        b(System.currentTimeMillis());
        a(AppSetting.a());
        localboqe.a("MqStoryCamera");
        localboqe.a("MqEmoCamera");
        localboqe.b();
        localboqe.a();
        borg.a().b(borf.b, null, false);
      }
    }
    for (;;)
    {
      return super.a();
      if (!AppSetting.a().equals(a()))
      {
        a(AppSetting.a());
        localboqe.a();
        borg.a().b(borf.b, null, false);
        continue;
        bpam.d("QQInitHandler", "[CameraCategoryMaterialStep] Build.VERSION.SDK_INT < 5.0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */