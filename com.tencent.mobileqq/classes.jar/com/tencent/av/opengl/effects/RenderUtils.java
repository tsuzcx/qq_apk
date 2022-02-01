package com.tencent.av.opengl.effects;

import com.tencent.av.VideoController;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;

public class RenderUtils
{
  public static void a(boolean paramBoolean)
  {
    VideoController.a().g(paramBoolean);
    if (VideoController.a().i() == VideoController.l) {
      QLog.i("RenderUtils", 1, "setAEDetectInited, init FaceSDK falied.");
    }
  }
  
  public static boolean a(PendantItem paramPendantItem1, PendantItem paramPendantItem2)
  {
    if ((paramPendantItem1 == null) && (paramPendantItem2 == null)) {}
    while ((paramPendantItem1 != null) && (paramPendantItem2 != null) && ((paramPendantItem1.getId() == null) || (paramPendantItem2.getId() == null) || (paramPendantItem1.getId().equalsIgnoreCase(paramPendantItem2.getId())))) {
      return true;
    }
    return false;
  }
  
  public static boolean a(FilterDesc paramFilterDesc1, FilterDesc paramFilterDesc2)
  {
    if ((paramFilterDesc1 == null) && (paramFilterDesc2 == null)) {}
    while ((paramFilterDesc1 != null) && (paramFilterDesc2 != null) && ((paramFilterDesc1.name == null) || (paramFilterDesc2.name == null) || (paramFilterDesc1.name.equalsIgnoreCase(paramFilterDesc2.name)))) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.RenderUtils
 * JD-Core Version:    0.7.0.1
 */