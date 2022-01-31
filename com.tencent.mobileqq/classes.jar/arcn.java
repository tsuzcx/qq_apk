import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

class arcn
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  arcn(arcm paramarcm) {}
  
  public void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    CameraPosition localCameraPosition = this.a.a.a.getCameraPosition();
    if (localCameraPosition != null) {
      MapWidget.a(this.a.a).a(localCameraPosition.target);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arcn
 * JD-Core Version:    0.7.0.1
 */