import android.view.ViewTreeObserver;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.util.List;

public class avyi
  implements TencentMap.OnMapLoadedCallback
{
  public avyi(LocationMapWidget paramLocationMapWidget) {}
  
  public void onMapLoaded()
  {
    if (LocationMapWidget.a(this.a) != null)
    {
      if (this.a.a.getCameraPosition() == null) {
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new avyj(this));
      }
    }
    else {
      return;
    }
    List localList = LocationMapWidget.a(this.a);
    LocationMapWidget.a(this.a).a(this.a.a.getCameraPosition().target, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyi
 * JD-Core Version:    0.7.0.1
 */