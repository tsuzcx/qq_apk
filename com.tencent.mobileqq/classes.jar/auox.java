import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.launch.LaunchTrace.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class auox
{
  private int jdField_a_of_type_Int;
  public long a;
  private boolean jdField_a_of_type_Boolean;
  public long b;
  private boolean b;
  public long c;
  private boolean c;
  public long d;
  private boolean d;
  private long e;
  private long f;
  private long g;
  private long h;
  
  void a()
  {
    this.f = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "installStartTime");
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (this.e > 0L) {
      this.jdField_d_of_type_Long = (SystemClock.elapsedRealtime() - this.e);
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((!paramBoolean) && (this.jdField_d_of_type_Boolean)) {
      ThreadManager.getSubThreadHandler().post(new LaunchTrace.1(this));
    }
    QLog.d("QFlutter.LaunchTrace", 1, String.format("[QFlutterLaunchCost]onLaunchFinish,isPreloadProcess: %s, errorCode: %s, isLocalEngineExist: %s, isLocalAppExist: %s, launchCost: %s, installCost: %s, loadAssetCost: %s, loadEngineCost: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(this.jdField_c_of_type_Boolean), Long.valueOf(this.jdField_d_of_type_Long), Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long) }));
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.e = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLaunchStart");
    }
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
  
  void b()
  {
    this.g = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLoadAssetStart");
    }
  }
  
  void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f > 0L) {
      this.jdField_a_of_type_Long = (SystemClock.elapsedRealtime() - this.f);
    }
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onInstallFinish, isLocalEngineExist: %s, isLocalAppExist: %s, installCost: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(this.jdField_a_of_type_Long) }));
    }
  }
  
  void c()
  {
    if (this.g > 0L) {
      this.jdField_b_of_type_Long = (SystemClock.elapsedRealtime() - this.g);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onLoadAssetFinish, loadAssetCost: %s", new Object[] { Long.valueOf(this.jdField_b_of_type_Long) }));
    }
  }
  
  void d()
  {
    this.h = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLoadEngineStart");
    }
  }
  
  void e()
  {
    if (this.h > 0L) {
      this.jdField_c_of_type_Long = (SystemClock.elapsedRealtime() - this.h);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onLoadEngineFinish, loadEngineCost: %s", new Object[] { Long.valueOf(this.jdField_c_of_type_Long) }));
    }
  }
  
  public void f()
  {
    this.e = 0L;
    this.f = 0L;
    this.jdField_a_of_type_Long = 0L;
    this.g = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.h = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auox
 * JD-Core Version:    0.7.0.1
 */