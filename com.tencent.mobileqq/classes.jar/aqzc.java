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

public class aqzc
  extends ajfb
  implements ajid
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int = -1;
  private ajjh jdField_a_of_type_Ajjh;
  private ajuc jdField_a_of_type_Ajuc;
  private aqyw jdField_a_of_type_Aqyw;
  private aqza jdField_a_of_type_Aqza;
  private volatile aqzi jdField_a_of_type_Aqzi;
  private aqzj jdField_a_of_type_Aqzj;
  private aqzk jdField_a_of_type_Aqzk;
  public aqzm a;
  public aqzo a;
  public aqzp a;
  private aqzr jdField_a_of_type_Aqzr;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private volatile boolean jdField_a_of_type_Boolean;
  private LatLng jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public aqzc(QQAppInterface paramQQAppInterface)
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
  
  public static aqzc a(QQAppInterface paramQQAppInterface)
  {
    return (aqzc)paramQQAppInterface.a(164);
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Aqzi != null) {
        this.jdField_a_of_type_Aqzi.a(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
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
    this.jdField_a_of_type_Aqzo = new aqzo(this.app, this);
    this.jdField_a_of_type_Aqzm = new aqzm(this.app);
    this.jdField_a_of_type_Aqzp = new aqzp(this.app);
    this.jdField_a_of_type_Aqzr = new aqzr(this.app);
    this.jdField_a_of_type_Aqzk = new aqzk(this.app, this);
    e();
    f();
    h();
    this.jdField_a_of_type_Aqza = new aqza(this.app.c());
  }
  
  private void e()
  {
    this.jdField_a_of_type_Ajuc = new aqzd(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Ajjh = new aqze(this);
    this.app.addObserver(this.jdField_a_of_type_Ajjh);
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
    this.app.addObserver(this.jdField_a_of_type_Ajuc);
    this.app.addObserver(this.jdField_a_of_type_Ajjh);
  }
  
  private void i()
  {
    this.app.addObserver(this.jdField_a_of_type_Aqzk);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "removeRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.removeObserver(this.jdField_a_of_type_Ajuc);
    this.app.removeObserver(this.jdField_a_of_type_Ajjh);
  }
  
  private void k()
  {
    this.app.removeObserver(this.jdField_a_of_type_Aqzk);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationRoom a(aqyw paramaqyw)
  {
    return this.jdField_a_of_type_Aqza.a(paramaqyw);
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
      if (!ardf.a(this.app, paramString)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqzo.a(i, paramInt, paramString);
      return;
      i = 1;
      continue;
      if (paramInt == 1)
      {
        if (!ardf.b(this.app, paramString)) {
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
    if (ardf.a(this.app, paramInt1, paramString))
    {
      awqx.b(null, "CliOper", "", "", "0X800A76C", "0X800A76C", a(paramInt2), 0, "" + paramInt3, "0", "0", "");
      return;
    }
    awqx.b(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (b()) {
      return;
    }
    this.jdField_a_of_type_Aqyw = paramLocationRoom.a();
    Object localObject = ajib.a();
    if (!((ajib)localObject).a().contains(this)) {
      ((ajib)localObject).a(this);
    }
    localObject = new LocationHandler.3(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_Aqzm.a(this.jdField_a_of_type_Aqyw);
    if (bool) {
      a(this.jdField_a_of_type_Aqyw.a(), this.jdField_a_of_type_Aqyw.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new aqzf(this, bool, (Runnable)localObject, localMqqHandler, paramLocationRoom);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new aqzg(this);
      paramLocationRoom = alzv.a(BaseApplicationImpl.getApplication());
      int i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.requestLocationUpdates(TencentLocationRequest.create().setInterval(paramLocationRoom.a()), this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      if (i != 0)
      {
        QLog.e("LocationHandler", 1, "[LocationManager] requestLocationUpdates: invoked. error: " + i);
        bbmy.a(BaseApplicationImpl.context, "地图定位系统初始化失败，请稍后重试", 0).a();
        if (paramActivity != null) {
          paramActivity.finish();
        }
      }
      i = this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.startDirectionUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener, Looper.myLooper());
      if (i == 0) {
        break;
      }
      QLog.e("LocationHandler", 1, "[LocationManager] startDirectionUpdates: invoked. error: " + i);
      bbmy.a(BaseApplicationImpl.context, 1, "方向箭头暂不可用", 0).a();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "[LocationManager] startLocationUpdate: invoked.  add over time runnable");
      }
      localMqqHandler.postDelayed((Runnable)localObject, 15000L);
    }
  }
  
  void a(aqyw paramaqyw)
  {
    if (a(paramaqyw).b()) {
      bbmy.a(this.app.getApp(), 2131628372, 0).a();
    }
  }
  
  void a(aqyw paramaqyw, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + paramaqyw + " clientType: " + paramInt);
    }
    a(paramaqyw, true);
    this.jdField_a_of_type_Aqza.b(paramaqyw, paramInt);
  }
  
  void a(aqyw paramaqyw, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aqza.a(paramaqyw, paramInt1, paramInt2);
  }
  
  void a(aqyw paramaqyw, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Aqzj != null)
    {
      Pair localPair = this.jdField_a_of_type_Aqzj.a();
      if ((localPair != null) && (paramaqyw.equals(localPair.first)) && (paramVenue.equals(localPair.second)))
      {
        this.jdField_a_of_type_Aqzj.a(paramaqyw, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_Aqzj = null;
      }
    }
  }
  
  public void a(aqyw paramaqyw, LocationRoom.Venue paramVenue, aqzj paramaqzj)
  {
    if ((paramaqyw == null) || (paramVenue == null))
    {
      paramaqzj.a(paramaqyw, paramVenue, 1, false, -1);
      return;
    }
    this.jdField_a_of_type_Aqzj = paramaqzj;
    this.jdField_a_of_type_Aqzr.a(paramaqyw, paramVenue);
  }
  
  void a(aqyw paramaqyw, LocationRoom.Venue paramVenue, List<aqyu> paramList)
  {
    this.jdField_a_of_type_Aqza.a(paramaqyw, paramVenue, paramList);
  }
  
  void a(aqyw paramaqyw, String paramString)
  {
    if ((a(paramaqyw).b()) && (!this.app.c().equals(paramString))) {
      bbmy.a(this.app.getApp(), 2131628370, 0).a();
    }
  }
  
  public void a(aqyw paramaqyw, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramaqyw != null) && (!paramaqyw.equals(this.jdField_a_of_type_Aqyw))) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      ThreadManager.getUIHandler().post(new LocationHandler.7(this, paramaqyw, paramBoolean));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. roomKey: " + paramaqyw);
    }
    this.jdField_a_of_type_Aqyw = null;
    ajib.a().b(this);
    if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
      g();
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
    }
    this.jdField_a_of_type_Aqzm.a();
    QQNotificationManager.getInstance().cancel("LocationHandler", 525);
    ardn.a(this.app).a(-1);
  }
  
  public void a(aqzb paramaqzb)
  {
    this.jdField_a_of_type_Aqza.b(paramaqzb);
  }
  
  public void a(aqzi paramaqzi)
  {
    try
    {
      this.jdField_a_of_type_Aqzi = paramaqzi;
      return;
    }
    finally
    {
      paramaqzi = finally;
      throw paramaqzi;
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
    Object localObject = alzv.a(BaseApplicationImpl.getApplication());
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.8(this), ((ameh)localObject).b());
    if ((((ameh)localObject).b() <= 0L) || (!b())) {
      return;
    }
    localObject = new NotificationCompat.Builder(this.app.getApp());
    ((NotificationCompat.Builder)localObject).setContentText(this.app.getApp().getString(2131629063)).setWhen(System.currentTimeMillis()).setSmallIcon(2130840949).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.9(this), 3000L);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Aqzm.a(paramString, new aqzh(this, paramInt, paramString));
  }
  
  void b(aqyw paramaqyw)
  {
    if (a(paramaqyw).b()) {
      bbmy.a(this.app.getApp(), 2131628371, 0).a();
    }
  }
  
  public void b(aqyw paramaqyw, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + paramaqyw + " reason: " + paramInt);
    }
    a(paramaqyw, false);
    this.jdField_a_of_type_Aqza.a(paramaqyw, paramInt);
  }
  
  public void b(aqyw paramaqyw, LocationRoom.Venue paramVenue, aqzj paramaqzj)
  {
    if ((paramaqyw == null) || (paramVenue == null))
    {
      paramaqzj.a(paramaqyw, paramVenue, 3, false, -1);
      return;
    }
    this.jdField_a_of_type_Aqzj = paramaqzj;
    this.jdField_a_of_type_Aqzr.b(paramaqyw, paramVenue);
  }
  
  public void b(aqzb paramaqzb)
  {
    this.jdField_a_of_type_Aqza.a(paramaqzb);
  }
  
  public void b(aqzi paramaqzi)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramaqzi + " mLocationListener: " + this.jdField_a_of_type_Aqzi);
      }
      if (paramaqzi == this.jdField_a_of_type_Aqzi) {
        this.jdField_a_of_type_Aqzi = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Aqyw != null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Aqza.a(paramInt, paramString);
  }
  
  public void c(aqyw paramaqyw)
  {
    aqyw localaqyw = new aqyw(this.jdField_a_of_type_Aqzm.a(), this.jdField_a_of_type_Aqzm.a());
    if (!localaqyw.equals(paramaqyw))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + paramaqyw + " org roomKey: " + localaqyw);
      }
      this.jdField_a_of_type_Aqza.a(localaqyw);
    }
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return aqzl.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    a(this.jdField_a_of_type_Aqyw, true);
    j();
    k();
    this.jdField_a_of_type_Aqzp.b();
    this.jdField_a_of_type_Aqzm.a();
    this.jdField_a_of_type_Aqza.a();
    acxj.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      this.jdField_a_of_type_Aqzo.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Aqzm.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Aqzp.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd()));
    this.jdField_a_of_type_Aqzr.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqzc
 * JD-Core Version:    0.7.0.1
 */