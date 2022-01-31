import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

public class aryc
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long e;
  private long f;
  private long g;
  private long h;
  
  void a()
  {
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "installStartTime");
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Long > 0L) {
      this.h = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_Int = paramInt;
    if ((!paramBoolean) && (this.jdField_d_of_type_Boolean)) {
      aryh.a(this.jdField_a_of_type_Int, this.h, this.e, this.f, this.g, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Boolean);
    }
    QLog.d("QFlutter.LaunchTrace", 1, String.format("[QFlutterLaunchCost]onLaunchFinish,isPreloadProcess: %s, errorCode: %s, isLocalEngineExist: %s, isLocalAppExist: %s, launchCost: %s, installCost: %s, loadAssetCost: %s, loadEngineCost: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(this.jdField_c_of_type_Boolean), Long.valueOf(this.h), Long.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.g) }));
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLaunchStart");
    }
  }
  
  void b()
  {
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLoadAssetStart");
    }
  }
  
  void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_Long > 0L) {
      this.e = (SystemClock.elapsedRealtime() - this.jdField_b_of_type_Long);
    }
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onInstallFinish, isLocalEngineExist: %s, isLocalAppExist: %s, installCost: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Long.valueOf(this.e) }));
    }
  }
  
  void c()
  {
    if (this.jdField_c_of_type_Long > 0L) {
      this.f = (SystemClock.elapsedRealtime() - this.jdField_c_of_type_Long);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onLoadAssetFinish, loadAssetCost: %s", new Object[] { Long.valueOf(this.f) }));
    }
  }
  
  void d()
  {
    this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, "onLoadEngineStart");
    }
  }
  
  void e()
  {
    if (this.jdField_d_of_type_Long > 0L) {
      this.g = (SystemClock.elapsedRealtime() - this.jdField_d_of_type_Long);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.LaunchTrace", 2, String.format("onLoadEngineFinish, loadEngineCost: %s", new Object[] { Long.valueOf(this.g) }));
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.e = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.f = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.g = 0L;
    this.h = 0L;
    this.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryc
 * JD-Core Version:    0.7.0.1
 */