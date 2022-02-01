import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import com.tencent.mobileqq.armap.sensor.provider.OrientationProviderNotFound;
import java.util.List;

public class aqdv
  extends aqdt
{
  private float[] d = new float[16];
  
  public aqdv(Context paramContext, int paramInt, SensorManager paramSensorManager, aqdl paramaqdl)
  {
    super(paramContext, paramInt, paramSensorManager, paramaqdl);
    paramContext = paramSensorManager.getDefaultSensor(11);
    if ((Build.VERSION.SDK_INT >= 9) && (paramContext != null))
    {
      this.a.add(paramContext);
      return;
    }
    throw new OrientationProviderNotFound(String.valueOf(3));
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    aqdn.a(this.d, paramSensorEvent);
    super.a(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdv
 * JD-Core Version:    0.7.0.1
 */