package com.tencent.mobileqq.app.automator.step;

import avzi;
import awgh;
import bgxb;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  private long a()
  {
    return bgxb.a().a("lasttime", 0L, 0);
  }
  
  private String a()
  {
    return bgxb.a().a("last_entry_version", "", 4);
  }
  
  private void a(String paramString)
  {
    bgxb.a().a("last_entry_version", paramString, 4);
  }
  
  private void b(long paramLong)
  {
    bgxb.a().a("lasttime", paramLong, 0);
  }
  
  public int a()
  {
    avzi localavzi = (avzi)this.a.app.a(159);
    if (System.currentTimeMillis() - a() > 86400000L)
    {
      b(System.currentTimeMillis());
      a(AppSetting.a());
      localavzi.a("MqStoryCamera");
      localavzi.a("MqEmoCamera");
      localavzi.b();
      localavzi.a();
      awgh.a().a(0, null);
    }
    for (;;)
    {
      return super.a();
      if (!AppSetting.a().equals(a()))
      {
        a(AppSetting.a());
        localavzi.a();
        awgh.a().a(0, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */