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

public class avwv
  extends anii
  implements anlo
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int = -1;
  private anmu jdField_a_of_type_Anmu;
  private anxg jdField_a_of_type_Anxg;
  private avwp jdField_a_of_type_Avwp;
  private avwt jdField_a_of_type_Avwt;
  private volatile avxb jdField_a_of_type_Avxb;
  private avxc jdField_a_of_type_Avxc;
  private avxd jdField_a_of_type_Avxd;
  public avxf a;
  public avxh a;
  public avxi a;
  private avxk jdField_a_of_type_Avxk;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private volatile boolean jdField_a_of_type_Boolean;
  private LatLng jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public avwv(QQAppInterface paramQQAppInterface)
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
  
  public static avwv a(QQAppInterface paramQQAppInterface)
  {
    return (avwv)paramQQAppInterface.a(164);
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Avxb != null) {
        this.jdField_a_of_type_Avxb.a(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
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
    this.jdField_a_of_type_Avxh = new avxh(this.app, this);
    this.jdField_a_of_type_Avxf = new avxf(this.app);
    this.jdField_a_of_type_Avxi = new avxi(this.app);
    this.jdField_a_of_type_Avxk = new avxk(this.app);
    this.jdField_a_of_type_Avxd = new avxd(this.app, this);
    e();
    f();
    h();
    this.jdField_a_of_type_Avwt = new avwt(this.app.c());
  }
  
  private void e()
  {
    this.jdField_a_of_type_Anxg = new avww(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Anmu = new avwx(this);
    this.app.addObserver(this.jdField_a_of_type_Anmu);
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
    this.app.addObserver(this.jdField_a_of_type_Anxg);
    this.app.addObserver(this.jdField_a_of_type_Anmu);
  }
  
  private void i()
  {
    this.app.addObserver(this.jdField_a_of_type_Avxd);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "removeRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.removeObserver(this.jdField_a_of_type_Anxg);
    this.app.removeObserver(this.jdField_a_of_type_Anmu);
  }
  
  private void k()
  {
    this.app.removeObserver(this.jdField_a_of_type_Avxd);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationRoom a(avwp paramavwp)
  {
    return this.jdField_a_of_type_Avwt.a(paramavwp);
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
      if (!awbi.a(this.app, paramString)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Avxh.a(i, paramInt, paramString);
      return;
      i = 1;
      continue;
      if (paramInt == 1)
      {
        if (!awbi.b(this.app, paramString)) {
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
    if (awbi.a(this.app, paramInt1, paramString))
    {
      bcst.b(null, "CliOper", "", "", "0X800A76C", "0X800A76C", a(paramInt2), 0, "" + paramInt3, "0", "0", "");
      return;
    }
    bcst.b(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (b()) {
      return;
    }
    this.jdField_a_of_type_Avwp = paramLocationRoom.a();
    Object localObject = anlm.a();
    if (!((anlm)localObject).a().contains(this)) {
      ((anlm)localObject).a(this);
    }
    localObject = new LocationHandler.3(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_Avxf.a(this.jdField_a_of_type_Avwp);
    if (bool) {
      a(this.jdField_a_of_type_Avwp.a(), this.jdField_a_of_type_Avwp.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new avwy(this, bool, (Runnable)localObject, localMqqHandler, paramLocationRoom);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new avwz(this);
      paramLocationRoom = aqlj.a(BaseApplicationImpl.getApplication());
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
  
  void a(avwp paramavwp)
  {
    if (a(paramavwp).b()) {
      QQToast.a(this.app.getApp(), 2131693420, 0).a();
    }
  }
  
  void a(avwp paramavwp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + paramavwp + " clientType: " + paramInt);
    }
    a(paramavwp, true);
    this.jdField_a_of_type_Avwt.b(paramavwp, paramInt);
  }
  
  void a(avwp paramavwp, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Avwt.a(paramavwp, paramInt1, paramInt2);
  }
  
  void a(avwp paramavwp, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Avxc != null)
    {
      Pair localPair = this.jdField_a_of_type_Avxc.a();
      if ((localPair != null) && (paramavwp.equals(localPair.first)) && (paramVenue.equals(localPair.second)))
      {
        this.jdField_a_of_type_Avxc.a(paramavwp, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_Avxc = null;
      }
    }
  }
  
  public void a(avwp paramavwp, LocationRoom.Venue paramVenue, avxc paramavxc)
  {
    if ((paramavwp == null) || (paramVenue == null))
    {
      paramavxc.a(paramavwp, paramVenue, 1, false, -1);
      return;
    }
    this.jdField_a_of_type_Avxc = paramavxc;
    this.jdField_a_of_type_Avxk.a(paramavwp, paramVenue);
  }
  
  void a(avwp paramavwp, LocationRoom.Venue paramVenue, List<avwn> paramList)
  {
    this.jdField_a_of_type_Avwt.a(paramavwp, paramVenue, paramList);
  }
  
  void a(avwp paramavwp, String paramString)
  {
    if ((a(paramavwp).b()) && (!this.app.c().equals(paramString))) {
      QQToast.a(this.app.getApp(), 2131693418, 0).a();
    }
  }
  
  public void a(avwp paramavwp, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramavwp != null) && (!paramavwp.equals(this.jdField_a_of_type_Avwp))) {}
    for (;;)
    {
      return;
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        ThreadManager.getUIHandler().post(new LocationHandler.7(this, paramavwp, paramBoolean));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. roomKey: " + paramavwp);
      }
      this.jdField_a_of_type_Avwp = null;
      anlm.a().b(this);
      if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
      {
        this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
        g();
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
      }
      this.jdField_a_of_type_Avxf.a();
      QQNotificationManager.getInstance().cancel("LocationHandler", 525);
      try
      {
        paramavwp = awbw.a(this.app);
        if (paramavwp != null)
        {
          paramavwp.a(-1);
          return;
        }
      }
      catch (Throwable paramavwp)
      {
        QLog.e("LocationHandler", 1, "stopLocationSharing: failed. ", paramavwp);
      }
    }
  }
  
  public void a(avwu paramavwu)
  {
    this.jdField_a_of_type_Avwt.b(paramavwu);
  }
  
  public void a(avxb paramavxb)
  {
    try
    {
      this.jdField_a_of_type_Avxb = paramavxb;
      return;
    }
    finally
    {
      paramavxb = finally;
      throw paramavxb;
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
    Object localObject = aqlj.a(BaseApplicationImpl.getApplication());
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.8(this), ((aqrq)localObject).b());
    if ((((aqrq)localObject).b() <= 0L) || (!b())) {
      return;
    }
    localObject = new NotificationCompat.Builder(this.app.getApp());
    ((NotificationCompat.Builder)localObject).setContentText(this.app.getApp().getString(2131694029)).setWhen(System.currentTimeMillis()).setSmallIcon(2130841393).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.9(this), 3000L);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Avxf.a(paramString, new avxa(this, paramInt, paramString));
  }
  
  void b(avwp paramavwp)
  {
    if (a(paramavwp).b()) {
      QQToast.a(this.app.getApp(), 2131693419, 0).a();
    }
  }
  
  public void b(avwp paramavwp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + paramavwp + " reason: " + paramInt);
    }
    a(paramavwp, false);
    this.jdField_a_of_type_Avwt.a(paramavwp, paramInt);
  }
  
  public void b(avwp paramavwp, LocationRoom.Venue paramVenue, avxc paramavxc)
  {
    if ((paramavwp == null) || (paramVenue == null))
    {
      paramavxc.a(paramavwp, paramVenue, 3, false, -1);
      return;
    }
    this.jdField_a_of_type_Avxc = paramavxc;
    this.jdField_a_of_type_Avxk.b(paramavwp, paramVenue);
  }
  
  public void b(avwu paramavwu)
  {
    this.jdField_a_of_type_Avwt.a(paramavwu);
  }
  
  public void b(avxb paramavxb)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramavxb + " mLocationListener: " + this.jdField_a_of_type_Avxb);
      }
      if (paramavxb == this.jdField_a_of_type_Avxb) {
        this.jdField_a_of_type_Avxb = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Avwp != null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Avwt.a(paramInt, paramString);
  }
  
  public void c(avwp paramavwp)
  {
    avwp localavwp = new avwp(this.jdField_a_of_type_Avxf.a(), this.jdField_a_of_type_Avxf.a());
    if (!localavwp.equals(paramavwp))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + paramavwp + " org roomKey: " + localavwp);
      }
      this.jdField_a_of_type_Avwt.a(localavwp);
    }
  }
  
  protected Class<? extends anil> observerClass()
  {
    return avxe.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    a(this.jdField_a_of_type_Avwp, true);
    j();
    k();
    this.jdField_a_of_type_Avxi.b();
    this.jdField_a_of_type_Avxf.a();
    this.jdField_a_of_type_Avwt.a();
    agmd.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      this.jdField_a_of_type_Avxh.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Avxf.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Avxi.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd()));
    this.jdField_a_of_type_Avxk.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwv
 * JD-Core Version:    0.7.0.1
 */