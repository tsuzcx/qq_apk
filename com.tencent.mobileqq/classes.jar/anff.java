import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.2;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.3;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

public class anff
{
  private static double jdField_a_of_type_Double = 3.141592653589793D;
  private static double jdField_b_of_type_Double = 6378245.0D;
  private static double jdField_c_of_type_Double = 0.006693421622965943D;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long = 0L;
  private amle jdField_a_of_type_Amle;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorEventListener jdField_a_of_type_AndroidHardwareSensorEventListener;
  private anfh jdField_a_of_type_Anfh;
  private anfj jdField_a_of_type_Anfj;
  private anfk jdField_a_of_type_Anfk;
  private anfl jdField_a_of_type_Anfl;
  private anfn jdField_a_of_type_Anfn;
  private anfo jdField_a_of_type_Anfo;
  private String jdField_a_of_type_JavaLangString;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[3];
  private float jdField_b_of_type_Float;
  private long jdField_b_of_type_Long = 0L;
  private Sensor jdField_b_of_type_AndroidHardwareSensor;
  private String jdField_b_of_type_JavaLangString;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[3];
  private float jdField_c_of_type_Float;
  private long jdField_c_of_type_Long = 0L;
  private double jdField_d_of_type_Double = 0.0D;
  private long jdField_d_of_type_Long = 0L;
  private double jdField_e_of_type_Double = 0.0D;
  private long jdField_e_of_type_Long = 0L;
  
  public anff(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidHardwareSensorEventListener = new anfi(this);
    this.jdField_a_of_type_Amle = new anfg(this, 3, true, true, 0L, true, true, "ArkAppEventObserverManager");
  }
  
  private static double a(double paramDouble1, double paramDouble2)
  {
    return -100.0D + 2.0D * paramDouble1 + 3.0D * paramDouble2 + 0.2D * paramDouble2 * paramDouble2 + 0.1D * paramDouble1 * paramDouble2 + 0.2D * Math.sqrt(Math.abs(paramDouble1)) + (20.0D * Math.sin(6.0D * paramDouble1 * jdField_a_of_type_Double) + 20.0D * Math.sin(2.0D * paramDouble1 * jdField_a_of_type_Double)) * 2.0D / 3.0D + (20.0D * Math.sin(jdField_a_of_type_Double * paramDouble2) + 40.0D * Math.sin(paramDouble2 / 3.0D * jdField_a_of_type_Double)) * 2.0D / 3.0D + (160.0D * Math.sin(paramDouble2 / 12.0D * jdField_a_of_type_Double) + 320.0D * Math.sin(jdField_a_of_type_Double * paramDouble2 / 30.0D)) * 2.0D / 3.0D;
  }
  
  private void a(SensorEvent paramSensorEvent)
  {
    long l = System.currentTimeMillis();
    ArkAppCenter.a().post(this.jdField_a_of_type_JavaLangString, new ArkAppEventObserverManager.2(this, paramSensorEvent, l));
  }
  
