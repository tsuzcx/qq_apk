package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.GapDataCollector;
import com.tencent.mobileqq.camera.adapter.DeviceInstance;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NewFlowCameraReporter
{
  public static long a;
  public static String a;
  public static Map<String, GapDataCollector> a;
  
  static
  {
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public static long a(Intent paramIntent)
  {
    return paramIntent.getLongExtra("start_intent_time", 0L);
  }
  
  public static void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X80072C1", "0X80072C1", 0, 0, "", "", "", "");
  }
  
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", paramInt + "");
    if (QLog.isColorLevel()) {
      QLog.d("NewFlowCameraReporter", 2, "reportQQFilterDownload :  " + localHashMap.toString());
    }
    a(localHashMap, "DynamicAdjustment", "acQQFilterDownload");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "acQQFilterDownload", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt1));
    localHashMap.put("previewWidth", "" + paramInt4);
    localHashMap.put("previewHeight", "" + paramInt5);
    localHashMap.put("wantedWidth", "" + paramInt2);
    localHashMap.put("wantedHeight", "" + paramInt3);
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actSetPreviewSizeWay", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.e("NewFlowCameraReporter", 2, "[reportPreviewSizeWay] STEP=" + paramInt1);
    }
  }
  
  public static void a(int paramInt, long paramLong, String paramString, boolean paramBoolean)
  {
    if ((paramLong < 0L) || (paramInt < 0))
    {
      QLog.d("DynamicAdjustment", 2, "report data check failed, stratTime: " + paramLong + "   cameraType : " + paramInt);
      return;
    }
    if (paramInt == 2) {}
    for (String str = "back";; str = "front")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("camera_type", str);
      localHashMap.put("start_time_cost", paramLong + "");
      localHashMap.put("activity_from", paramString);
      localHashMap.put("first_launch", paramBoolean + "");
      a(localHashMap, "DynamicAdjustment", "cameraStartTimeCost");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "cameraStartTimeCost", true, 0L, 0L, localHashMap, null);
      return;
    }
  }
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("start_intent_time", jdField_a_of_type_Long);
  }
  
  public static void a(Camera.Parameters paramParameters, String paramString)
  {
    int j = 1;
    if (paramParameters == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("open_custom_camera", 2, paramString + "   model compatibility");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("camera_type", paramString);
    paramString = "";
    String str = paramString;
    int i;
    if (paramParameters != null)
    {
      localObject = paramParameters.getSupportedFlashModes();
      str = paramString;
      if (localObject != null)
      {
        str = paramString;
        if (((List)localObject).size() > 0)
        {
          paramString = (String)((List)localObject).get(0);
          i = 1;
          for (;;)
          {
            str = paramString;
            if (i >= ((List)localObject).size()) {
              break;
            }
            paramString = paramString + "#";
            paramString = paramString + (String)((List)localObject).get(i);
            i += 1;
          }
        }
      }
    }
    Object localObject = "";
    paramString = (String)localObject;
    if (paramParameters != null)
    {
      List localList = paramParameters.getSupportedFocusModes();
      paramString = (String)localObject;
      if (localList != null)
      {
        paramString = (String)localObject;
        if (localList.size() > 0)
        {
          paramParameters = (String)localList.get(0);
          i = j;
          for (;;)
          {
            paramString = paramParameters;
            if (i >= localList.size()) {
              break;
            }
            paramParameters = paramParameters + "#";
            paramParameters = paramParameters + (String)localList.get(i);
            i += 1;
          }
        }
      }
    }
    localHashMap.put("supported_focus_mode", paramString);
    localHashMap.put("supported_flash_mode", str);
    a(null, "sv_model_compatibility", localHashMap);
  }
  
  public static void a(String paramString)
  {
    a(paramString, jdField_a_of_type_Long);
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d("PTV.NewFlowCameraActivity.photo", 2, paramString + ";" + (l - paramLong));
      jdField_a_of_type_Long = l;
    }
  }
  
  private static void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (QLog.isColorLevel())) {
      QLog.d("open_custom_camera", 2, paramString1);
    }
    if (paramHashMap == null) {}
    for (paramString1 = new HashMap();; paramString1 = paramHashMap)
    {
      paramString1.put("MANUFACTURER", Build.MANUFACTURER);
      paramString1.put("MODEL", Build.MODEL);
      paramString1.put("DEVICE_TYPE_NAME", DeviceInstance.a().a());
      a(paramString1, "open_custom_camera", paramString2);
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, paramString2, true, 0L, 0L, paramString1, null);
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (FlowCameraConstant.a == 2) {}
    for (String str = "0"; (!StringUtil.a(paramString1)) || (!CameraUtils.a()); str = "1")
    {
      ReportController.b(null, "dc00898", "", "", "0X80072C3", "0X80072C3", 0, 0, str, paramString1, "", "");
      if (paramBoolean) {
        ReportController.b(null, "dc00898", "", "", "0X80083B0", "0X80083B0", 0, 0, str, paramString1, "", "");
      }
      if (!StringUtil.a(paramString2)) {
        ReportController.b(null, "dc00898", "", "", "0X80083B6", "0X80083B6", 0, 0, paramString1, "", paramString2, "");
      }
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X80072C2", "0X80072C2", 0, 0, str, "", "", "");
  }
  
  public static void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() != 1)) {}
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramList = (String)paramList.get(0);
            } while (paramList == null);
            if (paramList.contains("DCIM/Camera")) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("open_custom_camera", 2, "not a album path : " + paramList);
          return;
          paramList = new File(paramList);
        } while (!paramList.exists());
        f();
        l = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getLong("sv_latest_taken_photo_time", -1L);
      } while (l == -1L);
      l = (paramList.lastModified() - l) / 1000L;
      if ((l > 0L) && (l < 60L)) {
        g();
      }
    } while (!QLog.isColorLevel());
    QLog.d("open_custom_camera", 2, "album time diff : " + l);
  }
  
  private static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    for (paramMap = "事件Code : " + paramString2 + "   上报内容 ----------  \n"; localIterator.hasNext(); paramMap = paramMap + "\n")
    {
      paramString2 = (Map.Entry)localIterator.next();
      paramMap = paramMap + (String)paramString2.getKey();
      paramMap = paramMap + "   :   ";
      paramMap = paramMap + (String)paramString2.getValue();
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramMap);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("on_auto_focus_result", paramBoolean + "");
    a(null, "sv_on_auto_focus", localHashMap);
  }
  
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramBoolean));
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("cameraFrontBack", "" + paramInt1);
    localHashMap.put("templateId", "" + paramInt2);
    localHashMap.put("photoCaptureMethod", "" + paramInt3);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "photo_shot_from_shortvideo", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.e("NewFlowCameraReporter", 2, "[ShortVideoMergeReport] tag=photo_shot_from_shortvideo templateId=" + paramInt2 + " camera=" + paramInt1);
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("previewWidth", "" + paramInt1);
    localHashMap.put("previewHeight", "" + paramInt2);
    localHashMap.put("photoWidth", "" + paramInt3);
    localHashMap.put("photoHeight", "" + paramInt4);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSetPhotoClipSize", paramBoolean, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.e("NewFlowCameraReporter", 2, "[reportSetShootSizeClip] result=" + paramBoolean);
    }
  }
  
  public static void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, int paramInt5, boolean paramBoolean3)
  {
    HashMap localHashMap = new HashMap();
    int j = 0;
    int i = j;
    StatisticCollector localStatisticCollector;
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        i = 10;
      }
    }
    else
    {
      localHashMap.put("param_FailCode", String.valueOf(i));
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localHashMap.put("previewWidth", "" + paramInt1);
      localHashMap.put("previewHeight", "" + paramInt2);
      localHashMap.put("photoWidth", "" + paramInt3);
      localHashMap.put("photoHeight", "" + paramInt4);
      localHashMap.put("rotation", "" + paramInt5);
      localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
      if (paramBoolean1) {
        break label319;
      }
    }
    label319:
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(null, "actShootPhotoClip", bool, 0L, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.e("NewFlowCameraReporter", 2, "[reportShootPhotoClip] result=" + paramBoolean1 + "ratioNeedClip " + paramBoolean2 + " rotation" + paramInt5 + " needFlip" + paramBoolean3);
      }
      return;
      if (paramInt5 != 0)
      {
        i = 20;
        break;
      }
      i = j;
      if (!paramBoolean3) {
        break;
      }
      i = 30;
      break;
    }
  }
  
  public static void b()
  {
    a("call request focus", "sv_call_request_focus", null);
  }
  
  public static void c()
  {
    a("custom photo send", "sv_custom_photo_send", null);
  }
  
  public static void d()
  {
    a("capture photo send", "sv_capture_photo_send", null);
  }
  
  public static void e()
  {
    a("system photo send", "sv_system_photo_send", null);
  }
  
  public static void f()
  {
    a("photo send from album", "sv_photo_send_from_album", null);
  }
  
  public static void g()
  {
    a("album photo send in minute", "photo_send_from_album_in_minute", null);
  }
  
  public static void h()
  {
    a("photo taken by custom", "sv_photo_taken_by_custom", null);
  }
  
  public static void i()
  {
    a("photo taken by capture", "sv_photo_taken_by_capture", null);
  }
  
  public static void j()
  {
    a("enter short video", "sv_enter_shortvideo", null);
  }
  
  public static void k()
  {
    a("enter system camera", "sv_enter_system_camera", null);
  }
  
  public static void l()
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((GapDataCollector)((Map.Entry)localIterator.next()).getValue()).a();
    }
    jdField_a_of_type_JavaLangString = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter
 * JD-Core Version:    0.7.0.1
 */