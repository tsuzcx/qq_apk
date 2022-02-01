package com.tencent.av.utils;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

public class DataReport$ShortCut_For_Effect
{
  public static void a()
  {
    DataReport.a("0X800A3D9", VideoController.f().k().g);
  }
  
  public static void a(boolean paramBoolean)
  {
    SessionInfo localSessionInfo = VideoController.f().k();
    if (paramBoolean) {
      AVUtil.a("0X800BC0C", DataReport.b(localSessionInfo), 2, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.DataReport.ShortCut_For_Effect
 * JD-Core Version:    0.7.0.1
 */