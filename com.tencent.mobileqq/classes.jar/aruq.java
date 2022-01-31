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
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.List;
import mqq.os.MqqHandler;

public class aruq
  extends ajtd
  implements ajwh
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int = -1;
  private ajxl jdField_a_of_type_Ajxl;
  private akim jdField_a_of_type_Akim;
  private aruk jdField_a_of_type_Aruk;
  private aruo jdField_a_of_type_Aruo;
  private volatile aruw jdField_a_of_type_Aruw;
  private arux jdField_a_of_type_Arux;
  private aruy jdField_a_of_type_Aruy;
  public arva a;
  public arvc a;
  public arvd a;
  private arvf jdField_a_of_type_Arvf;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private volatile boolean jdField_a_of_type_Boolean;
  private LatLng jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public aruq(QQAppInterface paramQQAppInterface)
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
  
  public static aruq a(QQAppInterface paramQQAppInterface)
  {
    return (aruq)paramQQAppInterface.a(164);
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Aruw != null) {
        this.jdField_a_of_type_Aruw.a(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
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
    this.jdField_a_of_type_Arvc = new arvc(this.app, this);
    this.jdField_a_of_type_Arva = new arva(this.app);
    this.jdField_a_of_type_Arvd = new arvd(this.app);
    this.jdField_a_of_type_Arvf = new arvf(this.app);
    this.jdField_a_of_type_Aruy = new aruy(this.app, this);
    e();
    f();
    h();
    this.jdField_a_of_type_Aruo = new aruo(this.app.c());
  }
  
  private void e()
  {
    this.jdField_a_of_type_Akim = new arur(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Ajxl = new arus(this);
    this.app.addObserver(this.jdField_a_of_type_Ajxl);
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
    this.app.addObserver(this.jdField_a_of_type_Akim);
    this.app.addObserver(this.jdField_a_of_type_Ajxl);
  }
  
  private void i()
  {
    this.app.addObserver(this.jdField_a_of_type_Aruy);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "removeRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.removeObserver(this.jdField_a_of_type_Akim);
    this.app.removeObserver(this.jdField_a_of_type_Ajxl);
  }
  
  private void k()
  {
    this.app.removeObserver(this.jdField_a_of_type_Aruy);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationRoom a(aruk paramaruk)
  {
    return this.jdField_a_of_type_Aruo.a(paramaruk);
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
      if (!aryx.a(this.app, paramString)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Arvc.a(i, paramInt, paramString);
      return;
      i = 1;
      continue;
      if (paramInt == 1)
      {
        if (!aryx.b(this.app, paramString)) {
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
    if (aryx.a(this.app, paramInt1, paramString))
    {
      axqw.b(null, "CliOper", "", "", "0X800A76C", "0X800A76C", a(paramInt2), 0, "" + paramInt3, "0", "0", "");
      return;
    }
    axqw.b(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (b()) {
      return;
    }
    this.jdField_a_of_type_Aruk = paramLocationRoom.a();
    Object localObject = ajwf.a();
    if (!((ajwf)localObject).a().contains(this)) {
      ((ajwf)localObject).a(this);
    }
    localObject = new LocationHandler.3(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_Arva.a(this.jdField_a_of_type_Aruk);
    if (bool) {
      a(this.jdField_a_of_type_Aruk.a(), this.jdField_a_of_type_Aruk.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new arut(this, bool, (Runnable)localObject, localMqqHandler, paramLocationRoom);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new aruu(this);
      paramLocationRoom = ampl.a(BaseApplicationImpl.getApplication());
      int i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.requestLocationUpdates(TencentLocationRequest.create().setInterval(paramLocationRoom.a()), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      if (i != 0)
      {
        QLog.e("LocationHandler", 1, "[LocationManager] requestLocationUpdates: invoked. error: " + i);
        bcpw.a(BaseApplicationImpl.context, "地图定位系统初始化失败，请稍后重试", 0).a();
        if (paramActivity != null) {
          paramActivity.finish();
        }
      }
      i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.startDirectionUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener, Looper.myLooper());
      if (i == 0) {
        break;
      }
      QLog.e("LocationHandler", 1, "[LocationManager] startDirectionUpdates: invoked. error: " + i);
      bcpw.a(BaseApplicationImpl.context, 1, "方向箭头暂不可用", 0).a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
      }
      localMqqHandler.postDelayed((Runnable)localObject, 15000L);
    }
  }
  
  void a(aruk paramaruk)
  {
    if (a(paramaruk).b()) {
      bcpw.a(this.app.getApp(), 2131694013, 0).a();
    }
  }
  
  void a(aruk paramaruk, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + paramaruk + " clientType: " + paramInt);
    }
    a(paramaruk, true);
    this.jdField_a_of_type_Aruo.b(paramaruk, paramInt);
  }
  
  void a(aruk paramaruk, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aruo.a(paramaruk, paramInt1, paramInt2);
  }
  
  void a(aruk paramaruk, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Arux != null)
    {
      Pair localPair = this.jdField_a_of_type_Arux.a();
      if ((localPair != null) && (paramaruk.equals(localPair.first)) && (paramVenue.equals(localPair.second)))
      {
        this.jdField_a_of_type_Arux.a(paramaruk, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_Arux = null;
      }
    }
  }
  
  public void a(aruk paramaruk, LocationRoom.Venue paramVenue, arux paramarux)
  {
    if ((paramaruk == null) || (paramVenue == null))
    {
      paramarux.a(paramaruk, paramVenue, 1, false, -1);
      return;
    }
    this.jdField_a_of_type_Arux = paramarux;
    this.jdField_a_of_type_Arvf.a(paramaruk, paramVenue);
  }
  
  void a(aruk paramaruk, LocationRoom.Venue paramVenue, List<arui> paramList)
  {
    this.jdField_a_of_type_Aruo.a(paramaruk, paramVenue, paramList);
  }
  
  void a(aruk paramaruk, String paramString)
  {
    if ((a(paramaruk).b()) && (!this.app.c().equals(paramString))) {
      bcpw.a(this.app.getApp(), 2131694011, 0).a();
    }
  }
  
  public void a(aruk paramaruk, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramaruk != null) && (!paramaruk.equals(this.jdField_a_of_type_Aruk))) {}
    for (;;)
    {
      return;
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        ThreadManager.getUIHandler().post(new LocationHandler.7(this, paramaruk, paramBoolean));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. roomKey: " + paramaruk);
      }
      this.jdField_a_of_type_Aruk = null;
      ajwf.a().b(this);
      if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
      {
        this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
        g();
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
      }
      this.jdField_a_of_type_Arva.a();
      QQNotificationManager.getInstance().cancel("LocationHandler", 525);
      try
      {
        paramaruk = arzl.a(this.app);
        if (paramaruk != null)
        {
          paramaruk.a(-1);
          return;
        }
      }
      catch (Throwable paramaruk)
      {
        QLog.e("LocationHandler", 1, "stopLocationSharing: failed. ", paramaruk);
      }
    }
  }
  
  public void a(arup paramarup)
  {
    this.jdField_a_of_type_Aruo.b(paramarup);
  }
  
  public void a(aruw paramaruw)
  {
    try
    {
      this.jdField_a_of_type_Aruw = paramaruw;
      return;
    }
    finally
    {
      paramaruw = finally;
      throw paramaruw;
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
    Object localObject = ampl.a(BaseApplicationImpl.getApplication());
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.8(this), ((amun)localObject).b());
    if ((((amun)localObject).b() <= 0L) || (!b())) {
      return;
    }
    localObject = new NotificationCompat.Builder(this.app.getApp());
    ((NotificationCompat.Builder)localObject).setContentText(this.app.getApp().getString(2131694728)).setWhen(System.currentTimeMillis()).setSmallIcon(2130841016).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.9(this), 3000L);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Arva.a(paramString, new aruv(this, paramInt, paramString));
  }
  
  void b(aruk paramaruk)
  {
    if (a(paramaruk).b()) {
      bcpw.a(this.app.getApp(), 2131694012, 0).a();
    }
  }
  
  public void b(aruk paramaruk, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + paramaruk + " reason: " + paramInt);
    }
    a(paramaruk, false);
    this.jdField_a_of_type_Aruo.a(paramaruk, paramInt);
  }
  
  public void b(aruk paramaruk, LocationRoom.Venue paramVenue, arux paramarux)
  {
    if ((paramaruk == null) || (paramVenue == null))
    {
      paramarux.a(paramaruk, paramVenue, 3, false, -1);
      return;
    }
    this.jdField_a_of_type_Arux = paramarux;
    this.jdField_a_of_type_Arvf.b(paramaruk, paramVenue);
  }
  
  public void b(arup paramarup)
  {
    this.jdField_a_of_type_Aruo.a(paramarup);
  }
  
  public void b(aruw paramaruw)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramaruw + " mLocationListener: " + this.jdField_a_of_type_Aruw);
      }
      if (paramaruw == this.jdField_a_of_type_Aruw) {
        this.jdField_a_of_type_Aruw = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Aruk != null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Aruo.a(paramInt, paramString);
  }
  
  public void c(aruk paramaruk)
  {
    aruk localaruk = new aruk(this.jdField_a_of_type_Arva.a(), this.jdField_a_of_type_Arva.a());
    if (!localaruk.equals(paramaruk))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + paramaruk + " org roomKey: " + localaruk);
      }
      this.jdField_a_of_type_Aruo.a(localaruk);
    }
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return aruz.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    a(this.jdField_a_of_type_Aruk, true);
    j();
    k();
    this.jdField_a_of_type_Arvd.b();
    this.jdField_a_of_type_Arva.a();
    this.jdField_a_of_type_Aruo.a();
    adik.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      this.jdField_a_of_type_Arvc.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Arva.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Arvd.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd()));
    this.jdField_a_of_type_Arvf.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aruq
 * JD-Core Version:    0.7.0.1
 */