import com.tencent.mobileqq.ar.view.ARScanEntryView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class ancs
  implements TencentMap.OnCameraChangeListener
{
  public ancs(ARScanEntryView paramARScanEntryView) {}
  
  public void onCameraChange(CameraPosition paramCameraPosition) {}
  
  public void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    if ((ARScanEntryView.a(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d("AREngine_ARScanEntryView", 2, "ARLBSPOIDialog onCameraChangeFinish");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancs
 * JD-Core Version:    0.7.0.1
 */