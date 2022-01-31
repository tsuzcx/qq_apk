import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics.1;
import java.util.Locale;

public class beyu
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private final Debug.MemoryInfo jdField_a_of_type_AndroidOsDebug$MemoryInfo = new Debug.MemoryInfo();
  private final bffe jdField_a_of_type_Bffe = new bffe();
  private final bfff jdField_a_of_type_Bfff = new bfff();
  private final bffg jdField_a_of_type_Bffg = new bffg(200);
  private MiniAppInfo jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new MiniGamePerformanceStatics.1(this);
  private long jdField_b_of_type_Long;
  private final bffe jdField_b_of_type_Bffe = new bffe();
  
  private float a()
  {
    Debug.getMemoryInfo(this.jdField_a_of_type_AndroidOsDebug$MemoryInfo);
    return this.jdField_a_of_type_AndroidOsDebug$MemoryInfo.getTotalPss() / 1024.0F;
  }
  
  private static String a(float paramFloat)
  {
    return String.format(Locale.US, "%.1f", new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void d()
  {
    this.jdField_a_of_type_Bffe.a();
    this.jdField_b_of_type_Bffe.a();
    this.jdField_a_of_type_Bffg.a();
    this.jdField_a_of_type_Long = beyf.a("-1");
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
  }
  
  private void e()
  {
    float f2 = 0.0F;
    MiniAppProxy localMiniAppProxy;
    float f5;
    float f6;
    float f7;
    float f3;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null)
    {
      long l = SystemClock.uptimeMillis() - this.jdField_b_of_type_Long;
      if (l < 10000L)
      {
        d();
        return;
      }
      localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      f5 = (float)(beyf.a("-1") - this.jdField_a_of_type_Long) / ((float)l / 1000.0F);
      f6 = this.jdField_a_of_type_Bffe.a();
      f7 = this.jdField_a_of_type_Bfff.a() - this.jdField_a_of_type_Float;
      if (!this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.isReportTypeMiniGame()) {
        break label365;
      }
      f3 = this.jdField_b_of_type_Bffe.a();
      float f4 = this.jdField_a_of_type_Bffg.a();
      bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 629, a(f5), "1");
      bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 631, a(f6), "1");
      bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 643, a(f7), "1");
      bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 630, a(f3), "1");
      bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 642, a(f4), "1");
      beza.a(f3, f4);
      f1 = f3;
      f2 = f4;
      if (localMiniAppProxy.isDebugVersion())
      {
        betc.b("MiniGamePerformance", "cpu:" + f5 + " avgMemory:" + f6 + " memoryGrowth:" + f7 + " avgFps:" + f3 + " fpsVariance:" + f4 + " dalivkPss:" + this.jdField_a_of_type_AndroidOsDebug$MemoryInfo.dalvikPss + " nativePss:" + this.jdField_a_of_type_AndroidOsDebug$MemoryInfo.nativePss + " otherPss:" + this.jdField_a_of_type_AndroidOsDebug$MemoryInfo.otherPss + " totalPss:" + this.jdField_a_of_type_AndroidOsDebug$MemoryInfo.getTotalPss());
        f2 = f4;
      }
    }
    for (float f1 = f3;; f1 = 0.0F)
    {
      bezb.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, f5, f6, f7, f1, f2);
      d();
      return;
      label365:
      bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 629, a(f5), "0");
      bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 631, a(f6), "0");
      bezi.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo, 643, a(f7), "0");
      if (localMiniAppProxy.isDebugVersion()) {
        betc.b("MiniGamePerformance", "cpu:" + f5 + " avgMemory:" + f6 + " memoryGrowth:" + f7 + " dalivkPss:" + this.jdField_a_of_type_AndroidOsDebug$MemoryInfo.dalvikPss + " nativePss:" + this.jdField_a_of_type_AndroidOsDebug$MemoryInfo.nativePss + " otherPss:" + this.jdField_a_of_type_AndroidOsDebug$MemoryInfo.otherPss + " totalPss:" + this.jdField_a_of_type_AndroidOsDebug$MemoryInfo.getTotalPss());
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float = a();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Bffg.a(paramFloat);
    this.jdField_b_of_type_Bffe.a(paramFloat);
  }
  
  public void a(MiniAppInfo paramMiniAppInfo)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo = paramMiniAppInfo;
  }
  
  public void b()
  {
    d();
    Handler localHandler = bejn.a();
    localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    localHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  public void c()
  {
    bejn.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beyu
 * JD-Core Version:    0.7.0.1
 */