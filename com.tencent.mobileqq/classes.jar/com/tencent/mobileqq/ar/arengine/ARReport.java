package com.tencent.mobileqq.ar.arengine;

import aacu;
import aacv;
import aacw;
import aacx;
import aacy;
import aacz;
import aada;
import aadb;
import aadc;
import aadd;
import aade;
import aadf;
import aadg;
import aadh;
import aadi;
import aadj;
import aadk;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;

public class ARReport
{
  private static ARReport jdField_a_of_type_ComTencentMobileqqArArengineARReport;
  private static final FileFilter jdField_a_of_type_JavaIoFileFilter = new aadc();
  
  public static int a()
  {
    if (Build.VERSION.SDK_INT <= 10) {
      return 1;
    }
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(jdField_a_of_type_JavaIoFileFilter).length;
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      return -1;
    }
    catch (SecurityException localSecurityException) {}
    return -1;
  }
  
  public static ARReport a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArArengineARReport == null) {
      jdField_a_of_type_ComTencentMobileqqArArengineARReport = new ARReport();
    }
    return jdField_a_of_type_ComTencentMobileqqArArengineARReport;
  }
  
  public static String a(Context paramContext)
  {
    return 2 + "";
  }
  
  private boolean a(long paramLong)
  {
    return (paramLong >= 0L) && (paramLong <= 600000L);
  }
  
  public String a()
  {
    return "un";
  }
  
  public void a(long paramLong)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  WebView mTotal:  %s ", new Object[] { Long.valueOf(paramLong) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aadg(this, paramLong), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   openCamera mTotal:  %s  result:  %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aada(this, paramInt, paramLong), 5, null, false);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report ARTotal  mDataReportFirstRenderModelTimeLen=:  %s mDataReportFirstCloudRecogAndRenderModelTimeLen=:  %s buildmodel=:  %s ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Build.MODEL }));
    ThreadManager.post(new aacu(this, paramLong2, paramLong1), 5, null, false);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString, int paramInt2, long paramLong4, long paramLong5, long paramLong6, int paramInt3)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  selectImg   mSelectTime=:  %s  mUploadTime=:  %s mImgSize=:  %s  mUploadTimes=:  %s  mImageId=:  %s mCloudTime=:  %s mCloudAllSize=:  %s mCloudAllTime=:  %s mtotaltime=:  %s  mResult=:  %s ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Integer.valueOf(paramInt1), paramString, Integer.valueOf(paramInt2), Long.valueOf(paramLong4), Long.valueOf(paramLong5), Long.valueOf(paramLong6), Integer.valueOf(paramInt3) }));
    if (paramInt1 < 1) {
      return;
    }
    ThreadManager.post(new aade(this, paramLong1, paramLong2, paramLong3, paramInt1, paramString, paramInt2, paramLong4, paramLong5, paramLong6, paramInt3), 5, null, false);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report Local mDataReportLoadedFeatureTimeLen=:  %s  mDataReportLoadedFeatureCnt=:  %s mDataReportFirstRecogSuccessTimeLen=:  %s  mDataReportFirstRecogSuccessFrameCnt=:  %s  mDataReportRecogQuality=:  %s mDataReportFirstRecogSuccessFeatureId=:  %s  ", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Long.valueOf(paramLong5), paramString }));
    ThreadManager.post(new aadf(this, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramString), 5, null, false);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  ARLocalControlint mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aadi(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int paramInt2, long paramLong5, int paramInt3, long paramLong6, long paramLong7, int paramInt4)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  CloudDownload   mImageId=:  %s mFeatureSize=:  %s mFeatureTime=:  %s mFeatureCode=:  %s  mModedSize=:  %s  mModelTime=:  %s mModelCode=:  %s mUnzipeTime=:  %s mType=:  %s totalTime=:  %s  mNetSize=:  %s mResult=:  %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Long.valueOf(paramLong3), Long.valueOf(paramLong4), Integer.valueOf(paramInt2), Long.valueOf(paramLong5), Integer.valueOf(paramInt3), Long.valueOf(paramLong6), Long.valueOf(paramLong7), Integer.valueOf(paramInt4) }));
    ThreadManager.post(new aadd(this, paramString, paramLong1, paramLong2, paramInt1, paramLong3, paramLong4, paramInt2, paramLong5, paramInt3, paramLong6, paramLong7, paramInt4), 5, null, false);
  }
  
  public void b(long paramLong)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  ARMarkerResourceManagerint mTotal:  %s ", new Object[] { Long.valueOf(paramLong) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aadh(this, paramLong), 5, null, false);
  }
  
  public void b(long paramLong, int paramInt)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   AREngineinitAR mTotal:  %s  result:  %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aadb(this, paramLong, paramInt), 5, null, false);
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  ARCloudControlSo mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aadj(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void c(long paramLong)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   SensorTrackManagerInit mTotal:  %s ", new Object[] { Long.valueOf(paramLong) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aacz(this, paramLong), 5, null, false);
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report  ARCloudControlinit mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aadk(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void d(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   ARLocalMarkerRecoglinit mTotal:  %s result:   %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aacv(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void e(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   ARLocalMarkerRecoglSo mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aacw(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void f(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   ARNativeBridgeSo mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aacx(this, paramLong, paramBoolean), 5, null, false);
  }
  
  public void g(long paramLong, boolean paramBoolean)
  {
    QLog.d("AREngine_ARReport", 2, String.format("report   ARLocalFaceRecogInit mTotal:  %s result:  %s", new Object[] { Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) }));
    if (!a(paramLong)) {
      return;
    }
    ThreadManager.post(new aacy(this, paramLong, paramBoolean), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport
 * JD-Core Version:    0.7.0.1
 */