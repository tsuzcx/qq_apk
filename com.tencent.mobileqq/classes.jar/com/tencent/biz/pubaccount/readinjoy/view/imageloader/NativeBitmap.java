package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import axrn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import rpn;

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
        rpn.a("NativeBitmap", "load so fail");
      }
      if (BaseApplicationImpl.sProcessId == 1)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("model", Build.MODEL);
        localHashMap.put("androidVersion", Build.VERSION.SDK);
        localHashMap.put("brand", Build.BRAND);
        axrn.a(BaseApplicationImpl.getApplication()).a(null, "readinjoy.loadso", false, 0L, 0L, localHashMap, null);
      }
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        rpn.a("NativeBitmap", "canUseNativeBitmap:" + a);
      }
    }
  }
  
  public static native void nativePinBitmap(Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.NativeBitmap
 * JD-Core Version:    0.7.0.1
 */