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

public class awpq
  extends anud
  implements anxk
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int = -1;
  private anyu jdField_a_of_type_Anyu;
  private aojs jdField_a_of_type_Aojs;
  private awpk jdField_a_of_type_Awpk;
  private awpo jdField_a_of_type_Awpo;
  private volatile awpw jdField_a_of_type_Awpw;
  private awpx jdField_a_of_type_Awpx;
  private awpy jdField_a_of_type_Awpy;
  public awqa a;
  public awqc a;
  public awqd a;
  private awqf jdField_a_of_type_Awqf;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private volatile boolean jdField_a_of_type_Boolean;
  private LatLng jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public awpq(QQAppInterface paramQQAppInterface)
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
  
  public static awpq a(QQAppInterface paramQQAppInterface)
  {
    return (awpq)paramQQAppInterface.a(164);
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Awpw != null) {
        this.jdField_a_of_type_Awpw.a(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
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
    this.jdField_a_of_type_Awqc = new awqc(this.app, this);
    this.jdField_a_of_type_Awqa = new awqa(this.app);
    this.jdField_a_of_type_Awqd = new awqd(this.app);
    this.jdField_a_of_type_Awqf = new awqf(this.app);
    this.jdField_a_of_type_Awpy = new awpy(this.app, this);
    e();
    f();
    h();
    this.jdField_a_of_type_Awpo = new awpo(this.app.c());
  }
  
  private void e()
  {
    this.jdField_a_of_type_Aojs = new awpr(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Anyu = new awps(this);
    this.app.addObserver(this.jdField_a_of_type_Anyu);
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
    this.app.addObserver(this.jdField_a_of_type_Aojs);
    this.app.addObserver(this.jdField_a_of_type_Anyu);
  }
  
  private void i()
  {
    this.app.addObserver(this.jdField_a_of_type_Awpy);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "removeRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.removeObserver(this.jdField_a_of_type_Aojs);
    this.app.removeObserver(this.jdField_a_of_type_Anyu);
  }
  
  private void k()
  {
    this.app.removeObserver(this.jdField_a_of_type_Awpy);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationRoom a(awpk paramawpk)
  {
    return this.jdField_a_of_type_Awpo.a(paramawpk);
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
      if (!awua.a(this.app, paramString)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Awqc.a(i, paramInt, paramString);
      return;
      i = 1;
      continue;
      if (paramInt == 1)
      {
        if (!awua.b(this.app, paramString)) {
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
    if (awua.a(this.app, paramInt1, paramString))
    {
      bdll.b(null, "CliOper", "", "", "0X800A76C", "0X800A76C", a(paramInt2), 0, "" + paramInt3, "0", "0", "");
      return;
    }
    bdll.b(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (b()) {
      return;
    }
    this.jdField_a_of_type_Awpk = paramLocationRoom.a();
    Object localObject = anxi.a();
    if (!((anxi)localObject).a().contains(this)) {
      ((anxi)localObject).a(this);
    }
    localObject = new LocationHandler.3(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_Awqa.a(this.jdField_a_of_type_Awpk);
    if (bool) {
      a(this.jdField_a_of_type_Awpk.a(), this.jdField_a_of_type_Awpk.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new awpt(this, bool, (Runnable)localObject, localMqqHandler, paramLocationRoom);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new awpu(this);
      paramLocationRoom = aram.a(BaseApplicationImpl.getApplication());
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
  
  void a(awpk paramawpk)
  {
    if (a(paramawpk).b()) {
      QQToast.a(this.app.getApp(), 2131693432, 0).a();
    }
  }
  
  void a(awpk paramawpk, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + paramawpk + " clientType: " + paramInt);
    }
    a(paramawpk, true);
    this.jdField_a_of_type_Awpo.b(paramawpk, paramInt);
  }
  
  void a(awpk paramawpk, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Awpo.a(paramawpk, paramInt1, paramInt2);
  }
  
  void a(awpk paramawpk, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Awpx != null)
    {
      Pair localPair = this.jdField_a_of_type_Awpx.a();
      if ((localPair != null) && (paramawpk.equals(localPair.first)) && (paramVenue.equals(localPair.second)))
      {
        this.jdField_a_of_type_Awpx.a(paramawpk, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_Awpx = null;
      }
    }
  }
  
  public void a(awpk paramawpk, LocationRoom.Venue paramVenue, awpx paramawpx)
  {
    if ((paramawpk == null) || (paramVenue == null))
    {
      paramawpx.a(paramawpk, paramVenue, 1, false, -1);
      return;
    }
    this.jdField_a_of_type_Awpx = paramawpx;
    this.jdField_a_of_type_Awqf.a(paramawpk, paramVenue);
  }
  
  void a(awpk paramawpk, LocationRoom.Venue paramVenue, List<awpi> paramList)
  {
    this.jdField_a_of_type_Awpo.a(paramawpk, paramVenue, paramList);
  }
  
  void a(awpk paramawpk, String paramString)
  {
    if ((a(paramawpk).b()) && (!this.app.c().equals(paramString))) {
      QQToast.a(this.app.getApp(), 2131693430, 0).a();
    }
  }
  
  public void a(awpk paramawpk, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramawpk != null) && (!paramawpk.equals(this.jdField_a_of_type_Awpk))) {}
    for (;;)
    {
      return;
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        ThreadManager.getUIHandler().post(new LocationHandler.7(this, paramawpk, paramBoolean));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. roomKey: " + paramawpk);
      }
      this.jdField_a_of_type_Awpk = null;
      anxi.a().b(this);
      if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
      {
        this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
        g();
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
      }
      this.jdField_a_of_type_Awqa.a();
      QQNotificationManager.getInstance().cancel("LocationHandler", 525);
      try
      {
        paramawpk = awuo.a(this.app);
        if (paramawpk != null)
        {
          paramawpk.a(-1);
          return;
        }
      }
      catch (Throwable paramawpk)
      {
        QLog.e("LocationHandler", 1, "stopLocationSharing: failed. ", paramawpk);
      }
    }
  }
  
  public void a(awpp paramawpp)
  {
    this.jdField_a_of_type_Awpo.b(paramawpp);
  }
  
  public void a(awpw paramawpw)
  {
    try
    {
      this.jdField_a_of_type_Awpw = paramawpw;
      return;
    }
    finally
    {
      paramawpw = finally;
      throw paramawpw;
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
    Object localObject = aram.a(BaseApplicationImpl.getApplication());
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.8(this), ((arha)localObject).b());
    if ((((arha)localObject).b() <= 0L) || (!b())) {
      return;
    }
    localObject = new NotificationCompat.Builder(this.app.getApp());
    ((NotificationCompat.Builder)localObject).setContentText(this.app.getApp().getString(2131694046)).setWhen(System.currentTimeMillis()).setSmallIcon(2130841403).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.9(this), 3000L);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Awqa.a(paramString, new awpv(this, paramInt, paramString));
  }
  
  void b(awpk paramawpk)
  {
    if (a(paramawpk).b()) {
      QQToast.a(this.app.getApp(), 2131693431, 0).a();
    }
  }
  
  public void b(awpk paramawpk, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + paramawpk + " reason: " + paramInt);
    }
    a(paramawpk, false);
    this.jdField_a_of_type_Awpo.a(paramawpk, paramInt);
  }
  
  public void b(awpk paramawpk, LocationRoom.Venue paramVenue, awpx paramawpx)
  {
    if ((paramawpk == null) || (paramVenue == null))
    {
      paramawpx.a(paramawpk, paramVenue, 3, false, -1);
      return;
    }
    this.jdField_a_of_type_Awpx = paramawpx;
    this.jdField_a_of_type_Awqf.b(paramawpk, paramVenue);
  }
  
  public void b(awpp paramawpp)
  {
    this.jdField_a_of_type_Awpo.a(paramawpp);
  }
  
  public void b(awpw paramawpw)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramawpw + " mLocationListener: " + this.jdField_a_of_type_Awpw);
      }
      if (paramawpw == this.jdField_a_of_type_Awpw) {
        this.jdField_a_of_type_Awpw = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Awpk != null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Awpo.a(paramInt, paramString);
  }
  
  public void c(awpk paramawpk)
  {
    awpk localawpk = new awpk(this.jdField_a_of_type_Awqa.a(), this.jdField_a_of_type_Awqa.a());
    if (!localawpk.equals(paramawpk))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + paramawpk + " org roomKey: " + localawpk);
      }
      this.jdField_a_of_type_Awpo.a(localawpk);
    }
  }
  
  protected Class<? extends anui> observerClass()
  {
    return awpz.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    a(this.jdField_a_of_type_Awpk, true);
    j();
    k();
    this.jdField_a_of_type_Awqd.b();
    this.jdField_a_of_type_Awqa.a();
    this.jdField_a_of_type_Awpo.a();
    agvf.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      this.jdField_a_of_type_Awqc.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Awqa.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Awqd.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd()));
    this.jdField_a_of_type_Awqf.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpq
 * JD-Core Version:    0.7.0.1
 */