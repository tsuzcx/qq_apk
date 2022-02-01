package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.GapDataCollector;
import com.tencent.mobileqq.camera.adapter.DeviceInstance;
import com.tencent.mobileqq.statistics.StatisticCollector;
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
  public static long a = 0L;
  public static String b = "";
  public static Map<String, GapDataCollector> c = new ConcurrentHashMap();
  
  public static void a()
  {
    a("photo send from album", "sv_photo_send_from_album", null);
  }
  
  public static void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localHashMap.put("status", localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("reportQQFilterDownload :  ");
      localStringBuilder.append(localHashMap.toString());
      QLog.d("NewFlowCameraReporter", 2, localStringBuilder.toString());
    }
    a(localHashMap, "DynamicAdjustment", "acQQFilterDownload");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "acQQFilterDownload", true, 0L, 0L, localHashMap, null);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
    ((HashMap)localObject).put("param_FailCode", String.valueOf(paramInt1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt4);
    ((HashMap)localObject).put("previewWidth", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt5);
    ((HashMap)localObject).put("previewHeight", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    ((HashMap)localObject).put("wantedWidth", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt3);
    ((HashMap)localObject).put("wantedHeight", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actSetPreviewSizeWay", false, 0L, 0L, (HashMap)localObject, "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[reportPreviewSizeWay] STEP=");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.e("NewFlowCameraReporter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(Intent paramIntent)
  {
    paramIntent.putExtra("start_intent_time", a);
  }
  
  public static void a(Camera.Parameters paramParameters, String paramString)
  {
    if (paramParameters == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("   model compatibility");
      QLog.d("open_custom_camera", 2, ((StringBuilder)localObject).toString());
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("camera_type", paramString);
    String str = "";
    int j = 1;
    List localList;
    int i;
    if (paramParameters != null)
    {
      localList = paramParameters.getSupportedFlashModes();
      if ((localList != null) && (localList.size() > 0))
      {
        paramString = (String)localList.get(0);
        i = 1;
        for (;;)
        {
          localObject = paramString;
          if (i >= localList.size()) {
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("#");
          paramString = ((StringBuilder)localObject).toString();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append((String)localList.get(i));
          paramString = ((StringBuilder)localObject).toString();
          i += 1;
        }
      }
    }
    Object localObject = "";
    paramString = str;
    if (paramParameters != null)
    {
      localList = paramParameters.getSupportedFocusModes();
      paramString = str;
      if (localList != null)
      {
        paramString = str;
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
            paramString = new StringBuilder();
            paramString.append(paramParameters);
            paramString.append("#");
            paramParameters = paramString.toString();
            paramString = new StringBuilder();
            paramString.append(paramParameters);
            paramString.append((String)localList.get(i));
            paramParameters = paramString.toString();
            i += 1;
          }
        }
      }
    }
    localHashMap.put("supported_focus_mode", paramString);
    localHashMap.put("supported_flash_mode", localObject);
    a(null, "sv_model_compatibility", localHashMap);
  }
  
  public static void a(String paramString)
  {
    a(paramString, a);
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(";");
      localStringBuilder.append(l - paramLong);
      QLog.d("PTV.NewFlowCameraActivity.photo", 2, localStringBuilder.toString());
      a = l;
    }
  }
  
  private static void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (QLog.isColorLevel())) {
      QLog.d("open_custom_camera", 2, paramString1);
    }
    paramString1 = paramHashMap;
    if (paramHashMap == null) {
      paramString1 = new HashMap();
    }
    paramString1.put("MANUFACTURER", Build.MANUFACTURER);
    paramString1.put("MODEL", Build.MODEL);
    paramString1.put("DEVICE_TYPE_NAME", DeviceInstance.a().b());
    a(paramString1, "open_custom_camera", paramString2);
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, paramString2, true, 0L, 0L, paramString1, null);
  }
  
  public static void a(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() != 1) {
        return;
      }
      paramList = (String)paramList.get(0);
      if (paramList == null) {
        return;
      }
      if (!paramList.contains("DCIM/Camera"))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("not a album path : ");
          localStringBuilder.append(paramList);
          QLog.d("open_custom_camera", 2, localStringBuilder.toString());
        }
        return;
      }
      paramList = new File(paramList);
      if (!paramList.exists()) {
        return;
      }
      a();
      long l = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getLong("sv_latest_taken_photo_time", -1L);
      if (l == -1L) {
        return;
      }
      l = (paramList.lastModified() - l) / 1000L;
      if ((l > 0L) && (l < 60L)) {
        b();
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("album time diff : ");
        paramList.append(l);
        QLog.d("open_custom_camera", 2, paramList.toString());
      }
    }
  }
  
  private static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = new StringBuilder();
    paramMap.append("事件Code : ");
    paramMap.append(paramString2);
    paramMap.append("   上报内容 ----------  \n");
    for (paramMap = paramMap.toString(); localIterator.hasNext(); paramMap = paramString2.toString())
    {
      paramString2 = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMap);
      localStringBuilder.append((String)paramString2.getKey());
      paramMap = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMap);
      localStringBuilder.append("   :   ");
      paramMap = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMap);
      localStringBuilder.append((String)paramString2.getValue());
      paramMap = localStringBuilder.toString();
      paramString2 = new StringBuilder();
      paramString2.append(paramMap);
      paramString2.append("\n");
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramMap);
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    ((HashMap)localObject).put("previewWidth", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    ((HashMap)localObject).put("previewHeight", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt3);
    ((HashMap)localObject).put("photoWidth", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt4);
    ((HashMap)localObject).put("photoHeight", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actSetPhotoClipSize", paramBoolean, 0L, 0L, (HashMap)localObject, "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[reportSetShootSizeClip] result=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.e("NewFlowCameraReporter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, int paramInt5, boolean paramBoolean3)
  {
    Object localObject = new HashMap();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        i = 10;
        break label52;
      }
      if (paramInt5 != 0)
      {
        i = 20;
        break label52;
      }
      if (paramBoolean3)
      {
        i = 30;
        break label52;
      }
    }
    int i = 0;
    label52:
    ((HashMap)localObject).put("param_FailCode", String.valueOf(i));
    ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    ((HashMap)localObject).put("previewWidth", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    ((HashMap)localObject).put("previewHeight", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt3);
    ((HashMap)localObject).put("photoWidth", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt4);
    ((HashMap)localObject).put("photoHeight", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt5);
    ((HashMap)localObject).put("rotation", localStringBuilder.toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actShootPhotoClip", paramBoolean1 ^ true, 0L, 0L, (HashMap)localObject, "");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[reportShootPhotoClip] result=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append("ratioNeedClip ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(" rotation");
      ((StringBuilder)localObject).append(paramInt5);
      ((StringBuilder)localObject).append(" needFlip");
      ((StringBuilder)localObject).append(paramBoolean3);
      QLog.e("NewFlowCameraReporter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void b()
  {
    a("album photo send in minute", "photo_send_from_album_in_minute", null);
  }
  
  public static void c()
  {
    a("enter system camera", "sv_enter_system_camera", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter
 * JD-Core Version:    0.7.0.1
 */