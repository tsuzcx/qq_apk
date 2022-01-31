import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.GroupAppUnreadInfo;

public class baff
  implements Manager
{
  private HashMap<Long, bafe> a = new HashMap();
  private HashMap<Long, bafe> b = new HashMap();
  
  public baff()
  {
    this.a.clear();
    this.b.clear();
  }
  
  public bafe a(Long paramLong)
  {
    return (bafe)this.a.get(paramLong);
  }
  
  public void a(long paramLong)
  {
    bafe localbafe = (bafe)this.a.get(Long.valueOf(paramLong));
    if (localbafe != null) {
      localbafe.c(0);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject = (bafe)this.a.get(Long.valueOf(paramLong));
    if (localObject != null) {
      ((bafe)localObject).c(0);
    }
    localObject = (bafe)this.b.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (;;)
    {
      return;
      ((bafe)localObject).a(paramInt);
      if (paramInt == 0)
      {
        localObject = ((bafe)localObject).a().iterator();
        while (((Iterator)localObject).hasNext())
        {
          bafa localbafa = (bafa)((Iterator)localObject).next();
          localbafa.a(localbafa.c());
        }
      }
      else
      {
        localObject = ((bafe)localObject).a().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bafa)((Iterator)localObject).next()).a(1);
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = (bafe)this.a.get(Long.valueOf(paramLong1));
    if (localObject != null) {
      ((bafe)localObject).c(0);
    }
    localObject = (bafe)this.b.get(Long.valueOf(paramLong1));
    if (localObject != null)
    {
      localObject = ((bafe)localObject).a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        bafa localbafa = (bafa)((Iterator)localObject).next();
        if (localbafa.a() == paramLong2) {
          localbafa.a(paramInt);
        }
      }
    }
  }
  
  public void a(bafb parambafb, boolean paramBoolean) {}
  
  public void a(Long paramLong, bafe parambafe)
  {
    Object localObject = (bafe)this.a.get(paramLong);
    if ((localObject != null) && (parambafe != null))
    {
      parambafe.a(((bafe)localObject).b());
      localObject = ((bafe)localObject).a();
      Iterator localIterator1 = parambafe.a().iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label119;
        }
        bafa localbafa1 = (bafa)localIterator1.next();
        Iterator localIterator2 = ((ArrayList)localObject).iterator();
        if (localIterator2.hasNext())
        {
          bafa localbafa2 = (bafa)localIterator2.next();
          if (localbafa1.a() != localbafa2.a()) {
            break;
          }
          localbafa1.b(localbafa2.b());
        }
      }
    }
    label119:
    this.a.put(paramLong, parambafe);
  }
  
  public void a(Long paramLong, List<oidb_0x8c9.GroupAppUnreadInfo> paramList)
  {
    paramLong = (bafe)this.a.get(paramLong);
    if (paramLong == null) {}
    label129:
    for (;;)
    {
      return;
      paramLong.a(paramLong.c() + System.currentTimeMillis());
      paramLong = paramLong.a().iterator();
      for (;;)
      {
        if (!paramLong.hasNext()) {
          break label129;
        }
        bafa localbafa = (bafa)paramLong.next();
        long l1 = localbafa.a();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          oidb_0x8c9.GroupAppUnreadInfo localGroupAppUnreadInfo = (oidb_0x8c9.GroupAppUnreadInfo)localIterator.next();
          long l2 = localGroupAppUnreadInfo.opt_uint64_appid.get();
          int i = localGroupAppUnreadInfo.opt_int32_group_unread_num.get();
          if (l2 != l1) {
            break;
          }
          localbafa.b(i);
        }
      }
    }
  }
  
  public bafe b(Long paramLong)
  {
    return (bafe)this.b.get(paramLong);
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = a(Long.valueOf(paramLong1));
    if (localObject == null) {}
    bafa localbafa;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          localObject = ((bafe)localObject).a();
        } while (localObject == null);
        localObject = ((List)localObject).iterator();
      }
      localbafa = (bafa)((Iterator)localObject).next();
    } while (localbafa.a() != paramLong2);
    localbafa.b(paramInt);
  }
  
  public void b(Long paramLong, bafe parambafe)
  {
    this.b.put(paramLong, parambafe);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baff
 * JD-Core Version:    0.7.0.1
 */