import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

class awti
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  awti(awth paramawth) {}
  
  public void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    CameraPosition localCameraPosition = this.a.a.a.getCameraPosition();
    if (localCameraPosition != null) {
      MapWidget.a(this.a.a).a(localCameraPosition.target);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awti
 * JD-Core Version:    0.7.0.1
 */