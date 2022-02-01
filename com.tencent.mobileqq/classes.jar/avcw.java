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
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
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

public class avcw
  extends BusinessHandler
  implements amrs
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int = -1;
  private amsu jdField_a_of_type_Amsu;
  private andd jdField_a_of_type_Andd;
  private avcq jdField_a_of_type_Avcq;
  private avcu jdField_a_of_type_Avcu;
  private volatile avdc jdField_a_of_type_Avdc;
  private avdd jdField_a_of_type_Avdd;
  private avde jdField_a_of_type_Avde;
  public avdg a;
  public avdi a;
  public avdj a;
  private avdl jdField_a_of_type_Avdl;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private volatile boolean jdField_a_of_type_Boolean;
  private LatLng jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public avcw(QQAppInterface paramQQAppInterface)
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
  
  public static avcw a(QQAppInterface paramQQAppInterface)
  {
    return (avcw)paramQQAppInterface.getBusinessHandler(164);
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Avdc != null) {
        this.jdField_a_of_type_Avdc.a(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
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
    this.jdField_a_of_type_Avdi = new avdi(this.app, this);
    this.jdField_a_of_type_Avdg = new avdg(this.app);
    this.jdField_a_of_type_Avdj = new avdj(this.app);
    this.jdField_a_of_type_Avdl = new avdl(this.app);
    this.jdField_a_of_type_Avde = new avde(this.app, this);
    e();
    f();
    h();
    this.jdField_a_of_type_Avcu = new avcu(this.app.getCurrentUin());
  }
  
  private void e()
  {
    this.jdField_a_of_type_Andd = new avcx(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Amsu = new avcy(this);
    this.app.addObserver(this.jdField_a_of_type_Amsu);
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
    this.app.addObserver(this.jdField_a_of_type_Andd);
    this.app.addObserver(this.jdField_a_of_type_Amsu);
  }
  
  private void i()
  {
    this.app.addObserver(this.jdField_a_of_type_Avde);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "removeRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.removeObserver(this.jdField_a_of_type_Andd);
    this.app.removeObserver(this.jdField_a_of_type_Amsu);
  }
  
  private void k()
  {
    this.app.removeObserver(this.jdField_a_of_type_Avde);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationRoom a(avcq paramavcq)
  {
    return this.jdField_a_of_type_Avcu.a(paramavcq);
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
      if (!avhg.a(this.app, paramString)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Avdi.a(i, paramInt, paramString);
      return;
      i = 1;
      continue;
      if (paramInt == 1)
      {
        if (!avhg.b(this.app, paramString)) {
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
    if (avhg.a(this.app, paramInt1, paramString))
    {
      bcef.b(null, "CliOper", "", "", "0X800A76C", "0X800A76C", a(paramInt2), 0, "" + paramInt3, "0", "0", "");
      return;
    }
    bcef.b(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (b()) {
      return;
    }
    this.jdField_a_of_type_Avcq = paramLocationRoom.a();
    Object localObject = amrq.a();
    if (!((amrq)localObject).a().contains(this)) {
      ((amrq)localObject).a(this);
    }
    localObject = new LocationHandler.3(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_Avdg.a(this.jdField_a_of_type_Avcq);
    if (bool) {
      a(this.jdField_a_of_type_Avcq.a(), this.jdField_a_of_type_Avcq.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new avcz(this, bool, (Runnable)localObject, localMqqHandler, paramLocationRoom);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new avda(this);
      paramLocationRoom = apua.a(BaseApplicationImpl.getApplication());
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
  
  void a(avcq paramavcq)
  {
    if (a(paramavcq).b()) {
      QQToast.a(this.app.getApp(), 2131693527, 0).a();
    }
  }
  
  void a(avcq paramavcq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + paramavcq + " clientType: " + paramInt);
    }
    a(paramavcq, true);
    this.jdField_a_of_type_Avcu.b(paramavcq, paramInt);
  }
  
  void a(avcq paramavcq, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Avcu.a(paramavcq, paramInt1, paramInt2);
  }
  
  void a(avcq paramavcq, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Avdd != null)
    {
      Pair localPair = this.jdField_a_of_type_Avdd.a();
      if ((localPair != null) && (paramavcq.equals(localPair.first)) && (paramVenue.equals(localPair.second)))
      {
        this.jdField_a_of_type_Avdd.a(paramavcq, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_Avdd = null;
      }
    }
  }
  
  public void a(avcq paramavcq, LocationRoom.Venue paramVenue, avdd paramavdd)
  {
    if ((paramavcq == null) || ((paramVenue == null) && (paramavdd != null)))
    {
      paramavdd.a(paramavcq, paramVenue, 1, false, -1);
      return;
    }
    this.jdField_a_of_type_Avdd = paramavdd;
    this.jdField_a_of_type_Avdl.a(paramavcq, paramVenue);
  }
  
  void a(avcq paramavcq, LocationRoom.Venue paramVenue, List<avco> paramList)
  {
    this.jdField_a_of_type_Avcu.a(paramavcq, paramVenue, paramList);
  }
  
  void a(avcq paramavcq, String paramString)
  {
    if ((a(paramavcq).b()) && (!this.app.getCurrentUin().equals(paramString))) {
      QQToast.a(this.app.getApp(), 2131693525, 0).a();
    }
  }
  
  public void a(avcq paramavcq, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramavcq != null) && (!paramavcq.equals(this.jdField_a_of_type_Avcq))) {}
    for (;;)
    {
      return;
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        ThreadManager.getUIHandler().post(new LocationHandler.7(this, paramavcq, paramBoolean));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. roomKey: " + paramavcq);
      }
      this.jdField_a_of_type_Avcq = null;
      amrq.a().b(this);
      if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
      {
        this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
        g();
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
      }
      this.jdField_a_of_type_Avdg.a();
      QQNotificationManager.getInstance().cancel("LocationHandler", 525);
      try
      {
        paramavcq = avhu.a(this.app);
        if (paramavcq != null)
        {
          paramavcq.a(-1);
          return;
        }
      }
      catch (Throwable paramavcq)
      {
        QLog.e("LocationHandler", 1, "stopLocationSharing: failed. ", paramavcq);
      }
    }
  }
  
  public void a(avcv paramavcv)
  {
    this.jdField_a_of_type_Avcu.b(paramavcv);
  }
  
  public void a(avdc paramavdc)
  {
    try
    {
      this.jdField_a_of_type_Avdc = paramavdc;
      return;
    }
    finally
    {
      paramavdc = finally;
      throw paramavdc;
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
    Object localObject = apua.a(BaseApplicationImpl.getApplication());
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.8(this), ((aqaq)localObject).b());
    if ((((aqaq)localObject).b() <= 0L) || (!b())) {
      return;
    }
    localObject = new NotificationCompat.Builder(this.app.getApp());
    ((NotificationCompat.Builder)localObject).setContentText(this.app.getApp().getString(2131694148)).setWhen(System.currentTimeMillis()).setSmallIcon(2130841439).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.9(this), 3000L);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Avdg.a(paramString, new avdb(this, paramInt, paramString));
  }
  
  void b(avcq paramavcq)
  {
    if (a(paramavcq).b()) {
      QQToast.a(this.app.getApp(), 2131693526, 0).a();
    }
  }
  
  public void b(avcq paramavcq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + paramavcq + " reason: " + paramInt);
    }
    a(paramavcq, false);
    this.jdField_a_of_type_Avcu.a(paramavcq, paramInt);
  }
  
  public void b(avcq paramavcq, LocationRoom.Venue paramVenue, avdd paramavdd)
  {
    if ((paramavcq == null) || ((paramVenue == null) && (paramavdd != null)))
    {
      paramavdd.a(paramavcq, paramVenue, 3, false, -1);
      return;
    }
    this.jdField_a_of_type_Avdd = paramavdd;
    this.jdField_a_of_type_Avdl.b(paramavcq, paramVenue);
  }
  
  public void b(avcv paramavcv)
  {
    this.jdField_a_of_type_Avcu.a(paramavcv);
  }
  
  public void b(avdc paramavdc)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramavdc + " mLocationListener: " + this.jdField_a_of_type_Avdc);
      }
      if (paramavdc == this.jdField_a_of_type_Avdc) {
        this.jdField_a_of_type_Avdc = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Avcq != null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Avcu.a(paramInt, paramString);
  }
  
  public void c(avcq paramavcq)
  {
    avcq localavcq = new avcq(this.jdField_a_of_type_Avdg.a(), this.jdField_a_of_type_Avdg.a());
    if (!localavcq.equals(paramavcq))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + paramavcq + " org roomKey: " + localavcq);
      }
      this.jdField_a_of_type_Avcu.a(localavcq);
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return avdf.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    a(this.jdField_a_of_type_Avcq, true);
    j();
    k();
    this.jdField_a_of_type_Avdj.b();
    this.jdField_a_of_type_Avdg.a();
    this.jdField_a_of_type_Avcu.a();
    afrf.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      this.jdField_a_of_type_Avdi.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Avdg.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Avdj.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd()));
    this.jdField_a_of_type_Avdl.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avcw
 * JD-Core Version:    0.7.0.1
 */