package com.tencent.mobileqq.activity.richmedia;

import com.tencent.av.camera.QavCameraUsage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;

public class FlowCameraMqqAction
{
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, "", "", "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "dc00898", paramString1, "", paramString2, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static boolean a()
  {
    return QavCameraUsage.b(BaseApplicationImpl.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction
 * JD-Core Version:    0.7.0.1
 */