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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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

public class awiz
  extends BusinessHandler
  implements anug
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int = -1;
  private anvi jdField_a_of_type_Anvi;
  private aofu jdField_a_of_type_Aofu;
  private awit jdField_a_of_type_Awit;
  private awix jdField_a_of_type_Awix;
  private volatile awjf jdField_a_of_type_Awjf;
  private awjg jdField_a_of_type_Awjg;
  private awjh jdField_a_of_type_Awjh;
  public awjj a;
  public awjl a;
  public awjm a;
  private awjo jdField_a_of_type_Awjo;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private volatile boolean jdField_a_of_type_Boolean;
  private LatLng jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public awiz(QQAppInterface paramQQAppInterface)
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
  
  public static awiz a(QQAppInterface paramQQAppInterface)
  {
    return (awiz)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LOCATION_HANDLER);
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Awjf != null) {
        this.jdField_a_of_type_Awjf.a(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
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
    this.jdField_a_of_type_Awjl = new awjl(this.app, this);
    this.jdField_a_of_type_Awjj = new awjj(this.app);
    this.jdField_a_of_type_Awjm = new awjm(this.app);
    this.jdField_a_of_type_Awjo = new awjo(this.app);
    this.jdField_a_of_type_Awjh = new awjh(this.app, this);
    e();
    f();
    h();
    this.jdField_a_of_type_Awix = new awix(this.app.getCurrentUin());
  }
  
  private void e()
  {
    this.jdField_a_of_type_Aofu = new awja(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Anvi = new awjb(this);
    this.app.addObserver(this.jdField_a_of_type_Anvi);
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
    this.app.addObserver(this.jdField_a_of_type_Aofu);
    this.app.addObserver(this.jdField_a_of_type_Anvi);
  }
  
  private void i()
  {
    this.app.addObserver(this.jdField_a_of_type_Awjh);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "removeRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.removeObserver(this.jdField_a_of_type_Aofu);
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
  }
  
  private void k()
  {
    this.app.removeObserver(this.jdField_a_of_type_Awjh);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationRoom a(awit paramawit)
  {
    return this.jdField_a_of_type_Awix.a(paramawit);
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
      if (!awnj.a(this.app, paramString)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Awjl.a(i, paramInt, paramString);
      return;
      i = 1;
      continue;
      if (paramInt == 1)
      {
        if (!awnj.b(this.app, paramString)) {
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
    if (awnj.a(this.app, paramInt1, paramString))
    {
      bdla.b(null, "CliOper", "", "", "0X800A76C", "0X800A76C", a(paramInt2), 0, "" + paramInt3, "0", "0", "");
      return;
    }
    bdla.b(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (b()) {
      return;
    }
    this.jdField_a_of_type_Awit = paramLocationRoom.a();
    anue.a().a(this);
    LocationHandler.3 local3 = new LocationHandler.3(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_Awjj.a(this.jdField_a_of_type_Awit);
    if (bool) {
      a(this.jdField_a_of_type_Awit.a(), this.jdField_a_of_type_Awit.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new awjc(this, bool, local3, localMqqHandler, paramLocationRoom);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new awjd(this);
      paramLocationRoom = aqxd.a(BaseApplicationImpl.getApplication());
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
      localMqqHandler.postDelayed(local3, 15000L);
    }
  }
  
  void a(awit paramawit)
  {
    if (a(paramawit).b()) {
      QQToast.a(this.app.getApp(), 2131693708, 0).a();
    }
  }
  
  void a(awit paramawit, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + paramawit + " clientType: " + paramInt);
    }
    a(paramawit, true);
    this.jdField_a_of_type_Awix.b(paramawit, paramInt);
  }
  
  void a(awit paramawit, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Awix.a(paramawit, paramInt1, paramInt2);
  }
  
  void a(awit paramawit, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Awjg != null)
    {
      Pair localPair = this.jdField_a_of_type_Awjg.a();
      if ((localPair != null) && (paramawit.equals(localPair.first)) && (paramVenue.equals(localPair.second)))
      {
        this.jdField_a_of_type_Awjg.a(paramawit, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_Awjg = null;
      }
    }
  }
  
  public void a(awit paramawit, LocationRoom.Venue paramVenue, awjg paramawjg)
  {
    if ((paramawit == null) || ((paramVenue == null) && (paramawjg != null)))
    {
      paramawjg.a(paramawit, paramVenue, 1, false, -1);
      return;
    }
    this.jdField_a_of_type_Awjg = paramawjg;
    this.jdField_a_of_type_Awjo.a(paramawit, paramVenue);
  }
  
  void a(awit paramawit, LocationRoom.Venue paramVenue, List<awir> paramList)
  {
    this.jdField_a_of_type_Awix.a(paramawit, paramVenue, paramList);
  }
  
  void a(awit paramawit, String paramString)
  {
    if ((a(paramawit).b()) && (!this.app.getCurrentUin().equals(paramString))) {
      QQToast.a(this.app.getApp(), 2131693706, 0).a();
    }
  }
  
  public void a(awit paramawit, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramawit != null) && (!paramawit.equals(this.jdField_a_of_type_Awit))) {}
    for (;;)
    {
      return;
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        ThreadManager.getUIHandler().post(new LocationHandler.7(this, paramawit, paramBoolean));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. roomKey: " + paramawit);
      }
      this.jdField_a_of_type_Awit = null;
      anue.a().b(this);
      if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
      {
        this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
        g();
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
      }
      this.jdField_a_of_type_Awjj.a();
      QQNotificationManager.getInstance().cancel("LocationHandler", 525);
      try
      {
        paramawit = awnx.a(this.app);
        if (paramawit != null)
        {
          paramawit.a(-1);
          return;
        }
      }
      catch (Throwable paramawit)
      {
        QLog.e("LocationHandler", 1, "stopLocationSharing: failed. ", paramawit);
      }
    }
  }
  
  public void a(awiy paramawiy)
  {
    this.jdField_a_of_type_Awix.b(paramawiy);
  }
  
  public void a(awjf paramawjf)
  {
    try
    {
      this.jdField_a_of_type_Awjf = paramawjf;
      return;
    }
    finally
    {
      paramawjf = finally;
      throw paramawjf;
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
    Object localObject = aqxd.a(BaseApplicationImpl.getApplication());
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.8(this), ((ardt)localObject).b());
    if ((((ardt)localObject).b() <= 0L) || (!b())) {
      return;
    }
    localObject = new NotificationCompat.Builder(this.app.getApp());
    ((NotificationCompat.Builder)localObject).setContentText(this.app.getApp().getString(2131694346)).setWhen(System.currentTimeMillis()).setSmallIcon(2130841445).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.9(this), 3000L);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Awjj.a(paramString, new awje(this, paramInt, paramString));
  }
  
  void b(awit paramawit)
  {
    if (a(paramawit).b()) {
      QQToast.a(this.app.getApp(), 2131693707, 0).a();
    }
  }
  
  public void b(awit paramawit, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + paramawit + " reason: " + paramInt);
    }
    a(paramawit, false);
    this.jdField_a_of_type_Awix.a(paramawit, paramInt);
  }
  
  public void b(awit paramawit, LocationRoom.Venue paramVenue, awjg paramawjg)
  {
    if ((paramawit == null) || ((paramVenue == null) && (paramawjg != null)))
    {
      paramawjg.a(paramawit, paramVenue, 3, false, -1);
      return;
    }
    this.jdField_a_of_type_Awjg = paramawjg;
    this.jdField_a_of_type_Awjo.b(paramawit, paramVenue);
  }
  
  public void b(awiy paramawiy)
  {
    this.jdField_a_of_type_Awix.a(paramawiy);
  }
  
  public void b(awjf paramawjf)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramawjf + " mLocationListener: " + this.jdField_a_of_type_Awjf);
      }
      if (paramawjf == this.jdField_a_of_type_Awjf) {
        this.jdField_a_of_type_Awjf = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Awit != null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Awix.a(paramInt, paramString);
  }
  
  public void c(awit paramawit)
  {
    awit localawit = new awit(this.jdField_a_of_type_Awjj.a(), this.jdField_a_of_type_Awjj.a());
    if (!localawit.equals(paramawit))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + paramawit + " org roomKey: " + localawit);
      }
      this.jdField_a_of_type_Awix.a(localawit);
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return awji.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    a(this.jdField_a_of_type_Awit, true);
    j();
    k();
    this.jdField_a_of_type_Awjm.b();
    this.jdField_a_of_type_Awjj.a();
    this.jdField_a_of_type_Awix.a();
    agiq.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      this.jdField_a_of_type_Awjl.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Awjj.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Awjm.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd()));
    this.jdField_a_of_type_Awjo.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awiz
 * JD-Core Version:    0.7.0.1
 */