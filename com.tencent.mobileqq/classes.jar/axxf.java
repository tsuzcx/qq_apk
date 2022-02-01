import android.app.Application;
import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public abstract class axxf
  implements SensorEventListener, Handler.Callback
{
  protected volatile double a;
  protected int a;
  protected long a;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private Handler jdField_a_of_type_AndroidOsHandler;
  protected volatile axwb a;
  private axwo jdField_a_of_type_Axwo;
  private axwr jdField_a_of_type_Axwr = new axwr("step", axwj.B);
  private axxh jdField_a_of_type_Axxh;
  protected String a;
  private double b;
  protected int b;
  protected long b;
  private double jdField_c_of_type_Double;
  protected int c;
  private long jdField_c_of_type_Long;
  private volatile int d;
  
  axxf(int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "SensorMovementDetector";
    this.jdField_a_of_type_Axwb = new axwb(40001);
    this.jdField_a_of_type_Axwr.a(new axxg(this));
    this.d = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidHardwareSensorManager.unregisterListener(this);
    this.jdField_b_of_type_Long = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] realStopDetector");
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Axwr.a();
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_c_of_type_Double = 0.0D;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] resetTimeAndStep time:", Long.valueOf(this.jdField_a_of_type_Long), " lastDetectTime:", Double.valueOf(this.jdField_a_of_type_Double) });
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
  }
  
  private void e()
  {
    boolean bool = a();
    int i = c();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] notifyCheckStatus notmoving:", Boolean.valueOf(bool), " status:", axwj.a(i) });
    }
    if ((bool) || (i == 41042)) {
      if (this.jdField_a_of_type_Axwo != null) {
        this.jdField_a_of_type_Axwo.a();
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] notifyCheckStatus listener empty");
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] notifyCheckStatus ismoving or not right status");
  }
  
  double a()
  {
    return this.jdField_c_of_type_Double;
  }
  
  public int a()
  {
    double d1 = System.currentTimeMillis() - this.jdField_a_of_type_Double;
    if ((this.jdField_a_of_type_Double > 0.0D) && (d1 > axwj.y * axwj.B))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] reset internal: " + d1);
      }
      this.jdField_a_of_type_Axwr.a();
      this.jdField_a_of_type_Axwb.a();
    }
    return this.jdField_a_of_type_Axwb.jdField_a_of_type_Int;
  }
  
  long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a()
  {
    try
    {
      long l = System.currentTimeMillis();
      if (this.jdField_a_of_type_Double > 0.0D)
      {
        double d1 = l - this.jdField_a_of_type_Double;
        this.jdField_a_of_type_Axwr.a(d1);
        this.jdField_b_of_type_Double = d1;
      }
      this.jdField_a_of_type_Double = l;
      a(1);
      return;
    }
    finally {}
  }
  
  void a(double paramDouble)
  {
    if ((paramDouble > axwj.z) && (paramDouble < axwj.A))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] onTriggered stepTime: " + paramDouble + " result: STATUS_RUNNING");
      }
      this.jdField_a_of_type_Axwb.a(41013);
    }
    for (;;)
    {
      b();
      this.jdField_c_of_type_Double = paramDouble;
      return;
      if ((paramDouble > axwj.x) && (paramDouble < axwj.y))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] onTriggered stepTime: " + paramDouble + " result: STATUS_WALKING");
        }
        this.jdField_a_of_type_Axwb.a(41012);
      }
      else if ((paramDouble > axwj.A) && (paramDouble < axwj.x))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] onTriggered stepTime: " + paramDouble + " result: STATUS_WALKING fast");
        }
        if (this.jdField_a_of_type_Axwb.jdField_a_of_type_Int == 40001) {
          this.jdField_a_of_type_Axwb.a(41012);
        }
      }
      else if (paramDouble > axwj.y)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] onTriggered stepTime: " + paramDouble + " result: STATUS_IDLE");
        }
        this.jdField_a_of_type_Axwb.a();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] onTriggered too quick average: " + paramDouble);
      }
    }
  }
  
  protected void a(int paramInt)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 180000L) {
      d();
    }
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Int += paramInt;
    }
    do
    {
      do
      {
        return;
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 60000L)
        {
          this.jdField_a_of_type_Int += paramInt;
          return;
        }
        if ((System.currentTimeMillis() - this.jdField_a_of_type_Long <= 60000L) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 120000L)) {
          break;
        }
        this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] detectStepAndTime last1min: ", Integer.valueOf(this.jdField_a_of_type_Int), " last2min:", Integer.valueOf(this.jdField_b_of_type_Int), " last3min:", Integer.valueOf(this.jdField_c_of_type_Int), " time:", Long.valueOf(this.jdField_a_of_type_Long), " step:", Integer.valueOf(paramInt) });
      return;
      this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 60000L);
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] detectStepAndTime last1min: ", Integer.valueOf(this.jdField_a_of_type_Int), " last2min:", Integer.valueOf(this.jdField_b_of_type_Int), " last3min:", Integer.valueOf(this.jdField_c_of_type_Int), " time:", Long.valueOf(this.jdField_a_of_type_Long), " step:", Integer.valueOf(paramInt) });
  }
  
  void a(Application paramApplication)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] startDetect sensor: " + getClass().getSimpleName());
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 180000L) {
      d();
    }
    if (this.jdField_b_of_type_Long > 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] already startDetect sensor: " + getClass().getSimpleName());
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      a(0);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)paramApplication.getApplicationContext().getSystemService("sensor"));
    paramApplication = this.jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(this.d);
    this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, paramApplication, 2);
    this.jdField_a_of_type_Axwb.a("step");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    a(0);
  }
  
  public void a(axwo paramaxwo)
  {
    this.jdField_a_of_type_Axwo = paramaxwo;
  }
  
  void a(axxh paramaxxh)
  {
    this.jdField_a_of_type_Axxh = paramaxxh;
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] stopDetect sensor: " + getClass().getSimpleName(), " delay:", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, 300000L);
    }
    for (;;)
    {
      c();
      return;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][distance] isNotMoving mLast1MinSteps ", Integer.valueOf(this.jdField_a_of_type_Int), " last2:", Integer.valueOf(this.jdField_b_of_type_Int), " time:", Long.valueOf(this.jdField_b_of_type_Long) });
    }
    return (this.jdField_b_of_type_Int < axwj.M) && (System.currentTimeMillis() - this.jdField_b_of_type_Long > 60000L) && (this.jdField_a_of_type_Int < axwj.M) && (this.jdField_b_of_type_Long > 0L);
  }
  
  double b()
  {
    double d1 = System.currentTimeMillis() - this.jdField_a_of_type_Double;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] getLastRealTimeInternal internal:", Double.valueOf(d1), " mLastRealTimeInternal:", Double.valueOf(this.jdField_b_of_type_Double) });
    }
    if ((this.jdField_a_of_type_Double > 0.0D) && (d1 > axwj.y * axwj.B)) {
      return d1;
    }
    return this.jdField_b_of_type_Double;
  }
  
  public int b()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 180000L) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][distance] timeout ", Long.valueOf(this.jdField_a_of_type_Long) });
      }
    }
    do
    {
      return 70000;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][distance] check ", Integer.valueOf(this.jdField_a_of_type_Int), " ", Integer.valueOf(this.jdField_b_of_type_Int), " ", Integer.valueOf(this.jdField_c_of_type_Int) });
      }
    } while ((this.jdField_a_of_type_Int < axwj.M) && (this.jdField_b_of_type_Int < axwj.M) && (this.jdField_c_of_type_Int < axwj.M));
    return 0;
  }
  
  boolean b()
  {
    if ((this.jdField_a_of_type_Axwb.jdField_a_of_type_Int == 41012) || (this.jdField_a_of_type_Axwb.jdField_a_of_type_Int == 41013)) {
      if (this.jdField_c_of_type_Long <= 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] recordStepStartTime. start step mStatus: " + this.jdField_a_of_type_Axwb);
        }
        this.jdField_c_of_type_Long = System.currentTimeMillis();
      }
    }
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_Axxh != null) && (this.jdField_a_of_type_Axxh.a()))
      {
        long l = System.currentTimeMillis() - this.jdField_c_of_type_Long;
        if (l >= this.jdField_a_of_type_Axxh.a())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] mDurationObserver onTriggered start:", Long.valueOf(this.jdField_c_of_type_Long), " duration:", Long.valueOf(l) });
          }
          this.jdField_a_of_type_Axxh.a(this.jdField_c_of_type_Long, l);
          return true;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[status][step] recordStepStartTime. stop status: " + this.jdField_a_of_type_Axwb);
          }
          this.jdField_c_of_type_Long = 0L;
        }
      }
    }
  }
  
  public int c()
  {
    int j = 40001;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 180000L) {
      d();
    }
    int i;
    do
    {
      return j;
      if (this.jdField_a_of_type_Int < axwj.M)
      {
        i = j;
        if (this.jdField_b_of_type_Int < axwj.M) {}
      }
      else
      {
        i = j;
        if (System.currentTimeMillis() - this.jdField_b_of_type_Long > 60000L)
        {
          i = j;
          if (this.jdField_b_of_type_Long > 0L) {
            i = 41042;
          }
        }
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "[status][step] getStatusNew last1min: ", Integer.valueOf(this.jdField_a_of_type_Int), " last2min:", Integer.valueOf(this.jdField_b_of_type_Int), " last3min:", Integer.valueOf(this.jdField_c_of_type_Int), " time:", Long.valueOf(this.jdField_b_of_type_Long) });
    return i;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      b();
      continue;
      if (this.jdField_a_of_type_Axwo != null) {
        e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxf
 * JD-Core Version:    0.7.0.1
 */