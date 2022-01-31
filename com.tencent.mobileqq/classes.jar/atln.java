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

public class atln
  extends alko
  implements alnt
{
  private static Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  public static LatLng a;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int = -1;
  private alox jdField_a_of_type_Alox;
  private amab jdField_a_of_type_Amab;
  private atlh jdField_a_of_type_Atlh;
  private atll jdField_a_of_type_Atll;
  private volatile atlt jdField_a_of_type_Atlt;
  private atlu jdField_a_of_type_Atlu;
  private atlv jdField_a_of_type_Atlv;
  public atlx a;
  public atlz a;
  public atma a;
  private atmc jdField_a_of_type_Atmc;
  private TencentDirectionListener jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener;
  private TencentLocationListener jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener;
  private TencentLocationManager jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager;
  private volatile boolean jdField_a_of_type_Boolean;
  private LatLng jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private volatile boolean jdField_b_of_type_Boolean;
  
  public atln(QQAppInterface paramQQAppInterface)
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
  
  public static atln a(QQAppInterface paramQQAppInterface)
  {
    return (atln)paramQQAppInterface.a(164);
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_Atlt != null) {
        this.jdField_a_of_type_Atlt.a(this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, Double.valueOf(this.jdField_a_of_type_Double), paramBoolean);
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
    this.jdField_a_of_type_Atlz = new atlz(this.app, this);
    this.jdField_a_of_type_Atlx = new atlx(this.app);
    this.jdField_a_of_type_Atma = new atma(this.app);
    this.jdField_a_of_type_Atmc = new atmc(this.app);
    this.jdField_a_of_type_Atlv = new atlv(this.app, this);
    e();
    f();
    h();
    this.jdField_a_of_type_Atll = new atll(this.app.c());
  }
  
  private void e()
  {
    this.jdField_a_of_type_Amab = new atlo(this);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Alox = new atlp(this);
    this.app.addObserver(this.jdField_a_of_type_Alox);
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
    this.app.addObserver(this.jdField_a_of_type_Amab);
    this.app.addObserver(this.jdField_a_of_type_Alox);
  }
  
  private void i()
  {
    this.app.addObserver(this.jdField_a_of_type_Atlv);
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, new Object[] { "removeRelationChainObservers: invoked. ", " TAG: ", "LocationHandler" });
    }
    this.app.removeObserver(this.jdField_a_of_type_Amab);
    this.app.removeObserver(this.jdField_a_of_type_Alox);
  }
  
  private void k()
  {
    this.app.removeObserver(this.jdField_a_of_type_Atlv);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LocationRoom a(atlh paramatlh)
  {
    return this.jdField_a_of_type_Atll.a(paramatlh);
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
      if (!atpv.a(this.app, paramString)) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Atlz.a(i, paramInt, paramString);
      return;
      i = 1;
      continue;
      if (paramInt == 1)
      {
        if (!atpv.b(this.app, paramString)) {
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
    if (atpv.a(this.app, paramInt1, paramString))
    {
      azmj.b(null, "CliOper", "", "", "0X800A76C", "0X800A76C", a(paramInt2), 0, "" + paramInt3, "0", "0", "");
      return;
    }
    azmj.b(null, "CliOper", "", "", "0X800A765", "0X800A765", paramInt3, 0, "", "0", "0", "");
  }
  
  public void a(Activity paramActivity, LocationRoom paramLocationRoom)
  {
    if (b()) {
      return;
    }
    this.jdField_a_of_type_Atlh = paramLocationRoom.a();
    Object localObject = alnr.a();
    if (!((alnr)localObject).a().contains(this)) {
      ((alnr)localObject).a(this);
    }
    localObject = new LocationHandler.3(this, new SoftReference(paramActivity));
    MqqHandler localMqqHandler = ThreadManager.getUIHandler();
    boolean bool = this.jdField_a_of_type_Atlx.a(this.jdField_a_of_type_Atlh);
    if (bool) {
      a(this.jdField_a_of_type_Atlh.a(), this.jdField_a_of_type_Atlh.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = TencentLocationManager.getInstance(BaseApplicationImpl.context);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener = new atlq(this, bool, (Runnable)localObject, localMqqHandler, paramLocationRoom);
      this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = new atlr(this);
      paramLocationRoom = aogi.a(BaseApplicationImpl.getApplication());
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
  
  void a(atlh paramatlh)
  {
    if (a(paramatlh).b()) {
      QQToast.a(this.app.getApp(), 2131694130, 0).a();
    }
  }
  
  void a(atlh paramatlh, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyKickOff: invoked. roomKey: " + paramatlh + " clientType: " + paramInt);
    }
    a(paramatlh, true);
    this.jdField_a_of_type_Atll.b(paramatlh, paramInt);
  }
  
  void a(atlh paramatlh, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Atll.a(paramatlh, paramInt1, paramInt2);
  }
  
  void a(atlh paramatlh, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (this.jdField_a_of_type_Atlu != null)
    {
      Pair localPair = this.jdField_a_of_type_Atlu.a();
      if ((localPair != null) && (paramatlh.equals(localPair.first)) && (paramVenue.equals(localPair.second)))
      {
        this.jdField_a_of_type_Atlu.a(paramatlh, paramVenue, paramInt1, paramBoolean, paramInt2);
        this.jdField_a_of_type_Atlu = null;
      }
    }
  }
  
  public void a(atlh paramatlh, LocationRoom.Venue paramVenue, atlu paramatlu)
  {
    if ((paramatlh == null) || (paramVenue == null))
    {
      paramatlu.a(paramatlh, paramVenue, 1, false, -1);
      return;
    }
    this.jdField_a_of_type_Atlu = paramatlu;
    this.jdField_a_of_type_Atmc.a(paramatlh, paramVenue);
  }
  
  void a(atlh paramatlh, LocationRoom.Venue paramVenue, List<atlf> paramList)
  {
    this.jdField_a_of_type_Atll.a(paramatlh, paramVenue, paramList);
  }
  
  void a(atlh paramatlh, String paramString)
  {
    if ((a(paramatlh).b()) && (!this.app.c().equals(paramString))) {
      QQToast.a(this.app.getApp(), 2131694128, 0).a();
    }
  }
  
  public void a(atlh paramatlh, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramatlh != null) && (!paramatlh.equals(this.jdField_a_of_type_Atlh))) {}
    for (;;)
    {
      return;
      if (Looper.getMainLooper() != Looper.myLooper())
      {
        ThreadManager.getUIHandler().post(new LocationHandler.7(this, paramatlh, paramBoolean));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "stopLocationSharing: invoked. roomKey: " + paramatlh);
      }
      this.jdField_a_of_type_Atlh = null;
      alnr.a().b(this);
      if (this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager != null)
      {
        this.jdField_a_of_type_ComTencentMapGeolocationTencentDirectionListener = null;
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationListener);
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.stopDirectionUpdate();
        g();
        this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager = null;
      }
      this.jdField_a_of_type_Atlx.a();
      QQNotificationManager.getInstance().cancel("LocationHandler", 525);
      try
      {
        paramatlh = atqj.a(this.app);
        if (paramatlh != null)
        {
          paramatlh.a(-1);
          return;
        }
      }
      catch (Throwable paramatlh)
      {
        QLog.e("LocationHandler", 1, "stopLocationSharing: failed. ", paramatlh);
      }
    }
  }
  
  public void a(atlm paramatlm)
  {
    this.jdField_a_of_type_Atll.b(paramatlm);
  }
  
  public void a(atlt paramatlt)
  {
    try
    {
      this.jdField_a_of_type_Atlt = paramatlt;
      return;
    }
    finally
    {
      paramatlt = finally;
      throw paramatlt;
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
    Object localObject = aogi.a(BaseApplicationImpl.getApplication());
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.8(this), ((aolq)localObject).b());
    if ((((aolq)localObject).b() <= 0L) || (!b())) {
      return;
    }
    localObject = new NotificationCompat.Builder(this.app.getApp());
    ((NotificationCompat.Builder)localObject).setContentText(this.app.getApp().getString(2131694886)).setWhen(System.currentTimeMillis()).setSmallIcon(2130841131).setAutoCancel(true);
    localObject = ((NotificationCompat.Builder)localObject).build();
    QQNotificationManager.addChannelIfNeed((Notification)localObject, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("LocationHandler", 525, (Notification)localObject);
    jdField_a_of_type_AndroidOsHandler.postDelayed(new LocationHandler.9(this), 3000L);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Atlx.a(paramString, new atls(this, paramInt, paramString));
  }
  
  void b(atlh paramatlh)
  {
    if (a(paramatlh).b()) {
      QQToast.a(this.app.getApp(), 2131694129, 0).a();
    }
  }
  
  public void b(atlh paramatlh, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "notifyRoomClosing: invoked. roomKey: " + paramatlh + " reason: " + paramInt);
    }
    a(paramatlh, false);
    this.jdField_a_of_type_Atll.a(paramatlh, paramInt);
  }
  
  public void b(atlh paramatlh, LocationRoom.Venue paramVenue, atlu paramatlu)
  {
    if ((paramatlh == null) || (paramVenue == null))
    {
      paramatlu.a(paramatlh, paramVenue, 3, false, -1);
      return;
    }
    this.jdField_a_of_type_Atlu = paramatlu;
    this.jdField_a_of_type_Atmc.b(paramatlh, paramVenue);
  }
  
  public void b(atlm paramatlm)
  {
    this.jdField_a_of_type_Atll.a(paramatlm);
  }
  
  public void b(atlt paramatlt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "removeLocationListener: invoked. listener: " + paramatlt + " mLocationListener: " + this.jdField_a_of_type_Atlt);
      }
      if (paramatlt == this.jdField_a_of_type_Atlt) {
        this.jdField_a_of_type_Atlt = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Atlh != null;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Atll.a(paramInt, paramString);
  }
  
  public void c(atlh paramatlh)
  {
    atlh localatlh = new atlh(this.jdField_a_of_type_Atlx.a(), this.jdField_a_of_type_Atlx.a());
    if (!localatlh.equals(paramatlh))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "notifyRoomChanging: invoked. new roomKey: " + paramatlh + " org roomKey: " + localatlh);
      }
      this.jdField_a_of_type_Atll.a(localatlh);
    }
  }
  
  protected Class<? extends alkr> observerClass()
  {
    return atlw.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("LocationHandler", 2, "onDestroy: invoked. ");
    }
    a(this.jdField_a_of_type_Atlh, true);
    j();
    k();
    this.jdField_a_of_type_Atma.b();
    this.jdField_a_of_type_Atlx.a();
    this.jdField_a_of_type_Atll.a();
    afao.a();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QQLBSShareSvc.room_operation".equals(paramFromServiceMsg.getServiceCmd())) {
      this.jdField_a_of_type_Atlz.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("QQLBSShareSvc.report_location".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Atlx.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQLBSShareSvc.room_query".equals(paramFromServiceMsg.getServiceCmd()))
      {
        this.jdField_a_of_type_Atma.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"QQLBSShareSvc.assembly_point_operation".equals(paramFromServiceMsg.getServiceCmd()));
    this.jdField_a_of_type_Atmc.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atln
 * JD-Core Version:    0.7.0.1
 */