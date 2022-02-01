package com.tencent.luggage.scanner.camera;

import android.hardware.Camera;
import android.os.Build;

class e
  implements h.a
{
  private static int a()
  {
    if (!Build.MODEL.equals("M9")) {
      return -1;
    }
    Object localObject = Build.DISPLAY;
    if (((String)localObject).substring(0, 0).equals("1")) {
      return -1;
    }
    localObject = ((String)localObject).split("-");
    if (localObject != null)
    {
      if (localObject.length < 2) {
        return -1;
      }
      return ScanUtil.getInt(localObject[1], 0);
    }
    return -1;
  }
  
  public h.a.a a(int paramInt1, int paramInt2)
  {
    h.a.a locala = new h.a.a();
    try
    {
      locala.a = Camera.open();
      locala.b = 0;
      if (locala.a == null) {
        return null;
      }
      if (Build.DISPLAY.startsWith("Flyme"))
      {
        locala.b = 90;
        locala.a.setDisplayOrientation(90);
        return locala;
      }
      if (a() >= 7093)
      {
        locala.b = 90;
        locala.a.setDisplayOrientation(180);
      }
      return locala;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.e
 * JD-Core Version:    0.7.0.1
 */