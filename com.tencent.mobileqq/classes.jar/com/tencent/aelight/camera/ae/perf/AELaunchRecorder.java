package com.tencent.aelight.camera.ae.perf;

import com.tencent.aelight.camera.log.AEQLog;
import java.util.HashMap;
import java.util.Map;

public final class AELaunchRecorder
{
  private boolean a = false;
  private Map<String, Long> b = new HashMap();
  private boolean c = true;
  private long d;
  private long e;
  
  private long b(String paramString)
  {
    if (this.b.containsKey(paramString)) {
      return ((Long)this.b.get(paramString)).longValue();
    }
    return 0L;
  }
  
  private long b(String paramString1, String paramString2)
  {
    long l3 = b(paramString1);
    long l4 = b(paramString2);
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
  
  public static AELaunchRecorder d()
  {
    return AELaunchRecorder.Holder.a();
  }
  
  private boolean g()
  {
    return true;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (this.d > 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("old AIO launch total cost=");
      localStringBuilder.append(l - this.d);
      AEQLog.b("CameraLaunchPerf", localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(String paramString)
  {
    if (g()) {
      return;
    }
    if ((this.a) && (!this.b.containsKey(paramString))) {
      this.b.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
    AEQLog.b("CameraLaunchPerf", paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (g()) {
      return;
    }
    if ((this.a) && (!this.b.containsKey(paramString))) {
      this.b.put(paramString, Long.valueOf(paramLong));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" real happened at ");
    localStringBuilder.append(paramLong);
    AEQLog.b("CameraLaunchPerf", localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!g())
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
    if (g()) {
      return;
    }
    if (!this.a) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("collect data:{");
    if (!paramBoolean)
    {
      localStringBuilder.append("userClick-startActivity=");
      localStringBuilder.append(b("startActivityForResult", "userClick"));
      localStringBuilder.append(", userClickDispatch=");
      localStringBuilder.append(b("AECameraLauncher---launchAECameraUnit-begin", "userClick"));
      localStringBuilder.append(", launchAECameraUnit=");
      localStringBuilder.append(b("AECameraLauncher---launchAECameraUnit-end", "AECameraLauncher---launchAECameraUnit-begin"));
    }
    else
    {
      paramBoolean = this.c;
      this.c = false;
      localStringBuilder.append("isColdLaunch=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", startActivity-firstRealFrame=");
      localStringBuilder.append(b("onDrawFrameReal-end", "mainProcessLaunch"));
      localStringBuilder.append(", startActivity-firstFakeFrame=");
      localStringBuilder.append(b("onDrawFrameFake-end1", "mainProcessLaunch"));
      localStringBuilder.append(", ipc_cost=");
      localStringBuilder.append(b("activityOnCreateBegin", "mainProcessLaunch"));
      localStringBuilder.append(", activityOnCreate=");
      localStringBuilder.append(b("activityOnCreateEnd", "activityOnCreateBegin"));
      localStringBuilder.append(", buildCaptureUnit=");
      localStringBuilder.append(b("buildCaptureUnit-end", "buildCaptureUnit-begin"));
      localStringBuilder.append(", unitOnCreateView=");
      localStringBuilder.append(b("unitOnCreateView-end", "unitOnCreateView-begin"));
      localStringBuilder.append(", unitInflateView=");
      localStringBuilder.append(b("unitInflateView-end", "unitInflateView-begin"));
      localStringBuilder.append(", glSurfaceViewStaticInit=");
      localStringBuilder.append(b("glSurfaceViewStaticInit-end", "glSurfaceViewStaticInit-begin"));
      localStringBuilder.append(", activityOnStart=");
      localStringBuilder.append(b("activityOnStartEnd", "activityOnStartBegin"));
      localStringBuilder.append(", activityOnResume=");
      localStringBuilder.append(b("activityOnResumeEnd", "activityOnResumeBegin"));
      localStringBuilder.append(", activityOnResume-onSurfaceCreated=");
      localStringBuilder.append(b("onSurfaceCreated-begin", "activityOnResumeEnd"));
      localStringBuilder.append(", onSurfaceCreated=");
      localStringBuilder.append(b("onSurfaceCreated-end", "onSurfaceCreated-begin"));
      localStringBuilder.append(", startCamPreview-onFrameAvailable=");
      localStringBuilder.append(b("onFrameAvailable", "startCameraPreview-end"));
      localStringBuilder.append(", onDrawFrame1=");
      localStringBuilder.append(b("onDrawFrameFake-end1", "onDrawFrameFake-begin1"));
      localStringBuilder.append(", onDrawFrame2=");
      localStringBuilder.append(b("onDrawFrameFake-end2", "onDrawFrameFake-begin2"));
      localStringBuilder.append(", onDrawFrame3=");
      localStringBuilder.append(b("onDrawFrameFake-end3", "onDrawFrameFake-begin3"));
      localStringBuilder.append(", onDrawFrameReal=");
      localStringBuilder.append(b("onDrawFrameReal-end", "onDrawFrameReal-begin"));
      localStringBuilder.append(", filterProcessInitFilters=");
      localStringBuilder.append(b("FilterProcessInitFilters-end", "FilterProcessInitFilters-begin"));
      localStringBuilder.append(", filterMgrDraw=");
      localStringBuilder.append(b("filterMgrDraw-end", "filterMgrDraw-begin"));
      localStringBuilder.append(", onDrawFrame1End-onFrameAvailable=");
      localStringBuilder.append(b("onFrameAvailable", "onDrawFrameFake-end1"));
    }
    localStringBuilder.append("}");
    AEQLog.b("CameraLaunchPerf", localStringBuilder.toString());
  }
  
  public void b()
  {
    if (g()) {
      return;
    }
    this.e = System.currentTimeMillis();
    AEQLog.a("CameraLaunchPerf", "circleClickCameraTab");
  }
  
  public void c()
  {
    if (g()) {
      return;
    }
    if (this.e > 0L)
    {
      long l = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("circle camera launch cost=");
      localStringBuilder.append(l - this.e);
      AEQLog.b("CameraLaunchPerf", localStringBuilder.toString());
      this.e = 0L;
    }
  }
  
  public void e()
  {
    if (g()) {
      return;
    }
    if (!this.a)
    {
      this.a = true;
      this.b.clear();
    }
    AEQLog.b("CameraLaunchPerf", "beginSession----");
  }
  
  public void f()
  {
    if (g()) {
      return;
    }
    if (this.a)
    {
      this.a = false;
      this.b.clear();
    }
    AEQLog.b("CameraLaunchPerf", "endSession----");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.perf.AELaunchRecorder
 * JD-Core Version:    0.7.0.1
 */