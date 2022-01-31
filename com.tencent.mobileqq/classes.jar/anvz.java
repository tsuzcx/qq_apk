import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.qphone.base.util.QLog;

@TargetApi(9)
public class anvz
{
  private static anvz jdField_a_of_type_Anvz;
  private static Camera.CameraInfo[] jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  private final int jdField_a_of_type_Int;
  private anwt jdField_a_of_type_Anwt = anwt.a();
  private final Camera.CameraInfo[] jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  private int jdField_b_of_type_Int = -1;
  private int c = -1;
  private int d = -1;
  
  private anvz()
  {
    int i;
    if (jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo != null)
    {
      this.jdField_a_of_type_Int = jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo.length;
      this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo = jdField_b_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
      i = k;
      if (i >= this.jdField_a_of_type_Int) {
        return;
      }
      if ((this.c != -1) || (this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[i].facing != 0)) {
        break label203;
      }
      this.c = i;
    }
    for (;;)
    {
      i += 1;
      break;
      this.jdField_a_of_type_Int = a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraHolder", 1, "[CameraHolder] mNumberOfCameras = " + this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo = new Camera.CameraInfo[this.jdField_a_of_type_Int];
      int j = 0;
      for (;;)
      {
        i = k;
        if (j >= this.jdField_a_of_type_Int) {
          break;
        }
        this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[j] = new Camera.CameraInfo();
        try
        {
          Camera.getCameraInfo(j, this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[j]);
          j += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("Q.camera.CameraHolder", 2, localException, new Object[0]);
          }
        }
      }
      label203:
      if ((this.d == -1) && (this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo[i].facing == 1)) {
        this.d = i;
      }
    }
  }
  
  /* Error */
  public static anvz a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 90	anvz:jdField_a_of_type_Anvz	Lanvz;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 90	anvz:jdField_a_of_type_Anvz	Lanvz;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	anvz
    //   21: dup
    //   22: invokespecial 91	anvz:<init>	()V
    //   25: putstatic 90	anvz:jdField_a_of_type_Anvz	Lanvz;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 90	anvz:jdField_a_of_type_Anvz	Lanvz;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localanvz	anvz
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  public int a()
  {
    return anwt.a().b();
  }
  
  public anwt a()
  {
    return anwt.a();
  }
  
  public Camera.CameraInfo[] a()
  {
    return this.jdField_a_of_type_ArrayOfAndroidHardwareCamera$CameraInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvz
 * JD-Core Version:    0.7.0.1
 */