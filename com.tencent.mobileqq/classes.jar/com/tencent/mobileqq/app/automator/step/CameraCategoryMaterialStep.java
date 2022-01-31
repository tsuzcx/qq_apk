package com.tencent.mobileqq.app.automator.step;

import biqs;
import birq;
import bjaa;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  private long a()
  {
    return bjaa.a().a("lasttime", 0L, 0);
  }
  
  private String a()
  {
    return bjaa.a().a("last_entry_version", "", 4);
  }
  
  private void a(String paramString)
  {
    bjaa.a().a("last_entry_version", paramString, 4);
  }
  
  private void b(long paramLong)
  {
    bjaa.a().a("lasttime", paramLong, 0);
  }
  
  public int a()
  {
    biqs localbiqs = (biqs)this.a.app.a(159);
    if (System.currentTimeMillis() - a() > 86400000L)
    {
      b(System.currentTimeMillis());
      a(AppSetting.a());
      localbiqs.a("MqStoryCamera");
      localbiqs.a("MqEmoCamera");
      localbiqs.b();
      localbiqs.a();
      birq.a().a(0, null, false);
    }
    for (;;)
    {
      return super.a();
      if (!AppSetting.a().equals(a()))
      {
        a(AppSetting.a());
        localbiqs.a();
        birq.a().a(0, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */