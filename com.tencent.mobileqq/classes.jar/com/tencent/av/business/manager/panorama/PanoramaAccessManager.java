package com.tencent.av.business.manager.panorama;

import com.tencent.av.opengl.effects.EffectsRenderController;
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
    boolean bool3 = true;
    SdkContext.getInstance().getResources().getPtuFilterResource().getSoPathDir();
    SdkContext.getInstance().getResources().getPtuFilterResource().getPortraitPathDir();
    if (!PtvFilterSoLoad.e())
    {
      bool1 = true;
      bool2 = PanoramaSensorManager.a().a();
      boolean bool4 = PanoramaEffectDPC.a();
      if (QLog.isColorLevel()) {
        QLog.d("PanoramaAccessManager", 2, "checkPanoramaAccessEnable portraitSo = " + bool1 + "| sensorEnable = " + bool2 + " |DPCEntry = " + bool4);
      }
      if ((!bool1) || (!bool2) || (!bool4)) {
        break label265;
      }
      bool2 = true;
      label118:
      if (!bool2) {
        return bool2;
      }
      Object localObject = PanoramaEffectDPC.a();
      if (localObject == null) {
        break label323;
      }
      long l = PanoramaEffectDPC.a();
      localObject = ((List)localObject).iterator();
      bool1 = false;
      label149:
      PanoramaEffectDPC.DeviceCPUinfo localDeviceCPUinfo;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localDeviceCPUinfo = (PanoramaEffectDPC.DeviceCPUinfo)((Iterator)localObject).next();
      } while (localDeviceCPUinfo == null);
      if (QLog.isColorLevel()) {
        QLog.d("PanoramaAccessManager", 2, "checkPanoramaAccessEnable CPUinfo = " + localDeviceCPUinfo.b + "|" + localDeviceCPUinfo.a);
      }
      if ((!bool1) && (!EffectsRenderController.a(localDeviceCPUinfo.b, localDeviceCPUinfo.a * 10000, l * 100000000L))) {
        break label270;
      }
    }
    label265:
    label270:
    for (boolean bool1 = true;; bool1 = false)
    {
      break label149;
      bool1 = false;
      break;
      bool2 = false;
      break label118;
    }
    if ((bool2) && (bool1)) {}
    for (boolean bool2 = bool3;; bool2 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PanoramaAccessManager", 2, "checkPanoramaAccessEnable isDeviceSupport = " + bool1);
      }
      return bool2;
    }
    label323:
    return false;
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.panorama.PanoramaAccessManager
 * JD-Core Version:    0.7.0.1
 */