import android.hardware.SensorEventListener;
import com.tencent.mobileqq.shortvideo.panoramicvideo.Sensor.SensorEventHandler.CameraChangedCallBack;
import com.tencent.mobileqq.shortvideo.resource.SensorResource;

public class blgb
  implements SensorResource
{
  public boolean checkSensorEnable()
  {
    return lhq.a().a();
  }
  
  public boolean getCameraIsFront()
  {
    return lhq.a().b();
  }
  
  public int getRotation()
  {
    return 0;
  }
  
  public void registerListener(SensorEventListener paramSensorEventListener)
  {
    lhq.a().a(paramSensorEventListener);
  }
  
  public void setCameraChangedListener(SensorEventHandler.CameraChangedCallBack paramCameraChangedCallBack)
  {
    lhq.a().a(paramCameraChangedCallBack);
  }
  
  public void unregisterListener(SensorEventListener paramSensorEventListener)
  {
    lhq.a().b(paramSensorEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgb
 * JD-Core Version:    0.7.0.1
 */