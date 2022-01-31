import android.hardware.SensorEventListener;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;

public class bfmm
  implements SensorResource
{
  public boolean checkSensorEnable()
  {
    return lil.a().a();
  }
  
  public boolean getCameraIsFront()
  {
    return lil.a().b();
  }
  
  public int getRotation()
  {
    return 0;
  }
  
  public void registerListener(SensorEventListener paramSensorEventListener)
  {
    lil.a().a(paramSensorEventListener);
  }
  
  public void setCameraChangedListener(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack)
  {
    lil.a().a(paramCameraChangedCallBack);
  }
  
  public void unregisterListener(SensorEventListener paramSensorEventListener)
  {
    lil.a().b(paramSensorEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfmm
 * JD-Core Version:    0.7.0.1
 */