import android.content.Context;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.locks.ReentrantLock;

public class amrv
{
  public static boolean a;
  public static final float[] a;
  private amrx jdField_a_of_type_Amrx;
  private Context jdField_a_of_type_AndroidContentContext;
  private anor jdField_a_of_type_Anor;
  private anov jdField_a_of_type_Anov = new amrw(this);
  private ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private float[] c;
  private float[] d = new float[4];
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(jdField_a_of_type_ArrayOfFloat, 0);
    jdField_a_of_type_Boolean = true;
  }
  
  public static boolean a()
  {
    String str = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.ARCfg.name());
    if (!TextUtils.isEmpty(str))
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "";
      int i = DeviceProfileManager.a(str, arrayOfString, new almp());
      boolean bool;
      if (i >= 1) {
        if (Integer.valueOf(arrayOfString[0]).intValue() == 1) {
          bool = true;
        }
      }
      for (;;)
      {
        QLog.i("AREngine_SensorTrackManager", 1, "arCfg = " + str + ", size = " + i + ", params[0] = " + arrayOfString[0] + ", isUseGameRotationVector = " + bool);
        return bool;
        bool = false;
        continue;
        bool = false;
      }
    }
    return false;
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(Context paramContext, amrx paramamrx)
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Amrx = paramamrx;
    b();
    jdField_a_of_type_Boolean = this.jdField_a_of_type_Anor.b();
    amzf.a().c(System.currentTimeMillis() - l);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      QLog.d("SensorTrackManager", 2, "enableSensor enabled: " + paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Anor == null) {
      if (!a()) {
        break label57;
      }
    }
    label57:
    for (this.jdField_a_of_type_Anor = new anor(this.jdField_a_of_type_AndroidContentContext, 5);; this.jdField_a_of_type_Anor = new anor(this.jdField_a_of_type_AndroidContentContext, 4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SensorTrackManager", 2, "startupSensor");
      }
      this.jdField_a_of_type_Anor.a(this.jdField_a_of_type_Anov, 1);
      return;
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SensorTrackManager", 2, "stopSensor");
    }
    if (this.jdField_a_of_type_Anor != null)
    {
      this.jdField_a_of_type_Anor.a();
      this.jdField_a_of_type_Anor = null;
    }
  }
  
  public void d()
  {
    a(false);
  }
  
  public void e()
  {
    c();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_Boolean = false;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrv
 * JD-Core Version:    0.7.0.1
 */