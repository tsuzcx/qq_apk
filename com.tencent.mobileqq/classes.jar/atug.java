import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import java.util.List;

public class atug
  implements TencentMap.OnMapLoadedCallback
{
  public atug(FloatMapWidget paramFloatMapWidget) {}
  
  public void onMapLoaded()
  {
    Object localObject = FloatMapWidget.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. selfItem: ", ((atpo)localObject).a() });
    }
    if (((atpo)localObject).a() != null)
    {
      localObject = FloatMapWidget.b(this.a).a();
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "onMapLoaded: invoked. ", " venue: ", localObject });
      }
      if ((FloatMapWidget.c(this.a).d().size() != 1) || (localObject != null)) {
        break label136;
      }
      this.a.a(false, null);
    }
    for (;;)
    {
      FloatMapWidget.a(this.a, true);
      FloatMapWidget.a(this.a);
      return;
      label136:
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atug
 * JD-Core Version:    0.7.0.1
 */