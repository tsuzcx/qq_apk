import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import dov.com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;

class aohk
  implements Runnable
{
  aohk(aohe paramaohe) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = localSharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
    boolean bool2 = localSharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
    CameraControl localCameraControl = CameraControl.a();
    if ((!bool1) && (FlowCameraConstant.a == 1))
    {
      NewFlowCameraReporter.a(localCameraControl.a(), "front");
      localSharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
    }
    while ((bool2) || (FlowCameraConstant.a != 2)) {
      return;
    }
    NewFlowCameraReporter.a(localCameraControl.a(), "back");
    localSharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aohk
 * JD-Core Version:    0.7.0.1
 */