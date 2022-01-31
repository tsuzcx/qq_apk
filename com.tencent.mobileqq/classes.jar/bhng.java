import android.hardware.SensorEventListener;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;

public class bhng
  implements SensorResource
{
  public boolean checkSensorEnable()
  {
    return lko.a().a();
  }
  
  public boolean getCameraIsFront()
  {
    return lko.a().b();
  }
  
  public int getRotation()
  {
    return 0;
  }
  
  public void registerListener(SensorEventListener paramSensorEventListener)
  {
    lko.a().a(paramSensorEventListener);
  }
  
  public void setCameraChangedListener(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack)
  {
    lko.a().a(paramCameraChangedCallBack);
  }
  
  public void unregisterListener(SensorEventListener paramSensorEventListener)
  {
    lko.a().b(paramSensorEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhng
 * JD-Core Version:    0.7.0.1
 */