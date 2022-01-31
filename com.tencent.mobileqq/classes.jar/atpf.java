import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;

public class atpf
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public atpf(MapWidget paramMapWidget, LocationRoom.Venue paramVenue) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(true, Float.valueOf(15.0F));
      return;
    }
    MapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atpf
 * JD-Core Version:    0.7.0.1
 */