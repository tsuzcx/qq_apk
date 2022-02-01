package com.tencent.gdtad.inject;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.impl.GdtThirdProcessorImpl;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtThirdProcessorProxy
  implements IGdtThirdProcessor
{
  @ConfigInject(configPath="Business/qqad-api/src/main/resources/Inject_AdInject.yml", version=1)
  public static ArrayList<Class<? extends IGdtThirdProcessor>> a = new ArrayList();
  public IGdtThirdProcessor b = null;
  
  static
  {
    a.add(GdtThirdProcessorImpl.class);
  }
  
  public Drawable a(Context paramContext, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, int paramInt1, int paramInt2)
  {
    b();
    IGdtThirdProcessor localIGdtThirdProcessor = this.b;
    if (localIGdtThirdProcessor != null) {
      return localIGdtThirdProcessor.a(paramContext, paramGdtMotiveVideoPageData, paramInt1, paramInt2);
    }
    return null;
  }
  
  public Drawable a(Context paramContext, String paramString)
  {
    b();
    IGdtThirdProcessor localIGdtThirdProcessor = this.b;
    if (localIGdtThirdProcessor != null) {
      return localIGdtThirdProcessor.a(paramContext, paramString);
    }
    return null;
  }
  
  public String a(Context paramContext)
  {
    b();
    IGdtThirdProcessor localIGdtThirdProcessor = this.b;
    if (localIGdtThirdProcessor != null) {
      return localIGdtThirdProcessor.a(paramContext);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    b();
    IGdtThirdProcessor localIGdtThirdProcessor = this.b;
    if (localIGdtThirdProcessor != null) {
      localIGdtThirdProcessor.a(paramInt1, paramInt2, paramAdInfo);
    }
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    b();
    IGdtThirdProcessor localIGdtThirdProcessor = this.b;
    if (localIGdtThirdProcessor != null) {
      localIGdtThirdProcessor.a(paramIntent, paramString);
    }
  }
  
  public void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    b();
    IGdtThirdProcessor localIGdtThirdProcessor = this.b;
    if (localIGdtThirdProcessor != null) {
      localIGdtThirdProcessor.a(paramGdtMotiveVideoPageData, paramLong1, paramLong2, paramBoolean);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    b();
    IGdtThirdProcessor localIGdtThirdProcessor = this.b;
    if (localIGdtThirdProcessor != null) {
      localIGdtThirdProcessor.a(paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    b();
    IGdtThirdProcessor localIGdtThirdProcessor = this.b;
    if (localIGdtThirdProcessor != null) {
      return localIGdtThirdProcessor.a();
    }
    return false;
  }
  
  public Drawable b(Context paramContext, String paramString)
  {
    b();
    IGdtThirdProcessor localIGdtThirdProcessor = this.b;
    if (localIGdtThirdProcessor != null) {
      return localIGdtThirdProcessor.b(paramContext, paramString);
    }
    return null;
  }
  
  public void b()
  {
    try
    {
      if (this.b == null)
      {
        if (a != null)
        {
          boolean bool = a.isEmpty();
          if (!bool)
          {
            try
            {
              this.b = ((IGdtThirdProcessor)((Class)a.get(0)).newInstance());
            }
            catch (Exception localException)
            {
              QLog.e("GdtThirdProcessorProxy", 1, localException, new Object[0]);
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("initProcessor size = ");
            localStringBuilder.append(a.size());
            QLog.i("GdtThirdProcessorProxy", 1, localStringBuilder.toString());
            break label108;
          }
        }
        QLog.i("GdtThirdProcessorProxy", 1, "initProcessor is empty ");
      }
      label108:
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.inject.GdtThirdProcessorProxy
 * JD-Core Version:    0.7.0.1
 */