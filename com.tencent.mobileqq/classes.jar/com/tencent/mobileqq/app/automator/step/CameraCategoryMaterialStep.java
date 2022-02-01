package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import bnjo;
import bnkt;
import bnku;
import bnqu;
import bnrh;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CameraCategoryMaterialStep
  extends AsyncStep
{
  private long a()
  {
    return bnqu.a().a("lasttime", 0L, 0);
  }
  
  private String a()
  {
    return bnqu.a().a("last_entry_version", "", 4);
  }
  
  private void a(String paramString)
  {
    bnqu.a().a("last_entry_version", paramString, 4);
  }
  
  private void b(long paramLong)
  {
    bnqu.a().a("lasttime", paramLong, 0);
  }
  
  public int a()
  {
    bnjo localbnjo;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localbnjo = (bnjo)this.a.app.getBusinessHandler(BusinessHandlerFactory.CAMERA_HANDLER);
      if (System.currentTimeMillis() - a() > 86400000L)
      {
        b(System.currentTimeMillis());
        a(AppSetting.a());
        localbnjo.a("MqStoryCamera");
        localbnjo.a("MqEmoCamera");
        localbnjo.a("MqCircleWatermark");
        localbnjo.b();
        localbnjo.a();
        bnku.a().b(bnkt.b, null, false);
      }
    }
    for (;;)
    {
      return super.a();
      if (!AppSetting.a().equals(a()))
      {
        a(AppSetting.a());
        localbnjo.a();
        bnku.a().b(bnkt.b, null, false);
        continue;
        bnrh.d("QQInitHandler", "[CameraCategoryMaterialStep] Build.VERSION.SDK_INT < 5.0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CameraCategoryMaterialStep
 * JD-Core Version:    0.7.0.1
 */