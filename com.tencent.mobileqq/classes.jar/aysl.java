import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.onlinestatus.location.LocationHandler.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.lang.reflect.Field;
import mqq.os.MqqHandler;

public class aysl
{
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private volatile ayso jdField_a_of_type_Ayso;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocation jdField_a_of_type_ComTencentMapGeolocationTencentLocation;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Ayso != null)
      {
        LatLng localLatLng = new LatLng(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocation.getLatitude(), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocation.getLongitude());
        Object localObject1 = localLatLng;
        if (QLog.isColorLevel())
        {
          localObject1 = localLatLng;
          if (jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng != null) {
            localObject1 = jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
          }
        }
        localObject1 = new aysk((LatLng)localObject1, this.jdField_a_of_type_ComTencentMapGeolocationTencentLocation.getProvider(), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocation.getAccuracy(), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocation.getTime());
        if (QLog.isColorLevel()) {
          QLog.e("LocationHandler", 2, "[status][loc] notifyLocationUpdate location: " + localObject1);
        }
        this.jdField_a_of_type_Ayso.a((aysk)localObject1, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
      }
      return;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      Object localObject = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.getClass().getDeclaredField("c");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager);
      Field localField = localObject.getClass().getDeclaredField("b");
      localField.setAccessible(true);
      localObject = localField.get(localObject);
      localField = localObject.getClass().getDeclaredField("g");
      localField.setAccessible(true);
      localField.set(localObject, null);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "stopLocationUpdate: invoked. ");
    }
    if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
      b();
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    LocationHandler.1 local1 = new LocationHandler.1(this, paramBoolean1);
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
    }
    if (paramBoolean1) {
      localMqqHandler.postDelayed(local1, 15000L);
    }
    this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
    this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new aysm(this, local1, localMqqHandler);
    this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new aysn(this);
    int i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.requestLocationUpdates(TencentLocationRequest.create().setInterval(paramLong), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
    if (i != 0)
    {
      QLog.e("LocationHandler", 1, "[LocationManager] requestLocationUpdates: invoked. error: " + i);
      QQToast.a(BaseApplicationImpl.context, "地图定位系统初始化失败，请稍后重试", 0).a();
      if (this.jdField_a_of_type_Ayso != null) {
        this.jdField_a_of_type_Ayso.a(i);
      }
    }
    if (paramBoolean2)
    {
      i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.startDirectionUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener, Looper.myLooper());
      if (i != 0)
      {
        QLog.e("LocationHandler", 1, "[LocationManager] startDirectionUpdates: invoked. error: " + i);
        QQToast.a(BaseApplicationImpl.context, 1, "方向箭头暂不可用", 0).a();
      }
    }
  }
  
  public void a(ayso paramayso)
  {
    try
    {
      this.jdField_a_of_type_Ayso = paramayso;
      return;
    }
    finally
    {
      paramayso = finally;
      throw paramayso;
    }
  }
  
  public void b(ayso paramayso)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramayso + " mLocationListener: " + this.jdField_a_of_type_Ayso);
      }
      if (paramayso == this.jdField_a_of_type_Ayso) {
        this.jdField_a_of_type_Ayso = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysl
 * JD-Core Version:    0.7.0.1
 */