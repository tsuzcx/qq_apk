import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.feed_info;
import NS_UNDEAL_COUNT.single_count;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet.4;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet.5;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.os.MqqHandler;

public class bccx
  extends MSFServlet
  implements bmfh
{
  private static aoou jdField_a_of_type_Aoou;
  private static aopa jdField_a_of_type_Aopa;
  private static LbsDataV2.GpsInfo jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo;
  public static boolean a;
  public static long c;
  public static long d;
  private static long e;
  private static long f;
  private static long g = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
  public long a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QZoneNotifyServlet.5(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b;
  
  public bccx()
  {
    this.jdField_a_of_type_Long = 180000L;
    this.jdField_b_of_type_Long = 5000L;
  }
  
  public static LbsDataV2.GpsInfo a(String paramString)
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = aoor.a(paramString);
    if (localSosoLbsInfo != null) {}
    for (boolean bool = true;; bool = false)
    {
      bmfi.a(bool, paramString);
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getGpsInfo");
      if (localSosoLbsInfo == null) {
        break;
      }
      return LbsDataV2.convertFromSoso(localSosoLbsInfo.a);
    }
    return null;
  }
  
  private MqqHandler a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {}
    try
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QZONE_UNDEALCOUNT", 0);
        localHandlerThread.start();
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
      }
      return this.jdField_a_of_type_MqqOsMqqHandler;
    }
    finally {}
  }
  
  private void a()
  {
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
  }
  
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - e < g) {
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", "[QZ_LBS_MODULE] mIsGettingLocation = , (now - mLastGetLocationTime) ) = " + (l - e) / 1000L + ", so return");
    }
    do
    {
      return;
      e = l;
    } while (jdField_a_of_type_Aoou == null);
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new QZoneNotifyServlet.4());
  }
  
  private static void b(int paramInt)
  {
    if (paramInt == 2)
    {
      g *= 10L;
      return;
    }
    if (paramInt == 0)
    {
      g = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
      return;
    }
    g *= 2L;
  }
  
  private static void b(String paramString)
  {
    if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_Aoou == null))
    {
      jdField_a_of_type_Aoou = new bccy(paramString, false);
      try
      {
        f = System.currentTimeMillis();
        if ((Build.VERSION.SDK_INT < 23) || (BaseApplication.getContext() == null) || (BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0))
        {
          aoor.a(jdField_a_of_type_Aoou);
          return;
        }
        QZLog.w("QZLog", "[QZ_LBS_MODULE]定位有版本或权限限制");
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "[QZ_LBS_MODULE]onCreate startLocation exception " + paramString);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    bmfd.a().a(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (jdField_a_of_type_Aopa != null) {
      SosoInterface.b(jdField_a_of_type_Aopa);
    }
    jdField_a_of_type_Aopa = null;
    if (jdField_a_of_type_Aoou != null) {
      aoor.b(jdField_a_of_type_Aoou);
    }
    jdField_a_of_type_Aoou = null;
    bmfd.a().b(this);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 4, "QZoneNotifyServlet onDestroy" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.getLooper().quit();
    }
    this.jdField_a_of_type_MqqOsMqqHandler = null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = getAppRuntime();
    if (localObject == null) {}
    while (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    d = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onReceive onReceive: " + d);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bcbv.a(paramIntent, paramFromServiceMsg, (QQAppInterface)localObject, this);
      return;
    }
    bcbv.a((QQAppInterface)localObject, paramIntent, paramFromServiceMsg, this);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend.begin.");
    }
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        b("qzone_little_video_enter");
      } while (!"Qzone_Get_NewAndUnread_Count".equals(paramIntent.getAction()));
      localObject1 = getAppRuntime();
    } while ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface)));
    Object localObject1 = (QQAppInterface)localObject1;
    int i = 3;
    int k = paramIntent.getIntExtra("scene", 102);
    int j = paramIntent.getIntExtra("qzone_send_by_time", 4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "QzoneNotifyServlet onSend byTimeType:" + j + ",isBackground_Pause:" + ((QQAppInterface)localObject1).isBackground_Pause);
    }
    long l1;
    if (j == 2)
    {
      i = 2;
      l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "GETFEEDUNREADTYPE_SWITCHTOFORGROUND nowtime: " + l1 + ",lastGetFeedTime:" + c + ",lastGetFeedTime:" + c + "difference: " + (l1 - c));
      }
      if (l1 - c < this.jdField_b_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend.interval time is not enough,schedule task.byTimeType:2");
        }
        a();
        return;
      }
    }
    long l2;
    if (((j == 1) || (j == 4) || (j == 5) || (j == 6) || (j == 7) || (j == 8)) && (((QQAppInterface)localObject1).isBackground_Pause))
    {
      l2 = c;
      l1 = l2;
      if (l2 == 0L) {
        l1 = LocalMultiProcConfig.getLong("qzone_lastgetfeedtime", 0L);
      }
      if (System.currentTimeMillis() - l1 < QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_lastgetfeedtime", 43200000))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend app.isBackground_Pause: " + ((QQAppInterface)localObject1).isBackground_Pause + " not send request,schedule task");
        }
        a();
        return;
      }
    }
    if (j == 3) {
      i = 4;
    }
    for (;;)
    {
      if (j == 1) {
        i = 1;
      }
      if (j == 4) {
        i = 3;
      }
      if (j == 2) {
        i = 2;
      }
      if (j == 5) {
        i = 5;
      }
      if (j == 6) {
        i = 6;
      }
      if (j == 7) {
        i = 7;
      }
      if (j == 8) {
        i = 8;
      }
      for (;;)
      {
        int m = ((QQAppInterface)localObject1).getApp().getResources().getDisplayMetrics().widthPixels;
        int n = ((QQAppInterface)localObject1).getApp().getResources().getDisplayMetrics().heightPixels;
        ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
        ConcurrentHashMap localConcurrentHashMap2 = new ConcurrentHashMap();
        Object localObject2 = (bccv)((QQAppInterface)localObject1).getManager(10);
        Object localObject3;
        if (localObject2 != null)
        {
          paramIntent = ((bccv)localObject2).a;
          if (paramIntent != null)
          {
            localObject3 = bcbv.a(paramIntent);
            int i1 = ((List)localObject3).size();
            j = 0;
            Object localObject4;
            Object localObject5;
            if (j < i1)
            {
              int i2 = ((Integer)((List)localObject3).get(j)).intValue();
              localObject4 = (blvg)((bccv)localObject2).a.get(Integer.valueOf(i2));
              ArrayList localArrayList;
              if (localObject4 != null)
              {
                localObject5 = new single_count(((blvg)localObject4).jdField_a_of_type_Long, (byte)((blvg)localObject4).jdField_a_of_type_Int);
                localArrayList = new ArrayList();
                if ((((blvg)localObject4).jdField_a_of_type_JavaUtilArrayList == null) || (((blvg)localObject4).jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
                  break label765;
                }
              }
              label765:
              for (paramIntent = new feed_host_info(((QZoneCountUserInfo)((blvg)localObject4).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long, "", ((blvg)localObject4).jdField_a_of_type_JavaLangString, null, null, null);; paramIntent = new feed_host_info(0L, "", ((blvg)localObject4).jdField_a_of_type_JavaLangString, null, null, null))
              {
                localArrayList.add(paramIntent);
                localConcurrentHashMap1.put(Integer.valueOf(i2), new count_info((single_count)localObject5, localArrayList, ((blvg)localObject4).jdField_b_of_type_JavaLangString, ((blvg)localObject4).c, ((blvg)localObject4).e, ((blvg)localObject4).f, ((blvg)localObject4).g, ((blvg)localObject4).jdField_b_of_type_Long, ((blvg)localObject4).d));
                j += 1;
                break;
              }
            }
            paramIntent = (blvg)((bccv)localObject2).a.get(Integer.valueOf(56));
            if (paramIntent != null)
            {
              localObject2 = new single_count(paramIntent.jdField_a_of_type_Long, (byte)paramIntent.jdField_a_of_type_Int);
              localObject3 = new ArrayList();
              l2 = 0L;
              l1 = l2;
              if (paramIntent.jdField_a_of_type_JavaUtilArrayList != null)
              {
                l1 = l2;
                if (paramIntent.jdField_a_of_type_JavaUtilArrayList.size() > 0)
                {
                  localObject4 = paramIntent.jdField_a_of_type_JavaUtilArrayList.iterator();
                  l1 = 0L;
                  if (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (QZoneCountUserInfo)((Iterator)localObject4).next();
                    ((ArrayList)localObject3).add(new feed_host_info(((QZoneCountUserInfo)localObject5).jdField_a_of_type_Long, ((QZoneCountUserInfo)localObject5).jdField_a_of_type_JavaLangString, null, ((QZoneCountUserInfo)localObject5).jdField_a_of_type_JavaUtilArrayList, null, null));
                    if ((l1 != 0L) || (localObject5 == null) || (((QZoneCountUserInfo)localObject5).jdField_a_of_type_JavaUtilArrayList == null) || (((QZoneCountUserInfo)localObject5).jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
                      break label1277;
                    }
                    l1 = ((feed_info)((QZoneCountUserInfo)localObject5).jdField_a_of_type_JavaUtilArrayList.get(0)).uOrgFeedTime;
                  }
                }
              }
            }
          }
        }
        label1277:
        for (;;)
        {
          break;
          if ((paramIntent.jdField_b_of_type_Boolean) && (l1 > 0L)) {
            localConcurrentHashMap2.put(Long.valueOf(56L), Long.valueOf(l1));
          }
          localConcurrentHashMap1.put(Integer.valueOf(56), new count_info((single_count)localObject2, (ArrayList)localObject3, paramIntent.jdField_b_of_type_JavaLangString, paramIntent.c, paramIntent.e, paramIntent.f, paramIntent.g, paramIntent.jdField_b_of_type_Long, paramIntent.d));
          paramIntent = LocalMultiProcConfig.getString4Uin("qzone_passive_undeal_readtime", "", ((QQAppInterface)localObject1).getLongAccountUin());
          paramIntent = bcbv.a(Long.valueOf(((QQAppInterface)localObject1).getCurrentAccountUin()).longValue(), null, m, n, i, k, localConcurrentHashMap1, paramIntent, localConcurrentHashMap2);
          if (paramIntent == null)
          {
            paramIntent = new byte[4];
            notifyObserver(null, 1000, false, new Bundle(), ayev.class);
          }
          for (;;)
          {
            a();
            return;
            paramPacket.setTimeout(30000L);
            if (QLog.isDevelopLevel()) {
              QLog.d("NavigatorBar.Q.lebatab.UndealCount.QZoneNotifyServlet", 4, "onSend cmd: " + "SQQzoneSvc." + "getUndealCount" + " iVisitQZoneType: " + i);
            }
            paramPacket.setSSOCommand("SQQzoneSvc." + "getUndealCount");
            paramPacket.putSendData(paramIntent);
            c = System.currentTimeMillis();
            LocalMultiProcConfig.putLong("qzone_lastgetfeedtime", c);
            if (QLog.isColorLevel()) {
              QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend send success,send request time: " + c);
            }
          }
        }
      }
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((!paramString.equals("cmd.pre.getpassivefeeds")) || (paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    int i;
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      i = paramBundle.getInt("param.preget_seqid");
      paramString = getAppRuntime();
    } while ((paramString == null) || (!(paramString instanceof QQAppInterface)));
    paramBundle = Long.valueOf(paramBundle.getLong("param.preget_undealcount", -1L));
    QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "onWebEvent undealcount" + paramBundle);
    bcbv.a((QQAppInterface)paramString, i, paramBundle);
  }
  
  public void service(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("Qzone_Refresh_UI"))
    {
      long l = paramIntent.getLongExtra("notify_type", -1L);
      paramIntent = new Bundle();
      paramIntent.putBoolean("new", true);
      paramIntent.putLong("notify_type", l);
      notifyObserver(null, 1000, true, paramIntent, ayev.class);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebanew", 2, "qzone redtypeinfo:call notify observer");
      }
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccx
 * JD-Core Version:    0.7.0.1
 */