import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import java.util.HashMap;

public class babd
{
  public static int a;
  public static boolean a;
  public static int b;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
  }
  
  public static int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 16 != 0)
    {
      if (paramInt % 16 < 8) {
        i = paramInt - paramInt % 16;
      }
    }
    else {
      return i;
    }
    return paramInt + (16 - paramInt % 16);
  }
  
  public static DisplayMetrics a(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (jdField_b_of_type_Boolean == paramBoolean1)) {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureUtil", 2, "no need to update ,update recognition result : " + paramBoolean1 + " force : " + paramBoolean2);
      }
    }
    do
    {
      return;
      jdField_b_of_type_Boolean = paramBoolean1;
      bfyz.a(BaseApplicationImpl.getApplication().getSharedPreferences("CaptureUtil", 4).edit().putBoolean("capture_shared_gesture_recognize_result", paramBoolean1));
    } while (!QLog.isColorLevel());
    QLog.d("CaptureUtil", 2, "update sp ,update recognition result : " + paramBoolean1 + " force : " + paramBoolean2);
  }
  
  public static boolean a()
  {
    int i = 1;
    boolean bool;
    if (Build.VERSION.SDK_INT < 21) {
      bool = false;
    }
    for (;;)
    {
      if (!bbwy.a())
      {
        i = 2;
        bool = false;
      }
      if ((Build.MODEL.equals("GT-I9500")) && (Build.VERSION.SDK_INT == 18))
      {
        i = 6;
        bool = false;
      }
      for (;;)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", Integer.toString(i));
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "actMediaCodecSupport", bool, 0L, 0L, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.i("CaptureUtil", 2, "mediacodec isMediaCodecSupport:" + bool + ", code:" + i);
        }
        return bool;
      }
      bool = true;
      i = 0;
    }
  }
  
  public static boolean a(boolean paramBoolean)
  {
    boolean bool5 = true;
    boolean bool4 = true;
    for (;;)
    {
      boolean bool6;
      boolean bool2;
      boolean bool1;
      boolean bool3;
      try
      {
        if (!jdField_a_of_type_Boolean)
        {
          bool6 = GraphicRenderMgr.loadSo();
          int j = AEResUtil.getAEResStatus(AEResInfo.AE_RES_BASE_PACKAGE);
          bmbx.d("CaptureUtil", "PtvFilterSoLoad.getFilterSoState result = " + j);
          bmbx.d("CaptureUtil", "[loadEffectSo] base so load start ");
          if (j != 1) {
            continue;
          }
          bool2 = AEResUtil.loadAEBaseSo();
          bool1 = bool2;
          if (paramBoolean) {
            bool1 = bool2 & AIManager.installDetector(PTHumanSegmenter.class, FeatureManager.getSoDir(), FeatureManager.getResourceDir());
          }
          bool3 = AEResUtil.isFilterFaceSoVersionOK();
          if ((!bool1) || (!bool3)) {
            continue;
          }
          i = 1;
          jdField_a_of_type_Int = i;
          bool2 = bool1;
          bool1 = bool3;
          if (!bbxj.e()) {
            break label346;
          }
          if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT)) {
            break label381;
          }
          break label346;
          if (!AEResUtil.isAEResExist(AEResInfo.AE_RES_ADDITIONAL_PACKAGE)) {
            break label352;
          }
          boav.jdField_a_of_type_Boolean = true;
          break label352;
          label150:
          jdField_a_of_type_Boolean = paramBoolean;
          bmbx.d("CaptureUtil", "[loadEffectSo] base so load end ");
          if (QLog.isColorLevel()) {
            QLog.d("CaptureUtil", 2, new Object[] { "loadEffectSo, ", Boolean.valueOf(jdField_a_of_type_Boolean), "  avSo:", Boolean.valueOf(bool6), "  ptuSo:", Boolean.valueOf(bool2), "  ptuSoVersion:", Boolean.valueOf(bool1), "  portraitSo:", Boolean.valueOf(bool3), " result:", Integer.valueOf(j), "  PTV_FILTER_SO_LOADED:", Integer.valueOf(jdField_a_of_type_Int), "  PTU_RES_DOWNLOADED:", Boolean.valueOf(boav.jdField_a_of_type_Boolean) });
          }
        }
        paramBoolean = jdField_a_of_type_Boolean;
        return paramBoolean;
        int i = 0;
        continue;
        jdField_a_of_type_Int = 2;
        bool1 = false;
        bool2 = false;
        continue;
        label326:
        jdField_a_of_type_Boolean = paramBoolean;
        continue;
        paramBoolean = false;
      }
      finally {}
      label346:
      label352:
      label381:
      do
      {
        break label326;
        bool3 = true;
        break;
        if (paramBoolean)
        {
          if ((bool6) && (bool2) && (bool1) && (bool3))
          {
            paramBoolean = bool4;
            break label150;
            bool3 = false;
            break;
          }
          paramBoolean = false;
          break label150;
        }
      } while ((!bool6) || (!bool2) || (!bool1));
      paramBoolean = bool5;
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramInt1) {
      return new int[] { a((int)(paramInt2 * (1.0F * paramInt1 / paramInt3))), paramInt1 };
    }
    return new int[] { paramInt2, paramInt3 };
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    int j = a((int)(paramInt1 * paramFloat));
    int i = a((int)(paramInt2 * paramFloat));
    float f1 = paramInt2 * 1.0F / paramInt1;
    float f2 = paramInt4 * 1.0F / paramInt3;
    if (f1 > f2) {
      i = a((int)(j * f2));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureUtil", 2, "clipVideoSize(" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + "," + paramFloat + ") = (" + j + "," + i + ")");
      }
      return new int[] { j, i };
      j = a((int)(i / f2));
    }
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 90: 
    default: 
      return 0;
    case 0: 
      return 270;
    case 180: 
      return 90;
    }
    return 180;
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = a(true);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int c(int paramInt)
  {
    return (paramInt + 45) / 90 * 90;
  }
  
  public static boolean c()
  {
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if (QLog.isColorLevel()) {
      QLog.d("CaptureUtil", 2, "isX86Platform: Build.CPU_ABI=" + str1 + " Build.CPU_ABI2=" + str2);
    }
    if ((str1 != null) && (!"".equals(str1)) && ("x86".equalsIgnoreCase(str1))) {}
    do
    {
      return true;
      if (lld.f() != 7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CaptureUtil", 2, "isX86Platform: VcSystemInfo.getCpuArchitecture()=x86");
    return true;
    return false;
  }
  
  public static boolean d()
  {
    return !c();
  }
  
  public static boolean e()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("CaptureUtil", 4).getBoolean("capture_shared_gesture_recognize_result", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babd
 * JD-Core Version:    0.7.0.1
 */