  private static boolean a(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 < 72.004000000000005D) || (paramDouble1 > 137.8347D)) {}
    while ((paramDouble2 < 0.8293D) || (paramDouble2 > 55.827100000000002D)) {
      return true;
    }
    return false;
  }
  
  public static double[] a(double paramDouble1, double paramDouble2)
  {
    if (a(paramDouble1, paramDouble2)) {
      return new double[] { paramDouble1, paramDouble2 };
    }
    double d3 = a(paramDouble1 - 105.0D, paramDouble2 - 35.0D);
    double d1 = b(paramDouble1 - 105.0D, paramDouble2 - 35.0D);
    double d2 = paramDouble2 / 180.0D * jdField_a_of_type_Double;
    double d4 = Math.sin(d2);
    double d5 = 1.0D - d4 * (jdField_c_of_type_Double * d4);
    d4 = Math.sqrt(d5);
    d3 = d3 * 180.0D / (jdField_b_of_type_Double * (1.0D - jdField_c_of_type_Double) / (d5 * d4) * jdField_a_of_type_Double);
    d4 = jdField_b_of_type_Double / d4;
    return new double[] { 2.0D * paramDouble1 - (d1 * 180.0D / (Math.cos(d2) * d4 * jdField_a_of_type_Double) + paramDouble1), 2.0D * paramDouble2 - (paramDouble2 + d3) };
  }
  
  private static double b(double paramDouble1, double paramDouble2)
  {
    return 300.0D + paramDouble1 + 2.0D * paramDouble2 + 0.1D * paramDouble1 * paramDouble1 + 0.1D * paramDouble1 * paramDouble2 + 0.1D * Math.sqrt(Math.abs(paramDouble1)) + (20.0D * Math.sin(6.0D * paramDouble1 * jdField_a_of_type_Double) + 20.0D * Math.sin(2.0D * paramDouble1 * jdField_a_of_type_Double)) * 2.0D / 3.0D + (20.0D * Math.sin(jdField_a_of_type_Double * paramDouble1) + 40.0D * Math.sin(paramDouble1 / 3.0D * jdField_a_of_type_Double)) * 2.0D / 3.0D + (150.0D * Math.sin(paramDouble1 / 12.0D * jdField_a_of_type_Double) + 300.0D * Math.sin(paramDouble1 / 30.0D * jdField_a_of_type_Double)) * 2.0D / 3.0D;
  }
  
  private void b(SensorEvent paramSensorEvent)
  {
    long l = System.currentTimeMillis();
    ArkAppCenter.a().post(this.jdField_a_of_type_JavaLangString, new ArkAppEventObserverManager.3(this, l, paramSensorEvent));
  }
  
  public void a()
  {
    a("Motion");
    a("Orientation");
    a("Position");
    a("ConnectionTypeChange");
  }
  
  public void a(anfm paramanfm, long paramLong)
  {
    if ((paramanfm instanceof anfl))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppEventObserverManager", 2, "attachEvent MotionCallback");
      }
      if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Anfl != null)) {
        this.jdField_a_of_type_Anfl.a(this.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_Anfl = ((anfl)paramanfm);
      this.jdField_a_of_type_Long = paramLong;
      if (this.jdField_a_of_type_AndroidHardwareSensor == null)
      {
        paramanfm = (SensorManager)BaseApplicationImpl.getApplication().getSystemService("sensor");
        this.jdField_a_of_type_AndroidHardwareSensor = paramanfm.getDefaultSensor(1);
        if (this.jdField_a_of_type_AndroidHardwareSensor == null) {
          break label113;
        }
        paramanfm.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor, 1);
      }
    }
    label113:
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ArkAppEventObserverManager", 2, "mMotionSensor is NULL");
          }
          this.jdField_a_of_type_Anfl.a(false, 0.0F, 0.0F, 0.0F);
          return;
          if (!(paramanfm instanceof anfn)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ArkAppEventObserverManager", 2, "attachEvent OrientationCallback");
          }
          if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_a_of_type_Anfn != null)) {
            this.jdField_a_of_type_Anfn.a(this.jdField_b_of_type_Long);
          }
          this.jdField_a_of_type_Anfn = ((anfn)paramanfm);
          this.jdField_b_of_type_Long = paramLong;
        } while (this.jdField_b_of_type_AndroidHardwareSensor != null);
        paramanfm = (SensorManager)BaseApplicationImpl.getApplication().getSystemService("sensor");
        this.jdField_b_of_type_AndroidHardwareSensor = paramanfm.getDefaultSensor(3);
        paramanfm.registerListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_b_of_type_AndroidHardwareSensor, 1);
        return;
        if ((paramanfm instanceof anfo))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkAppEventObserverManager", 2, "attachEvent PositionCallback callback=" + paramanfm + ", cbId=" + paramLong + ", mPositionCallback=" + this.jdField_a_of_type_Anfo + ", mPositionCallbackId=" + this.jdField_c_of_type_Long);
          }
          if ((this.jdField_c_of_type_Long != 0L) && (this.jdField_a_of_type_Anfo != null)) {
            this.jdField_a_of_type_Anfo.a(this.jdField_c_of_type_Long);
          }
          this.jdField_a_of_type_Anfo = ((anfo)paramanfm);
          this.jdField_c_of_type_Long = paramLong;
          SosoInterface.a(this.jdField_a_of_type_Amle);
          return;
        }
        if (!(paramanfm instanceof anfj)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppEventObserverManager", 2, "attachEvent ConnectionCallback");
        }
        if ((this.jdField_d_of_type_Long != 0L) && (this.jdField_a_of_type_Anfj != null)) {
          this.jdField_a_of_type_Anfj.a(this.jdField_d_of_type_Long);
        }
        this.jdField_a_of_type_Anfj = ((anfj)paramanfm);
        this.jdField_d_of_type_Long = paramLong;
      } while (this.jdField_a_of_type_Anfh != null);
      this.jdField_a_of_type_Anfh = new anfh(this);
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this.jdField_a_of_type_Anfh);
      return;
    } while (!(paramanfm instanceof anfk));
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "attachEvent GetCurrentPositionCallback");
    }
    if ((this.jdField_e_of_type_Long != 0L) && (this.jdField_a_of_type_Anfk != null)) {
      this.jdField_a_of_type_Anfk.a(this.jdField_e_of_type_Long);
    }
    this.jdField_a_of_type_Anfk = ((anfk)paramanfm);
    this.jdField_e_of_type_Long = paramLong;
    SosoInterface.a(this.jdField_a_of_type_Amle);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "detachEvent eventName=" + paramString);
    }
    if ("Motion".equals(paramString))
    {
      if (this.jdField_a_of_type_AndroidHardwareSensor != null)
      {
        ((SensorManager)BaseApplicationImpl.getApplication().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_a_of_type_AndroidHardwareSensor);
        this.jdField_a_of_type_AndroidHardwareSensor = null;
      }
      if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Anfl != null)) {
        this.jdField_a_of_type_Anfl.a(this.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_Anfl = null;
      this.jdField_a_of_type_Long = 0L;
    }
    do
    {
      return;
      if ("Orientation".equals(paramString))
      {
        if (this.jdField_b_of_type_AndroidHardwareSensor != null)
        {
          ((SensorManager)BaseApplicationImpl.getApplication().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_AndroidHardwareSensorEventListener, this.jdField_b_of_type_AndroidHardwareSensor);
          this.jdField_b_of_type_AndroidHardwareSensor = null;
        }
        if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_a_of_type_Anfn != null)) {
          this.jdField_a_of_type_Anfn.a(this.jdField_b_of_type_Long);
        }
        this.jdField_a_of_type_Anfn = null;
        this.jdField_b_of_type_Long = 0L;
        return;
      }
      if ("Position".equals(paramString))
      {
        SosoInterface.b(this.jdField_a_of_type_Amle);
        if (QLog.isColorLevel()) {
          QLog.d("ArkAppEventObserverManager", 2, "detachEvent PositionCallback mPositionCallback=" + this.jdField_a_of_type_Anfo + ", mPositionCallbackId=" + this.jdField_c_of_type_Long);
        }
        if ((this.jdField_c_of_type_Long != 0L) && (this.jdField_a_of_type_Anfo != null)) {
          this.jdField_a_of_type_Anfo.a(this.jdField_c_of_type_Long);
        }
        this.jdField_a_of_type_Anfo = null;
        this.jdField_c_of_type_Long = 0L;
        this.jdField_d_of_type_Double = 0.0D;
        this.jdField_e_of_type_Double = 0.0D;
        return;
      }
    } while (!"ConnectionTypeChange".equals(paramString));
    if (this.jdField_a_of_type_Anfh != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Anfh);
      this.jdField_a_of_type_Anfh = null;
    }
    if ((this.jdField_d_of_type_Long != 0L) && (this.jdField_a_of_type_Anfj != null)) {
      this.jdField_a_of_type_Anfj.a(this.jdField_d_of_type_Long);
    }
    this.jdField_a_of_type_Anfj = null;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anff
 * JD-Core Version:    0.7.0.1
 */