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

public class axym
{
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private volatile axyp jdField_a_of_type_Axyp;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocation jdField_a_of_type_ComTencentMapGeolocationTencentLocation;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Axyp != null)
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
        localObject1 = new axyl((LatLng)localObject1, this.jdField_a_of_type_ComTencentMapGeolocationTencentLocation.getProvider(), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocation.getAccuracy(), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocation.getTime());
        if (QLog.isColorLevel()) {
          QLog.e("LocationHandler", 2, "[status][loc] notifyLocationUpdate location: " + localObject1);
        }
        this.jdField_a_of_type_Axyp.a((axyl)localObject1, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
      }
      return;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager == null)
      {
        QLog.e("LocationHandler", 1, "mLocationManager is null");
        return;
      }
      Field localField1 = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.getClass().getDeclaredField("c");
      if (localField1 == null)
      {
        QLog.e("LocationHandler", 1, "field c is null");
        return;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return;
      localNoSuchFieldException.setAccessible(true);
      Object localObject1 = localNoSuchFieldException.get(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager);
      if (localObject1 == null)
      {
        QLog.e("LocationHandler", 1, "cObject is null");
        return;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    Field localField2 = localIllegalAccessException.getClass().getDeclaredField("b");
    if (localField2 == null)
    {
      QLog.e("LocationHandler", 1, "field b is null");
      return;
    }
    localField2.setAccessible(true);
    Object localObject2 = localField2.get(localIllegalAccessException);
    if (localObject2 == null)
    {
      QLog.e("LocationHandler", 1, "bObject is null");
      return;
    }
    localField2 = localObject2.getClass().getDeclaredField("g");
    if (localField2 == null)
    {
      QLog.e("LocationHandler", 1, "field g is null");
      return;
    }
    localField2.setAccessible(true);
    localField2.set(localObject2, null);
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
    this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new axyn(this, local1, localMqqHandler);
    this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new axyo(this);
    int i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.requestLocationUpdates(TencentLocationRequest.create().setInterval(paramLong), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
    if (i != 0)
    {
      QLog.e("LocationHandler", 1, "[LocationManager] requestLocationUpdates: invoked. error: " + i);
      QQToast.a(BaseApplicationImpl.context, "地图定位系统初始化失败，请稍后重试", 0).a();
      if (this.jdField_a_of_type_Axyp != null) {
        this.jdField_a_of_type_Axyp.a(i);
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
  
  public void a(axyp paramaxyp)
  {
    try
    {
      this.jdField_a_of_type_Axyp = paramaxyp;
      return;
    }
    finally
    {
      paramaxyp = finally;
      throw paramaxyp;
    }
  }
  
  public void b(axyp paramaxyp)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramaxyp + " mLocationListener: " + this.jdField_a_of_type_Axyp);
      }
      if (paramaxyp == this.jdField_a_of_type_Axyp) {
        this.jdField_a_of_type_Axyp = null;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axym
 * JD-Core Version:    0.7.0.1
 */