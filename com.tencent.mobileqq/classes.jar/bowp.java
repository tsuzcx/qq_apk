import java.util.HashMap;
import java.util.Map;

public final class bowp
{
  private long jdField_a_of_type_Long;
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
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
    long l2 = 0L;
    long l3 = a(paramString1);
    long l4 = a(paramString2);
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
  
  public static bowp a()
  {
    return bowr.a();
  }
  
  private boolean a()
  {
    return true;
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_Long > 0L) {
      bpam.b("CameraLaunchPerf", "old AIO launch total cost=" + (l - this.jdField_a_of_type_Long));
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
    bpam.b("CameraLaunchPerf", paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (a()) {
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(paramLong));
    }
    bpam.b("CameraLaunchPerf", paramString + " real happened at " + paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!a()) {
      bpam.b("CameraLaunchPerf******", paramString1 + "--" + paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (a()) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("collect data:{");
    if (!paramBoolean) {
      localStringBuilder.append("userClick-startActivity=").append(a("startActivityForResult", "userClick")).append(", userClickDispatch=").append(a("AECameraLauncher---launchAECameraUnit-begin", "userClick")).append(", launchAECameraUnit=").append(a("AECameraLauncher---launchAECameraUnit-end", "AECameraLauncher---launchAECameraUnit-begin"));
    }
    for (;;)
    {
      localStringBuilder.append("}");
      bpam.b("CameraLaunchPerf", localStringBuilder.toString());
      return;
      paramBoolean = this.jdField_b_of_type_Boolean;
      this.jdField_b_of_type_Boolean = false;
      localStringBuilder.append("isColdLaunch=").append(paramBoolean).append(", startActivity-firstRealFrame=").append(a("onDrawFrameReal-end", "mainProcessLaunch")).append(", startActivity-firstFakeFrame=").append(a("onDrawFrameFake-end1", "mainProcessLaunch")).append(", ipc_cost=").append(a("activityOnCreateBegin", "mainProcessLaunch")).append(", activityOnCreate=").append(a("activityOnCreateEnd", "activityOnCreateBegin")).append(", buildCaptureUnit=").append(a("buildCaptureUnit-end", "buildCaptureUnit-begin")).append(", unitOnCreateView=").append(a("unitOnCreateView-end", "unitOnCreateView-begin")).append(", unitInflateView=").append(a("unitInflateView-end", "unitInflateView-begin")).append(", glSurfaceViewStaticInit=").append(a("glSurfaceViewStaticInit-end", "glSurfaceViewStaticInit-begin")).append(", activityOnStart=").append(a("activityOnStartEnd", "activityOnStartBegin")).append(", activityOnResume=").append(a("activityOnResumeEnd", "activityOnResumeBegin")).append(", activityOnResume-onSurfaceCreated=").append(a("onSurfaceCreated-begin", "activityOnResumeEnd")).append(", onSurfaceCreated=").append(a("onSurfaceCreated-end", "onSurfaceCreated-begin")).append(", startCamPreview-onFrameAvailable=").append(a("onFrameAvailable", "startCameraPreview-end")).append(", onDrawFrame1=").append(a("onDrawFrameFake-end1", "onDrawFrameFake-begin1")).append(", onDrawFrame2=").append(a("onDrawFrameFake-end2", "onDrawFrameFake-begin2")).append(", onDrawFrame3=").append(a("onDrawFrameFake-end3", "onDrawFrameFake-begin3")).append(", onDrawFrameReal=").append(a("onDrawFrameReal-end", "onDrawFrameReal-begin")).append(", filterProcessInitFilters=").append(a("FilterProcessInitFilters-end", "FilterProcessInitFilters-begin")).append(", filterMgrDraw=").append(a("filterMgrDraw-end", "filterMgrDraw-begin")).append(", onDrawFrame1End-onFrameAvailable=").append(a("onFrameAvailable", "onDrawFrameFake-end1"));
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    bpam.a("CameraLaunchPerf", "circleClickCameraTab");
  }
  
  public void c()
  {
    if (a()) {}
    while (this.jdField_b_of_type_Long <= 0L) {
      return;
    }
    long l = System.currentTimeMillis();
    bpam.b("CameraLaunchPerf", "circle camera launch cost=" + (l - this.jdField_b_of_type_Long));
    this.jdField_b_of_type_Long = 0L;
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
    bpam.b("CameraLaunchPerf", "beginSession----");
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
    bpam.b("CameraLaunchPerf", "endSession----");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bowp
 * JD-Core Version:    0.7.0.1
 */