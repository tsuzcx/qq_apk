package com.tencent.av.wtogether;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.av.wtogether.data.WTogetherPlayInfo;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.av.wtogether.util.WatchTogetherDataReportHelper;
import com.tencent.av.wtogether.util.WatchTogetherDataReportHelper.WTFilePlayInfo;
import com.tencent.qphone.base.util.QLog;

public class WTDataReportUtil
{
  private static int jdField_a_of_type_Int = 0;
  private static long jdField_a_of_type_Long = 0L;
  private static String jdField_a_of_type_JavaLangString = null;
  private static long b = 0L;
  
  public static String a()
  {
    Object localObject = (WTogetherMng)VideoController.a().a().a(15);
    if (localObject != null)
    {
      localObject = ((WTogetherMng)localObject).b(VideoController.a().a());
      if ((localObject != null) && (((WatchTogetherInfo)localObject).a != null)) {
        return ((WatchTogetherInfo)localObject).a.c();
      }
    }
    return "";
  }
  
  public static String a(WTogetherPlayInfo paramWTogetherPlayInfo)
  {
    if ((paramWTogetherPlayInfo == null) || (paramWTogetherPlayInfo.a == null)) {
      return null;
    }
    return paramWTogetherPlayInfo.a.c();
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    b = 0L;
    if (QLog.isColorLevel()) {
      QLog.i("WTDataReportUtil", 2, "onEnterWTRoom, start[" + jdField_a_of_type_Long + "]");
    }
  }
  
  public static void a(WTogetherPlayInfo paramWTogetherPlayInfo, long paramLong)
  {
    if ((paramWTogetherPlayInfo == null) || (paramWTogetherPlayInfo.a == null)) {}
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
        a(paramWTogetherPlayInfo, "onPlayStart");
      }
      jdField_a_of_type_Int += 1;
      jdField_a_of_type_JavaLangString = a(paramWTogetherPlayInfo);
      int i = paramWTogetherPlayInfo.a.a();
      String str1 = String.valueOf(paramLong / 1000L);
      String str2 = a();
      String str3 = paramWTogetherPlayInfo.a.a();
      String str4 = paramWTogetherPlayInfo.a.b();
      AVUtil.a("0X800B62E", i, 0, str1, str2, str3, str4);
      if (paramWTogetherPlayInfo.a.jdField_a_of_type_Int == 4) {
        AVUtil.a("0X800B8DF", 1, 0, paramWTogetherPlayInfo.a.h, "", paramWTogetherPlayInfo.a.j, paramWTogetherPlayInfo.a.f);
      }
      while (QLog.isColorLevel())
      {
        QLog.i("WTDataReportUtil", 2, "onPlayStart, key[" + jdField_a_of_type_JavaLangString + "], from[" + i + "], r2[" + str1 + "], r3[" + str2 + "], r4[" + str3 + "], r5[" + str4 + "]");
        return;
        if (paramWTogetherPlayInfo.a.jdField_a_of_type_Int == 3) {
          AVUtil.a("0X800B8DF", 1, 0, paramWTogetherPlayInfo.a.h, "", paramWTogetherPlayInfo.a.g, paramWTogetherPlayInfo.a.f);
        }
      }
    }
  }
  
  public static void a(WTogetherPlayInfo paramWTogetherPlayInfo, String paramString)
  {
    String str1 = a(paramWTogetherPlayInfo);
    if ((str1 == null) || (!TextUtils.equals(str1, jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTDataReportUtil", 2, "onPlayEnd, from[" + paramString + "], report before.");
      }
      return;
    }
    Object localObject1 = VideoController.a().a();
    label75:
    Object localObject2;
    label83:
    long l1;
    long l2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label307;
      }
      localObject2 = null;
      if (localObject2 == null) {
        break label368;
      }
      l1 = ((WatchTogetherDataReportHelper.WTFilePlayInfo)localObject2).jdField_a_of_type_Int;
      l2 = ((WatchTogetherDataReportHelper.WTFilePlayInfo)localObject2).b;
    }
    for (;;)
    {
      localObject2 = String.valueOf(l1 / 1000L);
      String str2 = String.valueOf(l2 / 1000L);
      int i;
      if (paramWTogetherPlayInfo.a != null)
      {
        i = paramWTogetherPlayInfo.a.a();
        if (paramWTogetherPlayInfo.a.jdField_a_of_type_Int == 4) {
          AVUtil.a("0X800B8E0", 1, 0, paramWTogetherPlayInfo.a.h, str2, paramWTogetherPlayInfo.a.j, paramWTogetherPlayInfo.a.f);
        }
      }
      for (;;)
      {
        AVUtil.a("0X800B639", i, 0, (String)localObject2, str2, a(), "");
        b += l2;
        jdField_a_of_type_JavaLangString = null;
        if (localObject1 != null) {
          ((WatchTogetherDataReportHelper)localObject1).a(str1);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("WTDataReportUtil", 2, "onPlayEnd, from[" + paramString + "], key[" + str1 + "], fromType[" + i + "], r2[" + (String)localObject2 + "], r3[" + str2 + "]");
        return;
        localObject1 = ((WatchTogetherMediaPlayCtrl)localObject1).a();
        break label75;
        label307:
        localObject2 = ((WatchTogetherDataReportHelper)localObject1).a(str1);
        break label83;
        if (paramWTogetherPlayInfo.a.jdField_a_of_type_Int == 3) {
          AVUtil.a("0X800B8E0", 1, 0, paramWTogetherPlayInfo.a.h, str2, paramWTogetherPlayInfo.a.g, paramWTogetherPlayInfo.a.f);
        }
        continue;
        i = 0;
      }
      label368:
      l2 = 0L;
      l1 = 0L;
    }
  }
  
  public static void b()
  {
    if (jdField_a_of_type_Long != 0L) {}
    for (long l = Math.abs(SystemClock.elapsedRealtime() - jdField_a_of_type_Long);; l = 0L)
    {
      int i = jdField_a_of_type_Int;
      String str1 = String.valueOf(l / 1000L);
      String str2 = String.valueOf(b / 1000L);
      AVUtil.a("0X800B6C0", 0, 0, str1, str2, i + "", "");
      if (QLog.isColorLevel()) {
        QLog.i("WTDataReportUtil", 2, "onExitWTRoom, r2[" + str1 + "], r3[" + str2 + "], count[" + i + "]");
      }
      b = 0L;
      jdField_a_of_type_Long = 0L;
      jdField_a_of_type_Int = 0;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.WTDataReportUtil
 * JD-Core Version:    0.7.0.1
 */