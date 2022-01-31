import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.GroupAppUnreadInfo;

public class bcio
  implements Manager
{
  private HashMap<Long, bcin> a = new HashMap();
  private HashMap<Long, bcin> b = new HashMap();
  
  public bcio()
  {
    this.a.clear();
    this.b.clear();
  }
  
  public bcin a(Long paramLong)
  {
    return (bcin)this.a.get(paramLong);
  }
  
  public void a(long paramLong)
  {
    bcin localbcin = (bcin)this.a.get(Long.valueOf(paramLong));
    if (localbcin != null) {
      localbcin.c(0);
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = (bcin)this.a.get(Long.valueOf(paramLong));
    if (localObject != null) {
      ((bcin)localObject).c(0);
    }
    localObject = (bcin)this.b.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (;;)
    {
      return;
      ((bcin)localObject).a(paramInt);
      if (paramBoolean) {
        ((bcin)localObject).b(paramInt);
      }
      if (paramInt == 0)
      {
        localObject = ((bcin)localObject).a().iterator();
        while (((Iterator)localObject).hasNext())
        {
          bcij localbcij = (bcij)((Iterator)localObject).next();
          localbcij.a(localbcij.c());
        }
      }
      else
      {
        localObject = ((bcin)localObject).a().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bcij)((Iterator)localObject).next()).a(1);
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = (bcin)this.a.get(Long.valueOf(paramLong1));
    if (localObject != null) {
      ((bcin)localObject).c(0);
    }
    localObject = (bcin)this.b.get(Long.valueOf(paramLong1));
    if (localObject != null)
    {
      localObject = ((bcin)localObject).a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        bcij localbcij = (bcij)((Iterator)localObject).next();
        if (localbcij.a() == paramLong2) {
          localbcij.a(paramInt);
        }
      }
    }
  }
  
  public void a(bcik parambcik, boolean paramBoolean) {}
  
  public void a(Long paramLong, bcin parambcin)
  {
    Object localObject = (bcin)this.a.get(paramLong);
    if ((localObject != null) && (parambcin != null))
    {
      parambcin.a(((bcin)localObject).b());
      localObject = ((bcin)localObject).a();
      Iterator localIterator1 = parambcin.a().iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label119;
        }
        bcij localbcij1 = (bcij)localIterator1.next();
        Iterator localIterator2 = ((ArrayList)localObject).iterator();
        if (localIterator2.hasNext())
        {
          bcij localbcij2 = (bcij)localIterator2.next();
          if (localbcij1.a() != localbcij2.a()) {
            break;
          }
          localbcij1.b(localbcij2.b());
        }
      }
    }
    label119:
    this.a.put(paramLong, parambcin);
  }
  
  public void a(Long paramLong, List<oidb_0x8c9.GroupAppUnreadInfo> paramList)
  {
    paramLong = (bcin)this.a.get(paramLong);
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
        bcij localbcij = (bcij)paramLong.next();
        long l1 = localbcij.a();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          oidb_0x8c9.GroupAppUnreadInfo localGroupAppUnreadInfo = (oidb_0x8c9.GroupAppUnreadInfo)localIterator.next();
          long l2 = localGroupAppUnreadInfo.opt_uint64_appid.get();
          int i = localGroupAppUnreadInfo.opt_int32_group_unread_num.get();
          if (l2 != l1) {
            break;
          }
          localbcij.b(i);
        }
      }
    }
  }
  
  public bcin b(Long paramLong)
  {
    return (bcin)this.b.get(paramLong);
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = a(Long.valueOf(paramLong1));
    if (localObject == null) {}
    bcij localbcij;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          localObject = ((bcin)localObject).a();
        } while (localObject == null);
        localObject = ((List)localObject).iterator();
      }
      localbcij = (bcij)((Iterator)localObject).next();
    } while (localbcij.a() != paramLong2);
    localbcij.b(paramInt);
  }
  
  public void b(Long paramLong, bcin parambcin)
  {
    this.b.put(paramLong, parambcin);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcio
 * JD-Core Version:    0.7.0.1
 */