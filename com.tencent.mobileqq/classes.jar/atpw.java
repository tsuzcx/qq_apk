import android.app.Activity;
import android.app.Notification;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.map.geolocation.TencentDirectionListener;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.net.LocationHandler.3;
import com.tencent.mobileqq.location.net.LocationHandler.7;
import com.tencent.mobileqq.location.net.LocationHandler.8;
import com.tencent.mobileqq.location.net.LocationHandler.9;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.List;
import mqq.os.MqqHandler;

public class atpw
  extends alpd
  implements alsi
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int = -1;
  private altm jdField_a_of_type_Altm;
  private ameq jdField_a_of_type_Ameq;
  private atpq jdField_a_of_type_Atpq;
  private atpu jdField_a_of_type_Atpu;
  private volatile atqc jdField_a_of_type_Atqc;
  private atqd jdField_a_of_type_Atqd;
  private atqe jdField_a_of_type_Atqe;
  public atqg a;
  public atqi a;
  public atqj a;
  private atql jdField_a_of_type_Atql;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private volatile boolean jdField_a_of_type_Boolean;
  private LatLng jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public atpw(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    d();
    i();
  }
  
  static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 3: 
      return 1;
    }
    return 2;
  }
  
  public static atpw a(QQAppInterface paramQQAppInterface)
  {
    return (atpw)paramQQAppInterface.a(164);
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Atqc != null) {
        this.jdField_a_of_type_Atqc.a(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Atqi = new atqi(this.app, this);
    this.jdField_a_of_type_Atqg = new atqg(this.app);
    this.jdField_a_of_type_Atqj = new atqj(this.app);
    this.jdField_a_of_type_Atql = new atql(this.app);
    this.jdField_a_of_type_Atqe = new atqe(this.app, this);
    e();
    f();
    h();
    this.jdField_a_of_type_Atpu = new atpu(this.app.c());
  }
  
  private void e()
  {
    this.jdField_a_of_type_Ameq = new atpx(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Altm = new atpy(this);
    this.app.addObserver(this.jdField_a_of_type_Altm);
  }
  
  private void g()
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
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "addRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.addObserver(this.jdField_a_of_type_Ameq);
    this.app.addObserver(this.jdField_a_of_type_Altm);
  }
  
  private void i()
  {
    this.app.addObserver(this.jdField_a_of_type_Atqe);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "removeRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.removeObserver(this.jdField_a_of_type_Ameq);
    this.app.removeObserver(this.jdField_a_of_type_Altm);
  }
  
  private void k()
  {
    this.app.removeObserver(this.jdField_a_of_type_Atqe);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationRoom a(atpq paramatpq)
  {
    return this.jdField_a_of_type_Atpu.a(paramatpq);
  }
  
  LatLng a()
  {
    if (this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng == null) {
      QLog.d("LocationHandler", 1, "[LocationManager] getSelfLatLng: invoked. location null detected");
    }
    return this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] onAppForeground: invoked. ");
    }
    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
    this.jdField_b_of_type_Boolean = true;
    jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] createOrJoinRoom: invoked.");
    }
    if (paramInt == 0) {
      if (!atue.a(this.app, paramString)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Atqi.a(i, paramInt, paramString);
      return;
      i = 1;
      continue;
      if (paramInt == 1)
      {
        if (!atue.b(this.app, paramString)) {
          i = 1;
        }
      }
      else
      {
        QLog.d("LocationHandler", 1, new Object[] { "createOrJoinRoom: invoked. (进入已关闭的房间，需要兜底逻辑[弹窗、刷新本地标志等]) ", " operateType: ", Integer.valueOf(0), " mLocationShareFragment.sessionUinType: ", Integer.valueOf(paramInt) });
        i = 0;
      }
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (atue.a(this.app, paramInt1, paramString))
    {
      azqs.b(null, "CliOper", "", "", "0X800A76C", "0X800A76C", a(paramInt2), 0, "" + paramInt3, "0", "0", "");
      return;
    }
    azqs.b(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (b()) {
      return;
    }
    this.jdField_a_of_type_Atpq = paramLocationRoom.a();
    Object localObject = alsg.a();
    if (!((alsg)localObject).a().contains(this)) {
      ((alsg)localObject).a(this);
    }
    localObject = new LocationHandler.3(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_Atqg.a(this.jdField_a_of_type_Atpq);
    if (bool) {
      a(this.jdField_a_of_type_Atpq.a(), this.jdField_a_of_type_Atpq.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new atpz(this, bool, (Runnable)localObject, localMqqHandler, paramLocationRoom);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new atqa(this);
      paramLocationRoom = aokr.a(BaseApplicationImpl.getApplication());
      int i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.requestLocationUpdates(TencentLocationRequest.create().setInterval(paramLocationRoom.a()), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      if (i != 0)
      {
        QLog.e("LocationHandler", 1, "[LocationManager] requestLocationUpdates: invoked. error: " + i);
        QQToast.a(BaseApplicationImpl.context, "地图定位系统初始化失败，请稍后重试", 0).a();
        if (paramActivity != null) {
          paramActivity.finish();
        }
      }
      i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.startDirectionUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener, Looper.myLooper());
      if (i == 0) {
        break;
      }
      QLog.e("LocationHandler", 1, "[LocationManager] startDirectionUpdates: invoked. error: " + i);
      QQToast.a(BaseApplicationImpl.context, 1, "方向箭头暂不可用", 0).a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
      }
      localMqqHandler.postDelayed((Runnable)localObject, 15000L);
    }
  }
  
  void a(atpq paramatpq)
  {
    if (a(paramatpq).b()) {
      QQToast.a(this.app.getApp(), 2131694132, 0).a();
    }
  }
  
  void a(atpq paramatpq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + paramatpq + " clientType: " + paramInt);
    }
    a(paramatpq, true);
    this.jdField_a_of_type_Atpu.b(paramatpq, paramInt);
  }
  
  void a(atpq paramatpq, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Atpu.a(paramatpq, paramInt1, paramInt2);
  }
  
  void a(atpq paramatpq, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Atqd != null)
    {
      Pair localPair = this.jdField_a_of_type_Atqd.a();
      if ((localPair != null) && (paramatpq.equals(localPair.first)) && (paramVenue.equals(localPair.second)))
      {
        this.jdField_a_of_type_Atqd.a(paramatpq, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_Atqd = null;
      }
    }
  }
  
  public void a(atpq paramatpq, LocationRoom.Venue paramVenue, atqd paramatqd)
  {
    if ((paramatpq == null) || (paramVenue == null))
    {
      paramatqd.a(paramatpq, paramVenue, 1, false, -1);
      return;
    }
    this.jdField_a_of_type_Atqd = paramatqd;
    this.jdField_a_of_type_Atql.a(paramatpq, paramVenue);
  }
  
  void a(atpq paramatpq, LocationRoom.Venue paramVenue, List<atpo> paramList)
  {
    this.jdField_a_of_type_Atpu.a(paramatpq, paramVenue, paramList);
  }
  
  void a(atpq paramatpq, String paramString)
  {
    if ((a(paramatpq).b()) && (!this.app.c().equals(paramString))) {
      QQToast.a(this.app.getApp(), 2131694130, 0).a();
    }
  }
  
  public void a(atpq paramatpq, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramatpq != null) && (!paramatpq.equals(this.jdField_a_of_type_Atpq))) {}
    for (;;)
    {
      return;
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        ThreadManager.getUIHandler().post(new LocationHandler.7(this, paramatpq, paramBoolean));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. roomKey: " + paramatpq);
      }
      this.jdField_a_of_type_Atpq = null;
      alsg.a().b(this);
      if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
      {
        this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
        g();
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
      }
      this.jdField_a_of_type_Atqg.a();
      QQNotificationManager.getInstance().cancel("LocationHandler", 525);
      try
      {
        paramatpq = atus.a(this.app);
        if (paramatpq != null)
        {
          paramatpq.a(-1);
          return;
        }
      }
      catch (Throwable paramatpq)
      {
        QLog.e("LocationHandler", 1, "stopLocationSharing: failed. ", paramatpq);
      }
    }
  }
  
  public void a(atpv paramatpv)
  {
    this.jdField_a_of_type_Atpu.b(paramatpv);
  }
  
  public void a(atqc paramatqc)
  {
    try
    {
      this.jdField_a_of_type_Atqc = paramatqc;
      return;
    }
    finally
    {
      paramatqc = finally;
      throw paramatqc;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "setJoinOrCreateRoomNotReEntry: invoked. ", " joinOrCreateRoomNotReEntry: ", Boolean.valueOf(paramBoolean) });
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "joinOrCreateRoomNotReEntry: invoked. ", " isJoinOrCreateRoomNotReEntry: ", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "[LocationManager] onAppBackground: invoked. ");
    }
    Object localObject = aokr.a(BaseApplicationImpl.getApplication());
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.8(this), ((aopz)localObject).b());
    if ((((aopz)localObject).b() <= 0L) || (!b())) {
      return;
    }
    localObject = new NotificationCompat.Builder(this.app.getApp());
    ((NotificationCompat.Builder)localObject).setContentText(this.app.getApp().getString(2131694888)).setWhen(System.currentTimeMillis()).setSmallIcon(2130841132).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.9(this), 3000L);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Atqg.a(paramString, new atqb(this, paramInt, paramString));
  }
  
  void b(atpq paramatpq)
  {
    if (a(paramatpq).b()) {
      QQToast.a(this.app.getApp(), 2131694131, 0).a();
    }
  }
  
  public void b(atpq paramatpq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + paramatpq + " reason: " + paramInt);
    }
    a(paramatpq, false);
    this.jdField_a_of_type_Atpu.a(paramatpq, paramInt);
  }
  
  public void b(atpq paramatpq, LocationRoom.Venue paramVenue, atqd paramatqd)
  {
    if ((paramatpq == null) || (paramVenue == null))
    {
      paramatqd.a(paramatpq, paramVenue, 3, false, -1);
      return;
    }
    this.jdField_a_of_type_Atqd = paramatqd;
    this.jdField_a_of_type_Atql.b(paramatpq, paramVenue);
  }
  
  public void b(atpv paramatpv)
  {
    this.jdField_a_of_type_Atpu.a(paramatpv);
  }
  
  public void b(atqc paramatqc)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramatqc + " mLocationListener: " + this.jdField_a_of_type_Atqc);
      }
      if (paramatqc == this.jdField_a_of_type_Atqc) {
        this.jdField_a_of_type_Atqc = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Atpq != null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Atpu.a(paramInt, paramString);
  }
  
  public void c(atpq paramatpq)
  {
    atpq localatpq = new atpq(this.jdField_a_of_type_Atqg.a(), this.jdField_a_of_type_Atqg.a());
    if (!localatpq.equals(paramatpq))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + paramatpq + " org roomKey: " + localatpq);
      }
      this.jdField_a_of_type_Atpu.a(localatpq);
    }
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return atqf.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    a(this.jdField_a_of_type_Atpq, true);
    j();
    k();
    this.jdField_a_of_type_Atqj.b();
    this.jdField_a_of_type_Atqg.a();
    this.jdField_a_of_type_Atpu.a();
    affd.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      this.jdField_a_of_type_Atqi.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Atqg.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Atqj.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd()));
    this.jdField_a_of_type_Atql.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atpw
 * JD-Core Version:    0.7.0.1
 */