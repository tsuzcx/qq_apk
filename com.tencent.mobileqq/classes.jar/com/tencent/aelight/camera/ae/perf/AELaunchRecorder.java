package com.tencent.aelight.camera.ae.perf;

import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashMap;
import java.util.Map;

public final class AELaunchRecorder
{
  private long jdField_a_of_type_Long;
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = true;
  
  private long a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return ((Long)this.jdField_a_of_type_JavaUtilMap.get(paramString)).longValue();
    }
    return 0L;
  }
  
  private long a(String paramString1, String paramString2)
  {
    long l3 = a(paramString1);
    long l4 = a(paramString2);
    long l2 = 0L;
    long l1 = l2;
    if (l4 > 0L)
    {
      l1 = l2;
      if (l3 > l4) {
        l1 = l3 - l4;
      }
    }
    return l1;
  }
  
  public static AELaunchRecorder a()
  {
    return AELaunchRecorder.Holder.a();
  }
  
  private boolean a()
  {
    return true;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long > 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("old AIO launch total cost=");
      localStringBuilder.append(l - this.jdField_a_of_type_Long);
      AEQLog.b("CameraLaunchPerf", localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    if (a()) {
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
    AEQLog.b("CameraLaunchPerf", paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (a()) {
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(paramLong));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" real happened at ");
    localStringBuilder.append(paramLong);
    AEQLog.b("CameraLaunchPerf", localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("--");
      localStringBuilder.append(paramString2);
      AEQLog.b("CameraLaunchPerf******", localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a()) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("collect data:{");
    if (!paramBoolean)
    {
      localStringBuilder.append("userClick-startActivity=");
      localStringBuilder.append(a("startActivityForResult", "userClick"));
      localStringBuilder.append(", userClickDispatch=");
      localStringBuilder.append(a("AECameraLauncher---launchAECameraUnit-begin", "userClick"));
      localStringBuilder.append(", launchAECameraUnit=");
      localStringBuilder.append(a("AECameraLauncher---launchAECameraUnit-end", "AECameraLauncher---launchAECameraUnit-begin"));
    }
    else
    {
      paramBoolean = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
      localStringBuilder.append("isColdLaunch=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", startActivity-firstRealFrame=");
      localStringBuilder.append(a("onDrawFrameReal-end", "mainProcessLaunch"));
      localStringBuilder.append(", startActivity-firstFakeFrame=");
      localStringBuilder.append(a("onDrawFrameFake-end1", "mainProcessLaunch"));
      localStringBuilder.append(", ipc_cost=");
      localStringBuilder.append(a("activityOnCreateBegin", "mainProcessLaunch"));
      localStringBuilder.append(", activityOnCreate=");
      localStringBuilder.append(a("activityOnCreateEnd", "activityOnCreateBegin"));
      localStringBuilder.append(", buildCaptureUnit=");
      localStringBuilder.append(a("buildCaptureUnit-end", "buildCaptureUnit-begin"));
      localStringBuilder.append(", unitOnCreateView=");
      localStringBuilder.append(a("unitOnCreateView-end", "unitOnCreateView-begin"));
      localStringBuilder.append(", unitInflateView=");
      localStringBuilder.append(a("unitInflateView-end", "unitInflateView-begin"));
      localStringBuilder.append(", glSurfaceViewStaticInit=");
      localStringBuilder.append(a("glSurfaceViewStaticInit-end", "glSurfaceViewStaticInit-begin"));
      localStringBuilder.append(", activityOnStart=");
      localStringBuilder.append(a("activityOnStartEnd", "activityOnStartBegin"));
      localStringBuilder.append(", activityOnResume=");
      localStringBuilder.append(a("activityOnResumeEnd", "activityOnResumeBegin"));
      localStringBuilder.append(", activityOnResume-onSurfaceCreated=");
      localStringBuilder.append(a("onSurfaceCreated-begin", "activityOnResumeEnd"));
      localStringBuilder.append(", onSurfaceCreated=");
      localStringBuilder.append(a("onSurfaceCreated-end", "onSurfaceCreated-begin"));
      localStringBuilder.append(", startCamPreview-onFrameAvailable=");
      localStringBuilder.append(a("onFrameAvailable", "startCameraPreview-end"));
      localStringBuilder.append(", onDrawFrame1=");
      localStringBuilder.append(a("onDrawFrameFake-end1", "onDrawFrameFake-begin1"));
      localStringBuilder.append(", onDrawFrame2=");
      localStringBuilder.append(a("onDrawFrameFake-end2", "onDrawFrameFake-begin2"));
      localStringBuilder.append(", onDrawFrame3=");
      localStringBuilder.append(a("onDrawFrameFake-end3", "onDrawFrameFake-begin3"));
      localStringBuilder.append(", onDrawFrameReal=");
      localStringBuilder.append(a("onDrawFrameReal-end", "onDrawFrameReal-begin"));
      localStringBuilder.append(", filterProcessInitFilters=");
      localStringBuilder.append(a("FilterProcessInitFilters-end", "FilterProcessInitFilters-begin"));
      localStringBuilder.append(", filterMgrDraw=");
      localStringBuilder.append(a("filterMgrDraw-end", "filterMgrDraw-begin"));
      localStringBuilder.append(", onDrawFrame1End-onFrameAvailable=");
      localStringBuilder.append(a("onFrameAvailable", "onDrawFrameFake-end1"));
    }
    localStringBuilder.append("}");
    AEQLog.b("CameraLaunchPerf", localStringBuilder.toString());
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    AEQLog.a("CameraLaunchPerf", "circleClickCameraTab");
  }
  
  public void c()
  {
    if (a()) {
      return;
    }
    if (this.jdField_b_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("circle camera launch cost=");
      localStringBuilder.append(l - this.jdField_b_of_type_Long);
      AEQLog.b("CameraLaunchPerf", localStringBuilder.toString());
      this.jdField_b_of_type_Long = 0L;
    }
  }
  
  public void d()
  {
    if (a()) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    AEQLog.b("CameraLaunchPerf", "beginSession----");
  }
  
  public void e()
  {
    if (a()) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilMap.clear();
    }
    AEQLog.b("CameraLaunchPerf", "endSession----");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.perf.AELaunchRecorder
 * JD-Core Version:    0.7.0.1
 */