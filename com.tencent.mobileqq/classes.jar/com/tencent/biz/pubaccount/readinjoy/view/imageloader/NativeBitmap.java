package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import azri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import sfm;

public class NativeBitmap
{
  static boolean a = true;
  
  static
  {
    try
    {
      a = SoLoadUtil.a(BaseApplicationImpl.getApplication(), "readinjoybitmaps", 0, true);
      return;
    }
    catch (Exception localException)
    {
      a = false;
      if (QLog.isColorLevel()) {
        sfm.a("NativeBitmap", "load so fail");
      }
      if (BaseApplicationImpl.sProcessId == 1)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("model", Build.MODEL);
        localHashMap.put("androidVersion", Build.VERSION.SDK);
        localHashMap.put("brand", Build.BRAND);
        azri.a(BaseApplicationImpl.getApplication()).a(null, "readinjoy.loadso", false, 0L, 0L, localHashMap, null);
      }
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        sfm.a("NativeBitmap", "canUseNativeBitmap:" + a);
      }
    }
  }
  
  public static native void nativePinBitmap(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.NativeBitmap
 * JD-Core Version:    0.7.0.1
 */