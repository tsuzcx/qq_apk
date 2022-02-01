import android.graphics.Point;
import com.tencent.mobileqq.location.ui.LocationMapWidget;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import java.util.List;

public class avyk
  implements TencentMapGestureListener
{
  private boolean jdField_a_of_type_Boolean;
  private volatile boolean b;
  
  public avyk(LocationMapWidget paramLocationMapWidget) {}
  
  public boolean onDoubleTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onDown(float paramFloat1, float paramFloat2)
  {
    this.b = true;
    if (LocationMapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget) != null) {
      LocationMapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget).a(false, new Point(Math.round(paramFloat1), Math.round(paramFloat2)));
    }
    return false;
  }
  
  public boolean onFling(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onLongPress(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onMapStable()
  {
    if ((this.b) && (LocationMapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget) != null))
    {
      List localList = LocationMapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget);
      LocationMapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget).a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationMapWidget.a.getCameraPosition().target, localList);
    }
    this.b = false;
  }
  
  public boolean onScroll(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boolean = true;
    return false;
  }
  
  public boolean onSingleTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onUp(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      bcst.b(null, "CliOper", "", "", "0X800A772", "0X800A772", 0, 0, "", "0", "0", "");
      this.jdField_a_of_type_Boolean = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyk
 * JD-Core Version:    0.7.0.1
 */