import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/onlinestatus/IntervalChecker;", "", "()V", "statusIdTimePairMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/onlinestatus/TimePair;", "Lkotlin/collections/HashMap;", "destroy", "", "expired", "", "statusId", "getInterval", "", "setInterval", "interval", "updateTime", "time", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class azhj
{
  private final HashMap<Integer, azis> a = new HashMap();
  
  public final long a(int paramInt)
  {
    azis localazis = (azis)this.a.get(Integer.valueOf(paramInt));
    if (localazis == null) {
      return 0L;
    }
    return localazis.a();
  }
  
  public final void a()
  {
    this.a.clear();
  }
  
  public final void a(int paramInt, long paramLong)
  {
    azis localazis = (azis)this.a.get(Integer.valueOf(paramInt));
    if (localazis == null)
    {
      localazis = new azis(0L, paramLong);
      ((Map)this.a).put(Integer.valueOf(paramInt), localazis);
      if (QLog.isColorLevel()) {
        QLog.d("IntervalChecker", 2, new Object[] { "updateTime: called. ", "newTimePair: " + localazis });
      }
    }
    do
    {
      return;
      localazis.b(paramLong);
      ((Map)this.a).put(Integer.valueOf(paramInt), localazis);
    } while (!QLog.isColorLevel());
    QLog.d("IntervalChecker", 2, new Object[] { "updateTime: called. ", "timePair: " + localazis });
  }
  
  public final boolean a(int paramInt)
  {
    azis localazis = (azis)this.a.get(Integer.valueOf(paramInt));
    if (localazis == null) {
      if (QLog.isColorLevel()) {
        QLog.d("IntervalChecker", 2, new Object[] { "expired: called. not stored （如果未存储时间间隔，默认放行，不过期） ", "statusId: " + paramInt });
      }
    }
    do
    {
      return true;
      if (localazis.a() > 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("IntervalChecker", 2, new Object[] { "expired: called. interval not set.（如果未存储时间间隔，默认放行，不过期） ", "statusId: " + paramInt });
    return true;
    if (NetConnInfoCenter.getServerTime() - localazis.b() > localazis.a()) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("IntervalChecker", 2, new Object[] { "expired: called. ", "expired: " + bool + "  statusId: " + paramInt + "  timePair: " + localazis });
      }
      return bool;
    }
  }
  
  public final void b(int paramInt, long paramLong)
  {
    azis localazis = (azis)this.a.get(Integer.valueOf(paramInt));
    if (localazis == null)
    {
      localazis = new azis(paramLong, 0L);
      ((Map)this.a).put(Integer.valueOf(paramInt), localazis);
      return;
    }
    localazis.a(paramLong);
    ((Map)this.a).put(Integer.valueOf(paramInt), localazis);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhj
 * JD-Core Version:    0.7.0.1
 */