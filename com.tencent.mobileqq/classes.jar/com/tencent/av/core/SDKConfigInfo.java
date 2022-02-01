package com.tencent.av.core;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import lbf;
import lkw;
import lnr;
import lnt;

public class SDKConfigInfo
{
  private static final String TAG = "SDKConfigInfo";
  private boolean isDebugVersion = false;
  private boolean isGrayVersion = false;
  private boolean isPublicVersion = true;
  private String logDir = lbf.k();
  private String logFilePrefix = "com.tencent.mobileqq";
  private String processName = "";
  private int terminalType = 4;
  
  @TargetApi(9)
  public static String getDeviceInfo(Context paramContext)
  {
    Object localObject1 = "PRODUCT=" + Build.PRODUCT + ";";
    localObject1 = (String)localObject1 + "CPU_ABI=" + Build.CPU_ABI + ";";
    localObject1 = (String)localObject1 + "TAGS=" + Build.TAGS + ";";
    localObject1 = (String)localObject1 + "VERSION_CODES_BASE=1;";
    localObject1 = (String)localObject1 + "MODEL=" + Build.MODEL + ";";
    localObject1 = (String)localObject1 + "SDK=" + Build.VERSION.SDK_INT + ";";
    localObject1 = (String)localObject1 + "VERSION_RELEASE=" + Build.VERSION.RELEASE + ";";
    localObject1 = (String)localObject1 + "DEVICE=" + Build.DEVICE + ";";
    localObject1 = (String)localObject1 + "DISPLAY=" + Build.DISPLAY + ";";
    localObject1 = (String)localObject1 + "BRAND=" + Build.BRAND + ";";
    localObject1 = (String)localObject1 + "BOARD=" + Build.BOARD + ";";
    localObject1 = (String)localObject1 + "FINGERPRINT=" + Build.FINGERPRINT + ";";
    localObject1 = (String)localObject1 + "ID=" + Build.ID + ";";
    localObject1 = (String)localObject1 + "MANUFACTURER=" + Build.MANUFACTURER + ";";
    localObject1 = (String)localObject1 + "USER=" + Build.USER + ";";
    Object localObject2 = lnr.a("SDKConfigInfo", paramContext);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      Iterator localIterator = ((ArrayList)localObject2).iterator();
      localObject2 = localObject1;
      if (!localIterator.hasNext()) {
        break label1009;
      }
      localObject2 = (lnt)localIterator.next();
      if ((((lnt)localObject2).jdField_a_of_type_Int == 1) && (((lnt)localObject2).jdField_a_of_type_Boolean))
      {
        localObject1 = (String)localObject1 + "HWAVCDEC=1;";
        localObject1 = (String)localObject1 + "HWAVCDEC_MAXW=" + ((lnt)localObject2).b + ";";
        localObject1 = (String)localObject1 + "HWAVCDEC_MAXH=" + ((lnt)localObject2).c + ";";
      }
    }
    for (;;)
    {
      break;
      if ((((lnt)localObject2).jdField_a_of_type_Int == 2) && (((lnt)localObject2).jdField_a_of_type_Boolean))
      {
        localObject1 = (String)localObject1 + "HWAVCENC=1;";
        localObject1 = (String)localObject1 + "HWAVCENC_MAXW=" + ((lnt)localObject2).b + ";";
        localObject1 = (String)localObject1 + "HWAVCENC_MAXH=" + ((lnt)localObject2).c + ";";
      }
      else if ((((lnt)localObject2).jdField_a_of_type_Int == 4) && (((lnt)localObject2).jdField_a_of_type_Boolean))
      {
        localObject1 = (String)localObject1 + "HWHEVCDEC=1;";
        localObject1 = (String)localObject1 + "HWHEVCDEC_MAXW=" + ((lnt)localObject2).b + ";";
        localObject1 = (String)localObject1 + "HWHEVCDEC_MAXH=" + ((lnt)localObject2).c + ";";
      }
      else if ((((lnt)localObject2).jdField_a_of_type_Int == 8) && (((lnt)localObject2).jdField_a_of_type_Boolean))
      {
        localObject1 = (String)localObject1 + "HWHEVCENC=1;";
        localObject1 = (String)localObject1 + "HWHEVCENC_MAXW=" + ((lnt)localObject2).b + ";";
        localObject1 = (String)localObject1 + "HWHEVCENC_MAXH=" + ((lnt)localObject2).c + ";";
        continue;
        localObject1 = (String)localObject1 + "HWAVCENC=0;";
        localObject1 = (String)localObject1 + "HWAVCDEC=0;";
        localObject1 = (String)localObject1 + "HWHEVCENC=0;";
        localObject2 = (String)localObject1 + "HWHEVCDEC=0;";
        label1009:
        localObject1 = paramContext.getApplicationInfo();
        localObject2 = (String)localObject2 + "DATADIR=" + ((ApplicationInfo)localObject1).dataDir + ";";
        if (Build.VERSION.SDK_INT >= 9)
        {
          localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).nativeLibraryDir + ";";
          AVSoUtils.c();
          localObject1 = (String)localObject1 + "HEVC_ENC_SO_DIR=" + AVSoUtils.c() + ";";
          localObject1 = (String)localObject1 + "HEVC_DEC_SO_DIR=" + AVSoUtils.d() + ";";
          if (lkw.f() <= 2) {
            break label1345;
          }
        }
        label1345:
        for (localObject1 = (String)localObject1 + "SHARP_VIDEO=1;";; localObject1 = (String)localObject1 + "SHARP_VIDEO=2;")
        {
          paramContext = paramContext.getResources().getDisplayMetrics();
          int i = Math.max(paramContext.widthPixels, paramContext.heightPixels);
          int j = Math.min(paramContext.widthPixels, paramContext.heightPixels);
          paramContext = (String)localObject1 + "SCREEN_WIDTH=" + i + ";";
          paramContext = paramContext + "SCREEN_HEIGHT=" + j + ";";
          QLog.i("SDKConfigInfo", 1, "getDeviceInfo, info[" + paramContext + "]");
          return paramContext;
          localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).dataDir + "/lib;";
          break;
        }
      }
    }
  }
  
  public String toString()
  {
    return "SDKConfigInfo{logDir=" + this.logDir + ", logFilePrefix=" + this.logFilePrefix + ", processName=" + this.processName + ", isDebugVersion=" + this.isDebugVersion + ", isGrayVersion=" + this.isGrayVersion + ", isPublicVersion=" + this.isPublicVersion + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.core.SDKConfigInfo
 * JD-Core Version:    0.7.0.1
 */