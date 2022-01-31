import android.content.Context;
import android.view.OrientationEventListener;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;

public class anps
  extends OrientationEventListener
{
  public anps(FlowCameraActivity2 paramFlowCameraActivity2, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.k = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anps
 * JD-Core Version:    0.7.0.1
 */