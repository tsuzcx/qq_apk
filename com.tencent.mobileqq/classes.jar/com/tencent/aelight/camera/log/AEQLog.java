package com.tencent.aelight.camera.log;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class AEQLog
{
  public static void a(@NonNull String paramString1, @NonNull String paramString2) {}
  
  public static void a(@NonNull String paramString1, @NonNull String paramString2, @Nullable Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_AECAMERA :");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2, paramThrowable);
  }
  
  public static void a(@NonNull String paramString, @Nullable Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_AECAMERA :");
    localStringBuilder.append(paramString);
    QLog.e(localStringBuilder.toString(), 1, paramThrowable, new Object[0]);
  }
  
  public static void b(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_AECAMERA :");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 1, paramString2);
  }
  
  public static void c(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_AECAMERA :");
    localStringBuilder.append(paramString1);
    QLog.w(localStringBuilder.toString(), 1, paramString2);
  }
  
  public static void d(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_AECAMERA :");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2);
  }
  
  public static void e(@NonNull String paramString1, @NonNull String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MODULE_GY_AECAMERA :");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2);
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportLog(paramString1, new QCircleAlphaUserReportDataBuilder().setAttachInfo(paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.log.AEQLog
 * JD-Core Version:    0.7.0.1
 */