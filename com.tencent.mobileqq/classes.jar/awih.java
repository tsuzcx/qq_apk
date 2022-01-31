import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class awih
{
  private static int jdField_a_of_type_Int;
  private static awih jdField_a_of_type_Awih;
  private static int b;
  private static int c;
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  
  static
  {
    int j = 0;
    if (!awih.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      b = -1;
      c = -1;
      for (;;)
      {
        int i;
        try
        {
          long l = System.currentTimeMillis();
          Object localObject = alrg.b(BaseApplicationImpl.getContext());
          if (((SharedPreferences)localObject).contains("localsp_camera_num"))
          {
            jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("localsp_camera_num", 0);
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.i("CameraAbility", 2, "getNumberOfCameras cost: " + (System.currentTimeMillis() - l));
              i = j;
            }
            if (i < jdField_a_of_type_Int)
            {
              localObject = new Camera.CameraInfo();
              Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
              if (localObject == null) {
                break label194;
              }
              if ((((Camera.CameraInfo)localObject).facing != 0) || (b != -1)) {
                break label181;
              }
              b = i;
              break label194;
            }
          }
          else
          {
            jdField_a_of_type_Int = Camera.getNumberOfCameras();
            continue;
          }
          return;
        }
        catch (RuntimeException localRuntimeException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("CameraAbility", 2, "", localRuntimeException);
          }
          jdField_a_of_type_Int = 1;
        }
        label181:
        if (1 == localRuntimeException.facing) {
          c = i;
        }
        label194:
        i += 1;
      }
    }
  }
  
  public static int a()
  {
    return c;
  }
  
  public static awih a()
  {
    if (jdField_a_of_type_Awih == null) {}
    try
    {
      if (jdField_a_of_type_Awih == null) {
        jdField_a_of_type_Awih = new awih();
      }
      return jdField_a_of_type_Awih;
    }
    finally {}
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Int > 0;
  }
  
  public static int b()
  {
    return b;
  }
  
  public static boolean b()
  {
    return (a()) && (b != -1);
  }
  
  public static boolean c()
  {
    return (a()) && (c != -1);
  }
  
  public List<Camera.Size> a()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewSizes();
      if ((localList != null) && (QLog.isColorLevel()))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Camera.Size localSize = (Camera.Size)localIterator.next();
          if (localSize != null) {
            QLog.d("CameraAbility", 2, "[@] getPreviewSizes:w=" + localSize.width + ",h=" + localSize.height + " w/h=" + localSize.width / localSize.height);
          }
        }
      }
    }
    catch (Exception localException)
    {
      List<Camera.Size> localList1;
      for (;;)
      {
        localException.printStackTrace();
        localList1 = null;
      }
      return localList1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidHardwareCamera$Parameters = null;
  }
  
  public boolean a(int paramInt)
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewFormats();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains(Integer.valueOf(paramInt));
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean a(Camera paramCamera)
  {
    a();
    if (paramCamera == null) {}
    for (;;)
    {
      return false;
      try
      {
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters = paramCamera.getParameters();
        if (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null) {
          continue;
        }
        return true;
      }
      catch (Exception paramCamera)
      {
        for (;;)
        {
          paramCamera.printStackTrace();
          this.jdField_a_of_type_AndroidHardwareCamera$Parameters = null;
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedFocusModes();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains(paramString);
      if (bool) {
        return true;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public List<Camera.Size> b()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPictureSizes();
      if ((localList != null) && (QLog.isColorLevel()))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Camera.Size localSize = (Camera.Size)localIterator.next();
          if (localSize != null) {
            QLog.d("CameraAbility", 2, "[@] getPictureSizes:w=" + localSize.width + ",h=" + localSize.height + " w/h=" + localSize.width / localSize.height);
          }
        }
      }
    }
    catch (Exception localException)
    {
      List<Camera.Size> localList1;
      for (;;)
      {
        localException.printStackTrace();
        localList1 = null;
      }
      return localList1;
    }
  }
  
  public boolean b(String paramString)
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedSceneModes();
      if ((localList != null) && (!localList.isEmpty()))
      {
        boolean bool = localList.contains(paramString);
        return bool;
      }
    }
    catch (Exception paramString) {}
    return false;
  }
  
  @TargetApi(9)
  public List<int[]> c()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewFpsRange();
      return localList;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean d()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.isZoomSupported();
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public boolean e()
  {
    if ((!jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null)) {
      throw new AssertionError();
    }
    try
    {
      List localList = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedFlashModes();
      if (localList == null) {
        return false;
      }
      boolean bool = localList.contains("torch");
      if (bool) {
        return true;
      }
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awih
 * JD-Core Version:    0.7.0.1
 */