import android.annotation.TargetApi;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

public class bfmn
{
  public static Camera a()
  {
    return a(-1, 5);
  }
  
  public static Camera a(int paramInt)
  {
    return a(paramInt, 5);
  }
  
  @TargetApi(9)
  public static Camera a(int paramInt1, int paramInt2)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
      paramInt2 = 1;
    }
    int i = 0;
    Camera localCamera1 = null;
    Camera localCamera3;
    for (;;)
    {
      localCamera3 = localCamera1;
      if (i < paramInt2)
      {
        Camera localCamera2 = localCamera1;
        try
        {
          if ((Build.VERSION.SDK_INT >= 9) && (paramInt1 != -1)) {
            localCamera2 = localCamera1;
          }
          for (localCamera1 = Camera.open(paramInt1);; localCamera1 = Camera.open())
          {
            localCamera2 = localCamera1;
            localCamera3 = localCamera1;
            if (!QLog.isColorLevel()) {
              break;
            }
            localCamera2 = localCamera1;
            QLog.d("CameraUtil", 2, "openCameraWithRetry successfully.  retry times = " + i + ", max retry times = " + paramInt2);
            return localCamera1;
            localCamera2 = localCamera1;
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CameraUtil", 2, "openCameraWithRetry. Fail to open camera. error msg: " + localException.getMessage() + ", retry times = " + i + ", max retry times = " + paramInt2);
          }
          i += 1;
          if (i < paramInt2) {
            try
            {
              Thread.currentThread();
              Thread.sleep(500);
              Object localObject = localCamera2;
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          } else {
            throw new RuntimeException(localInterruptedException);
          }
        }
      }
    }
    return localCamera3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfmn
 * JD-Core Version:    0.7.0.1
 */