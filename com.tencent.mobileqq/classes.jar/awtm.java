import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;

public class awtm
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public awtm(MapWidget paramMapWidget, ViewTreeObserver paramViewTreeObserver) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidViewViewTreeObserver.removeGlobalOnLayoutListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a != null) {
      MapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget, this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a.getPoints());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtm
 * JD-Core Version:    0.7.0.1
 */