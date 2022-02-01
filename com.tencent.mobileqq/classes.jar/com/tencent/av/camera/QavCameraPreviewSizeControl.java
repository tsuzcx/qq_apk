package com.tencent.av.camera;

import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.av.utils.machine.MachineLevelHelper;
import com.tencent.util.Pair;

public final class QavCameraPreviewSizeControl
{
  private static MachineLevelHelper a;
  
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    boolean bool = b();
    int i = 720;
    int j = 1920;
    if ((paramInt1 >= 640) && (paramInt2 >= 480))
    {
      if ((paramInt1 < 1920) && (paramInt2 < 1080))
      {
        paramInt1 = 1280;
        paramInt2 = i;
        i = paramInt1;
      }
      else
      {
        paramInt2 = 1080;
        i = j;
      }
    }
    else
    {
      if (bool) {
        paramInt1 = 640;
      } else {
        paramInt1 = 1280;
      }
      paramInt2 = i;
      i = paramInt1;
      if (bool)
      {
        paramInt2 = 480;
        i = paramInt1;
      }
    }
    return new Pair(Integer.valueOf(i), Integer.valueOf(paramInt2));
  }
  
  public static boolean a()
  {
    return AndroidCamera.g();
  }
  
  private static boolean b()
  {
    if (a == null) {
      a = new MachineLevelHelper(QAVConfigUtils.b("machineMiddleLine"), QAVConfigUtils.b("machineHighLine"));
    }
    return a.a() == 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.QavCameraPreviewSizeControl
 * JD-Core Version:    0.7.0.1
 */