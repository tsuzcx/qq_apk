import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import java.lang.ref.SoftReference;
import java.util.Map;

public class atts
  implements atpp
{
  public atts(MapWidget paramMapWidget) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null) {
      this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline.remove();
    }
    if (MapWidget.a(this.a) != null) {
      MapWidget.a(this.a).a(null);
    }
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    Object localObject = (aoof)aoks.a().a(575);
    if (localObject != null) {}
    for (localObject = ((aoof)localObject).a();; localObject = null)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
      for (localObject = this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(paramVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng).anchor(0.5F, 0.8F).zIndex(2.147484E+009F).icon(BitmapDescriptorFactory.fromResource(2130840382)));; localObject = this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions(paramVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng).anchor(0.5F, 0.8F).zIndex(2.147484E+009F).icon(BitmapDescriptorFactory.fromBitmap((Bitmap)localObject))))
      {
        if (localObject != null)
        {
          paramVenue.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(localObject);
          MapWidget.a(this.a, (Marker)localObject);
          ((Marker)localObject).setClickable(false);
          ((Marker)localObject).refreshInfoWindow();
        }
        if (MapWidget.a(this.a) != null) {
          MapWidget.a(this.a).a(paramVenue);
        }
        if (QLog.isColorLevel()) {
          QLog.d("MapWidget", 2, new Object[] { "[map][venue]onNewVenue invoked. Result venue: ", paramVenue });
        }
        return;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
        localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
        localObject = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions);
        ((URLDrawable)localObject).downloadImediatly();
        localObject = bdhj.b((Drawable)localObject);
      }
    }
  }
  
  public void a(String paramString)
  {
    Marker localMarker = (Marker)MapWidget.a(this.a).get(paramString);
    if (localMarker != null)
    {
      localMarker.remove();
      MapWidget.a(this.a).remove(paramString);
    }
    localMarker = (Marker)this.a.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localMarker != null)
    {
      localMarker.remove();
      this.a.jdField_a_of_type_JavaUtilMap.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atts
 * JD-Core Version:    0.7.0.1
 */