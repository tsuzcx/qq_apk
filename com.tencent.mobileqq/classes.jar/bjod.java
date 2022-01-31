import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.NetworkState;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class bjod
{
  private static final AtomicInteger a = new AtomicInteger(0);
  
  public static int a()
  {
    try
    {
      int i = a.incrementAndGet();
      if (i > 1000000) {
        a.set(0);
      }
      return i;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    a("QzoneNewService.forwardReport", paramInt, null, 1);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    Object localObject = "";
    if (paramInt1 == 0)
    {
      localObject = new StringBuilder().append("errorCode = ").append(paramInt2).append(", msg = ");
      if (paramString1 == null) {
        break label58;
      }
    }
    for (;;)
    {
      localObject = paramString1;
      a("qzonenewservice.opBox", paramInt1, (String)localObject, 0, 5, paramString2);
      return;
      label58:
      paramString1 = "";
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    a("qzonenewservice.openvip", 1300000 + paramInt, paramString, 1);
  }
  
  public static void a(String paramString)
  {
    a("qzonenewservice.call.music", 0, paramString, 1);
  }
  
  public static void a(String paramString, int paramInt)
  {
    int i = bihe.b();
    a("QZoneAPPInQQ.activiySwitch." + paramString, 0, paramInt, null, i, 0, null);
  }
  
  private static void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, String paramString3)
  {
    if (BaseApplicationImpl.getApplication() == null) {}
    StatisticCollector localStatisticCollector;
    do
    {
      return;
      long l2 = 0L;
      long l1 = l2;
      if (BaseApplicationImpl.getApplication() != null)
      {
        l1 = l2;
        if (BaseApplicationImpl.getApplication().isRuntimeReady())
        {
          l1 = l2;
          if (BaseApplicationImpl.getApplication().getRuntime() != null) {
            l1 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
          }
        }
      }
      localStatisticCollector = StatisticCollector.getInstance();
      Statistic localStatistic = localStatisticCollector.getStatistic();
      localStatistic.setValue(WnsKeys.AppId, Integer.valueOf(localStatisticCollector.getAppid()));
      localStatistic.setValue(WnsKeys.ReleaseVersion, localStatisticCollector.getReleaseVersion());
      localStatistic.setValue(WnsKeys.CommandId, paramString1);
      localStatistic.setValue(WnsKeys.APN, NetworkState.getAPN());
      localStatistic.setValue(WnsKeys.Sequence, Integer.valueOf(a()));
      localStatistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(paramInt1));
      localStatistic.setValue(WnsKeys.ToUIN, Long.valueOf(l1));
      localStatistic.setValue(WnsKeys.Qua, bizf.a());
      localStatistic.setValue(WnsKeys.Build, "4515");
      localStatistic.setValue(WnsKeys.TimeCost, Integer.valueOf(paramInt2));
      if (paramString2 != null) {
        localStatistic.setValue(WnsKeys.Detail, paramString2);
      }
      if (paramInt3 > 0) {
        localStatistic.setValue(WnsKeys.Frequency, Integer.valueOf(paramInt3));
      }
      if (paramInt4 > 0)
      {
        localStatistic.setValue(WnsKeys.DType, Integer.valueOf(paramInt4));
        localStatistic.setValue(WnsKeys.ODetails, paramString3);
      }
      localStatisticCollector.put(localStatistic);
    } while (paramInt3 != 1);
    localStatisticCollector.forceReport();
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    a(paramString1, paramInt1, paramString2, paramInt2, 0, null);
  }
  
  private static void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3)
  {
    if (BaseApplicationImpl.getApplication() == null) {}
    StatisticCollector localStatisticCollector;
    do
    {
      return;
      long l2 = 0L;
      long l1 = l2;
      if (BaseApplicationImpl.getApplication() != null)
      {
        l1 = l2;
        if (BaseApplicationImpl.getApplication().isRuntimeReady())
        {
          l1 = l2;
          if (BaseApplicationImpl.getApplication().getRuntime() != null) {
            l1 = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
          }
        }
      }
      localStatisticCollector = StatisticCollector.getInstance();
      Statistic localStatistic = localStatisticCollector.getStatistic();
      localStatistic.setValue(WnsKeys.AppId, Integer.valueOf(localStatisticCollector.getAppid()));
      localStatistic.setValue(WnsKeys.ReleaseVersion, localStatisticCollector.getReleaseVersion());
      localStatistic.setValue(WnsKeys.CommandId, paramString1);
      localStatistic.setValue(WnsKeys.APN, NetworkState.getAPN());
      localStatistic.setValue(WnsKeys.Sequence, Integer.valueOf(a()));
      localStatistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(paramInt1));
      localStatistic.setValue(WnsKeys.ToUIN, Long.valueOf(l1));
      localStatistic.setValue(WnsKeys.Qua, bizf.a());
      localStatistic.setValue(WnsKeys.Build, "4515");
      if (paramString2 != null) {
        localStatistic.setValue(WnsKeys.Detail, paramString2);
      }
      if (paramInt2 > 0) {
        localStatistic.setValue(WnsKeys.Frequency, Integer.valueOf(paramInt2));
      }
      if (paramInt3 > 0)
      {
        localStatistic.setValue(WnsKeys.DType, Integer.valueOf(paramInt3));
        localStatistic.setValue(WnsKeys.ODetails, paramString3);
      }
      localStatisticCollector.put(localStatistic);
    } while (paramInt2 != 1);
    localStatisticCollector.forceReport();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a("qzonenewservice.refresh", 0, null, i, 1, paramString);
      return;
    }
  }
  
  public static void b(int paramInt, String paramString)
  {
    a("Qzone.FeedVideo.Play", paramInt, paramString, 1);
  }
  
  public static void b(String paramString)
  {
    a("qzonenewservice.to.qzone", 1100003, paramString, 1);
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a("qzonenewservice.refresh.more", 0, null, i, 1, paramString);
      return;
    }
  }
  
  public static void c(int paramInt, String paramString)
  {
    a("wns.internal.crashRelatedServerIP", paramInt, paramString, 1);
  }
  
  public static void c(String paramString)
  {
    a("qzonenewservice.to.qzonewap", 1100006, paramString, 1);
  }
  
  public static void d(int paramInt, String paramString)
  {
    a("QzoneNewService.MusicSdkPlay", paramInt, paramString, 1);
  }
  
  public static void e(int paramInt, String paramString)
  {
    a("Feeds.getStickerGif", paramInt, paramString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjod
 * JD-Core Version:    0.7.0.1
 */