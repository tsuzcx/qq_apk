import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

class atpd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  atpd(atpc paramatpc) {}
  
  public void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    CameraPosition localCameraPosition = this.a.a.a.getCameraPosition();
    if (localCameraPosition != null) {
      MapWidget.a(this.a.a).a(localCameraPosition.target);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atpd
 * JD-Core Version:    0.7.0.1
 */