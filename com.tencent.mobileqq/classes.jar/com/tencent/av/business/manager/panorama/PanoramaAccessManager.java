package com.tencent.av.business.manager.panorama;

import com.tencent.av.opengl.effects.EffectCtrlUtils;
import com.tencent.mobileqq.shortvideo.resource.PtuFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SdkContext;
import java.util.Iterator;
import java.util.List;

public class PanoramaAccessManager
{
  public static boolean a()
  {
    SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
    SdkContext.getInstance().getResources().getPtuFilterResource().getPortraitPathDir();
    boolean bool1 = PtvFilterSoLoad.h() ^ true;
    boolean bool2 = PanoramaSensorManager.a().b();
    boolean bool4 = PanoramaEffectDPC.b();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkPanoramaAccessEnable portraitSo = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("| sensorEnable = ");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(" |DPCEntry = ");
      ((StringBuilder)localObject).append(bool4);
      QLog.d("PanoramaAccessManager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool3 = false;
    boolean bool5 = false;
    if ((bool1) && (bool2) && (bool4)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1)
    {
      localObject = PanoramaEffectDPC.d();
      if (localObject != null)
      {
        long l = PanoramaEffectDPC.c();
        localObject = ((List)localObject).iterator();
        bool4 = false;
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label307;
          }
          PanoramaEffectDPC.DeviceCPUinfo localDeviceCPUinfo = (PanoramaEffectDPC.DeviceCPUinfo)((Iterator)localObject).next();
          if (localDeviceCPUinfo != null)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("checkPanoramaAccessEnable CPUinfo = ");
              localStringBuilder.append(localDeviceCPUinfo.b);
              localStringBuilder.append("|");
              localStringBuilder.append(localDeviceCPUinfo.a);
              QLog.d("PanoramaAccessManager", 2, localStringBuilder.toString());
            }
            if ((!bool4) && (!EffectCtrlUtils.a(localDeviceCPUinfo.b, localDeviceCPUinfo.a * 10000, l * 100000000L))) {
              break;
            }
            bool4 = true;
          }
        }
        label307:
        bool2 = bool5;
        if (bool1)
        {
          bool2 = bool5;
          if (bool4) {
            bool2 = true;
          }
        }
        bool3 = bool2;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkPanoramaAccessEnable isDeviceSupport = ");
          ((StringBuilder)localObject).append(bool4);
          QLog.d("PanoramaAccessManager", 2, ((StringBuilder)localObject).toString());
          return bool2;
        }
      }
    }
    else
    {
      bool3 = bool1;
    }
    return bool3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.panorama.PanoramaAccessManager
 * JD-Core Version:    0.7.0.1
 */