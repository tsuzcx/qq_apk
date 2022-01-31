package com.tencent.mobileqq.app.automator.step;

import bkvi;
import bkwh;
import bkwi;
import blev;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  private long a()
  {
    return blev.a().a("lasttime", 0L, 0);
  }
  
  private String a()
  {
    return blev.a().a("last_entry_version", "", 4);
  }
  
  private void a(String paramString)
  {
    blev.a().a("last_entry_version", paramString, 4);
  }
  
  private void b(long paramLong)
  {
    blev.a().a("lasttime", paramLong, 0);
  }
  
  public int a()
  {
    bkvi localbkvi = (bkvi)this.a.app.a(159);
    if (System.currentTimeMillis() - a() > 86400000L)
    {
      b(System.currentTimeMillis());
      a(AppSetting.a());
      localbkvi.a("MqStoryCamera");
      localbkvi.a("MqEmoCamera");
      localbkvi.b();
      localbkvi.a();
      bkwi.a().a(bkwh.b, null, false);
    }
    for (;;)
    {
      return super.a();
      if (!AppSetting.a().equals(a()))
      {
        a(AppSetting.a());
        localbkvi.a();
        bkwi.a().a(bkwh.b, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */