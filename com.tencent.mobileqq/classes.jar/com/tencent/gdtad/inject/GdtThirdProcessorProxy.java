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
  public static ArrayList<Class<? extends IGdtThirdProcessor>> a;
  public IGdtThirdProcessor a;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(GdtThirdProcessorImpl.class);
  }
  
  public GdtThirdProcessorProxy()
  {
    this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor = null;
  }
  
  public Drawable a(Context paramContext, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, int paramInt1, int paramInt2)
  {
    a();
    IGdtThirdProcessor localIGdtThirdProcessor = this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor;
    if (localIGdtThirdProcessor != null) {
      return localIGdtThirdProcessor.a(paramContext, paramGdtMotiveVideoPageData, paramInt1, paramInt2);
    }
    return null;
  }
  
  public Drawable a(Context paramContext, String paramString)
  {
    a();
    IGdtThirdProcessor localIGdtThirdProcessor = this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor;
    if (localIGdtThirdProcessor != null) {
      return localIGdtThirdProcessor.a(paramContext, paramString);
    }
    return null;
  }
  
  public String a(Context paramContext)
  {
    a();
    IGdtThirdProcessor localIGdtThirdProcessor = this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor;
    if (localIGdtThirdProcessor != null) {
      return localIGdtThirdProcessor.a(paramContext);
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor == null)
      {
        if (jdField_a_of_type_JavaUtilArrayList != null)
        {
          boolean bool = jdField_a_of_type_JavaUtilArrayList.isEmpty();
          if (!bool)
          {
            try
            {
              this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor = ((IGdtThirdProcessor)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance());
            }
            catch (Exception localException)
            {
              QLog.e("GdtThirdProcessorProxy", 1, localException, new Object[0]);
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("initProcessor size = ");
            localStringBuilder.append(jdField_a_of_type_JavaUtilArrayList.size());
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
  
  public void a(int paramInt1, int paramInt2, qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    a();
    IGdtThirdProcessor localIGdtThirdProcessor = this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor;
    if (localIGdtThirdProcessor != null) {
      localIGdtThirdProcessor.a(paramInt1, paramInt2, paramAdInfo);
    }
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    a();
    IGdtThirdProcessor localIGdtThirdProcessor = this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor;
    if (localIGdtThirdProcessor != null) {
      localIGdtThirdProcessor.a(paramIntent, paramString);
    }
  }
  
  public void a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    a();
    IGdtThirdProcessor localIGdtThirdProcessor = this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor;
    if (localIGdtThirdProcessor != null) {
      localIGdtThirdProcessor.a(paramGdtMotiveVideoPageData, paramLong1, paramLong2, paramBoolean);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a();
    IGdtThirdProcessor localIGdtThirdProcessor = this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor;
    if (localIGdtThirdProcessor != null) {
      localIGdtThirdProcessor.a(paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    a();
    IGdtThirdProcessor localIGdtThirdProcessor = this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor;
    if (localIGdtThirdProcessor != null) {
      return localIGdtThirdProcessor.a();
    }
    return false;
  }
  
  public Drawable b(Context paramContext, String paramString)
  {
    a();
    IGdtThirdProcessor localIGdtThirdProcessor = this.jdField_a_of_type_ComTencentGdtadInjectIGdtThirdProcessor;
    if (localIGdtThirdProcessor != null) {
      return localIGdtThirdProcessor.b(paramContext, paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.inject.GdtThirdProcessorProxy
 * JD-Core Version:    0.7.0.1
 */