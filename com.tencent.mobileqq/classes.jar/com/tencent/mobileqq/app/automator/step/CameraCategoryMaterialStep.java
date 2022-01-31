package com.tencent.mobileqq.app.automator.step;

import bkzp;
import blao;
import blap;
import bljc;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  private long a()
  {
    return bljc.a().a("lasttime", 0L, 0);
  }
  
  private String a()
  {
    return bljc.a().a("last_entry_version", "", 4);
  }
  
  private void a(String paramString)
  {
    bljc.a().a("last_entry_version", paramString, 4);
  }
  
  private void b(long paramLong)
  {
    bljc.a().a("lasttime", paramLong, 0);
  }
  
  public int a()
  {
    bkzp localbkzp = (bkzp)this.a.app.a(159);
    if (System.currentTimeMillis() - a() > 86400000L)
    {
      b(System.currentTimeMillis());
      a(AppSetting.a());
      localbkzp.a("MqStoryCamera");
      localbkzp.a("MqEmoCamera");
      localbkzp.b();
      localbkzp.a();
      blap.a().a(blao.b, null, false);
    }
    for (;;)
    {
      return super.a();
      if (!AppSetting.a().equals(a()))
      {
        a(AppSetting.a());
        localbkzp.a();
        blap.a().a(blao.b, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */