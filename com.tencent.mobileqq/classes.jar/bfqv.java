import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneVideoDownloadActivity;
import cooperation.qzone.util.CpuUtils;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QzoneHardwareRestriction;
import mqq.app.MobileQQ;

public class bfqv
{
  private static int jdField_a_of_type_Int = -1;
  private static long jdField_a_of_type_Long = -1L;
  
  public static long a()
  {
    return QzoneHardwareRestriction.getCpuMaxFreq() / 1024L;
  }
  
  public static bfqw a()
  {
    int j = -1;
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "SupportMiniVideo", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() severBlackList");
      }
      return bfqw.c;
    }
    int i = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((i > 0) && ("GN9000L|ASUS_T00F|H30-T00".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() localBlackList");
      }
      return bfqw.c;
    }
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "IgnoreLocalJudge", -1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() severWhiteList");
      }
      i = QzoneConfig.getInstance().getConfig("MiniVideo", "MinSdkVersion", 21);
      j = Build.VERSION.SDK_INT;
      if (j < i)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() localSdkVersion=" + j + " serverSdkVersion=" + i);
        }
        return bfqw.e;
      }
    }
    else
    {
      if (jdField_a_of_type_Int < 0) {
        a();
      }
      if (jdField_a_of_type_Long < 0L) {
        jdField_a_of_type_Long = CpuUtils.a();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() mCpuFamily=" + jdField_a_of_type_Int + " mCpuFeature=" + jdField_a_of_type_Long);
      }
      int k = QzoneConfig.getInstance().getConfig("MiniVideo", "SupportedCpuFamily", 2);
      if (jdField_a_of_type_Int >= 0) {}
      for (i = 1 << jdField_a_of_type_Int; (i & k) == 0; i = 1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() serverCpuFamily=" + k + " mCpuFamily=" + jdField_a_of_type_Int);
        }
        return bfqw.b;
      }
      Object localObject = QzoneConfig.getInstance().getConfig("MiniVideo", "RequiredCpuFeatures", "#101##").split("#", -1);
      if (jdField_a_of_type_Int >= localObject.length) {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() mCpuFamily=" + jdField_a_of_type_Int + " serverCpuFeatureList.length=" + localObject.length);
        }
      }
      label428:
      label600:
      for (;;)
      {
        if (!QzoneHardwareRestriction.meetHardwareRestriction(0, 1))
        {
          return bfqw.d;
          localObject = localObject[jdField_a_of_type_Int];
          i = ((String)localObject).length() - 1;
        }
        for (;;)
        {
          if (i < 0) {
            break label600;
          }
          j += 1;
          if (j > 63)
          {
            if (!QLog.isColorLevel()) {
              break label428;
            }
            QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() longValueIndex>63  serverFeature=" + (String)localObject + " mCpuFeature=" + jdField_a_of_type_Long);
            break label428;
            break;
          }
          if ((((String)localObject).charAt(i) == '1') && ((jdField_a_of_type_Long & 1L << j) == 0L))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() cpuFeature unsatisfied. bitIndex=" + i + " serverFeature=" + (String)localObject + " mCpuFeature=" + jdField_a_of_type_Long);
            }
            return bfqw.b;
          }
          i -= 1;
        }
      }
    }
    if (!bftg.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() sdcard !mounted");
      }
      return bfqw.f;
    }
    long l = b();
    if (l < 62914560L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() sdCardFreeSpace=" + l + " STORAGE_LIMIT=" + 62914560L);
      }
      return bfqw.g;
    }
    if (!autt.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "CaptureUtil.supportCapture is false");
      }
      return bfqw.e;
    }
    return bfqw.a;
  }
  
  private static void a()
  {
    if (Build.CPU_ABI.contains("armeabi"))
    {
      jdField_a_of_type_Int = 1;
      return;
    }
    if (Build.CPU_ABI.contains("x86"))
    {
      jdField_a_of_type_Int = 2;
      return;
    }
    if (Build.CPU_ABI.contains("mips"))
    {
      jdField_a_of_type_Int = 3;
      return;
    }
    jdField_a_of_type_Int = 0;
  }
  
  public static void a(long paramLong, Activity paramActivity, String paramString, bfqx parambfqx)
  {
    PerfTracer.traceStart("Video_component_pre_launch");
    if (paramActivity == null)
    {
      QLog.w("QZoneVideoCommonUtils", 2, "forwardInstallAndStartUpVideoActivity activity is null");
      return;
    }
    bfqw localbfqw1 = a();
    bfqw localbfqw2 = b();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "support record=" + localbfqw1.a() + ", support trim=" + localbfqw2.a());
    }
    if ((!localbfqw1.a()) && (!localbfqw2.a()))
    {
      if (localbfqw1.b()) {}
      for (paramString = localbfqw1.a();; paramString = null)
      {
        String str;
        if (paramString != null)
        {
          str = paramString;
          if (paramString.length() != 0) {}
        }
        else
        {
          str = paramActivity.getString(2131652433);
        }
        if (parambfqx != null) {
          parambfqx.onFail(paramActivity, str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("QZoneVideoCommonUtils", 2, "qzone video is not supported, recordSupport tips=" + localbfqw1.a() + ",trimSupport tips=" + localbfqw2.a() + ",show tips=" + str);
        return;
      }
    }
    a(paramLong, paramActivity, localbfqw1.a(), localbfqw2.a(), paramString);
    PerfTracer.traceEnd("Video_component_pre_launch");
  }
  
  public static void a(long paramLong, Activity paramActivity, String paramString, bfqx parambfqx, Bundle paramBundle)
  {
    PerfTracer.traceStart("Video_component_pre_launch");
    if (paramActivity == null)
    {
      QLog.w("QZoneVideoCommonUtils", 2, "forwardInstallAndStartUpVideoActivity activity is null");
      return;
    }
    bfqw localbfqw1 = a();
    bfqw localbfqw2 = b();
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "support record=" + localbfqw1.a() + ", support trim=" + localbfqw2.a());
    }
    if ((!localbfqw1.a()) && (!localbfqw2.a()))
    {
      if (localbfqw1.b()) {}
      for (paramString = localbfqw1.a();; paramString = null)
      {
        if (paramString != null)
        {
          paramBundle = paramString;
          if (paramString.length() != 0) {}
        }
        else
        {
          paramBundle = paramActivity.getString(2131652433);
        }
        if (parambfqx != null) {
          parambfqx.onFail(paramActivity, paramBundle);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("QZoneVideoCommonUtils", 2, "qzone video is not supported, recordSupport tips=" + localbfqw1.a() + ",trimSupport tips=" + localbfqw2.a() + ",show tips=" + paramBundle);
        return;
      }
    }
    a(paramLong, paramActivity, false, false, paramString, paramBundle);
    PerfTracer.traceEnd("Video_component_pre_launch");
  }
  
  public static void a(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("support_record", paramBoolean1);
    localIntent.putExtra("support_trim", paramBoolean2);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    localIntent.putExtra("flow_camera_capture_mode", false);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("video_refer", paramString);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivityForEditVideo");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("video_refer", paramString);
    }
    localIntent.putExtras(paramBundle);
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2, boolean paramBoolean5, String paramString3, String paramString4, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent);
    }
    localIntent.putExtra("support_record", paramBoolean1);
    localIntent.putExtra("support_trim", paramBoolean2);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    localIntent.putExtra("is_qzone_vip", paramBoolean3);
    localIntent.putExtra("enable_edit_video", paramBoolean4);
    localIntent.putExtra("topicId", paramString2);
    localIntent.putExtra("enterPtu", paramBoolean5);
    if (!TextUtils.isEmpty(paramString3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVideoCommonUtils", 2, "callback:" + paramString3 + " id:" + paramString4);
      }
      localIntent.putExtra("callback", paramString3);
      localIntent.putExtra("dongxiao_id", paramString4);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("video_refer", paramString1);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("video_type", paramInt);
    localIntent.putExtra("file_send_path", paramString);
    localIntent.putExtra("preview_video", true);
    localIntent.putExtra("start_time", 0);
    localIntent.putExtra("end_time", paramLong);
    localIntent.putExtra("encode_video_params", paramBundle);
    localIntent.putExtra("video_refer", "QZonePublishMoodTabActivity");
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString2, String paramString3, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent);
    }
    localIntent.putExtra("support_record", a().a());
    localIntent.putExtra("support_trim", b().a());
    localIntent.putExtra("uin", "0");
    localIntent.putExtra("is_qzone_vip", paramBoolean1);
    localIntent.putExtra("enable_edit_video", true);
    localIntent.putExtra("enterPtu", true);
    localIntent.putExtra("enable_local_button", paramBoolean6);
    localIntent.putExtra("enable_edit_button", paramBoolean3);
    localIntent.putExtra("callback", "qzoneOpenDongXiao");
    localIntent.putExtra("dongxiao_id", paramString2);
    localIntent.putExtra("enable_priv_list", false);
    localIntent.putExtra("enable_input_text", paramBoolean2);
    if (paramBoolean2) {
      localIntent.putExtra("enable_sync_qzone", paramBoolean4);
    }
    localIntent.putExtra("enable_origin_video", paramBoolean5);
    localIntent.putExtra("confirm_text", paramString3);
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("video_refer", paramString1);
    }
    paramActivity.startActivity(localIntent);
  }
  
  private static long b()
  {
    try
    {
      long l = bftg.b();
      return l;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneVideoCommonUtils", 1, "Get Free Space Failed", localException);
    }
    return 0L;
  }
  
  public static bfqw b()
  {
    bfqw localbfqw = c();
    if (localbfqw.a()) {
      return localbfqw;
    }
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "SupportTrimVideo", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() severBlackList");
      }
      return bfqw.c;
    }
    int i = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((i > 0) && ("M032|ASUS_T00F".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() localBlackList");
      }
      return bfqw.c;
    }
    int j;
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "IgnoreLocalJudge", -1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() severWhiteList");
      }
      i = QzoneConfig.getInstance().getConfig("TrimVideo", "MinSdkVersion", 14);
      j = Build.VERSION.SDK_INT;
      if (j < i)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() localSdkVersion=" + j + " serverSdkVersion=" + i);
        }
        return bfqw.e;
      }
    }
    else
    {
      if (jdField_a_of_type_Int < 0) {
        a();
      }
      if (jdField_a_of_type_Long < 0L) {}
      for (;;)
      {
        try
        {
          jdField_a_of_type_Long = CpuUtils.a();
          if (QLog.isColorLevel()) {
            QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() mCpuFamily=" + jdField_a_of_type_Int + " mCpuFeature=" + jdField_a_of_type_Long);
          }
          j = QzoneConfig.getInstance().getConfig("TrimVideo", "SupportedCpuFamily", 2);
          if (jdField_a_of_type_Int >= 0)
          {
            i = jdField_a_of_type_Int;
            if ((1 << i & j) != 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() serverCpuFamily=" + j + " mCpuFamily=" + jdField_a_of_type_Int);
            }
            return bfqw.b;
          }
        }
        catch (Exception localException)
        {
          return bfqw.b;
        }
        i = 0;
      }
      Object localObject = QzoneConfig.getInstance().getConfig("TrimVideo", "RequiredCpuFeatures", "#101##").split("#", -1);
      if (jdField_a_of_type_Int >= localObject.length) {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() mCpuFamily=" + jdField_a_of_type_Int + " serverCpuFeatureList.length=" + localObject.length);
        }
      }
      label457:
      label633:
      for (;;)
      {
        if (!QzoneHardwareRestriction.meetHardwareRestriction(0, 1))
        {
          return bfqw.d;
          localObject = localObject[jdField_a_of_type_Int];
          i = ((String)localObject).length() - 1;
          j = -1;
        }
        for (;;)
        {
          if (i < 0) {
            break label633;
          }
          j += 1;
          if (j > 63)
          {
            if (!QLog.isColorLevel()) {
              break label457;
            }
            QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() longValueIndex>63  serverFeature=" + (String)localObject + " mCpuFeature=" + jdField_a_of_type_Long);
            break label457;
            break;
          }
          if ((((String)localObject).charAt(i) == '1') && ((jdField_a_of_type_Long & 1L << j) == 0L))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() cpuFeature unsatisfied. bitIndex=" + i + " serverFeature=" + (String)localObject + " mCpuFeature=" + jdField_a_of_type_Long);
            }
            return bfqw.b;
          }
          i -= 1;
        }
      }
    }
    if (!bftg.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() sdcard !mounted");
      }
      return bfqw.f;
    }
    long l = b();
    if (l < 62914560L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() sdCardFreeSpace=" + l + " STORAGE_LIMIT=" + 62914560L);
      }
      return bfqw.g;
    }
    return bfqw.a;
  }
  
  public static bfqw c()
  {
    int i = 1;
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "videoTrimEnableHw", 1) != 1) {
      return bfqw.c;
    }
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "SupportTrimVideoHW", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() severBlackList");
      }
      return bfqw.c;
    }
    int j = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((j > 0) && ("GT-N7100|".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() localBlackList");
      }
      return bfqw.c;
    }
    j = QzoneConfig.getInstance().getConfig("TrimVideo", "MinSdkVersionHw", 18);
    int k = Build.VERSION.SDK_INT;
    if (k < j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() localSdkVersion=" + k + " serverSdkVersion=" + j);
      }
      return bfqw.e;
    }
    j = awif.a(MobileQQ.getContext());
    if (((j & 0x1) > 0) && ((j & 0x2) > 0)) {}
    while (i == 0)
    {
      return bfqw.h;
      i = 0;
    }
    return bfqw.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfqv
 * JD-Core Version:    0.7.0.1
 */