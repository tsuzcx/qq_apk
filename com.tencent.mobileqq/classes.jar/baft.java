import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.GroupAppUnreadInfo;

public class baft
  implements Manager
{
  private HashMap<Long, bafs> a = new HashMap();
  private HashMap<Long, bafs> b = new HashMap();
  
  public baft()
  {
    this.a.clear();
    this.b.clear();
  }
  
  public bafs a(Long paramLong)
  {
    return (bafs)this.a.get(paramLong);
  }
  
  public void a(long paramLong)
  {
    bafs localbafs = (bafs)this.a.get(Long.valueOf(paramLong));
    if (localbafs != null) {
      localbafs.c(0);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    Object localObject = (bafs)this.a.get(Long.valueOf(paramLong));
    if (localObject != null) {
      ((bafs)localObject).c(0);
    }
    localObject = (bafs)this.b.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (;;)
    {
      return;
      ((bafs)localObject).a(paramInt);
      if (paramInt == 0)
      {
        localObject = ((bafs)localObject).a().iterator();
        while (((Iterator)localObject).hasNext())
        {
          bafo localbafo = (bafo)((Iterator)localObject).next();
          localbafo.a(localbafo.c());
        }
      }
      else
      {
        localObject = ((bafs)localObject).a().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bafo)((Iterator)localObject).next()).a(1);
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = (bafs)this.a.get(Long.valueOf(paramLong1));
    if (localObject != null) {
      ((bafs)localObject).c(0);
    }
    localObject = (bafs)this.b.get(Long.valueOf(paramLong1));
    if (localObject != null)
    {
      localObject = ((bafs)localObject).a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        bafo localbafo = (bafo)((Iterator)localObject).next();
        if (localbafo.a() == paramLong2) {
          localbafo.a(paramInt);
        }
      }
    }
  }
  
  public void a(bafp parambafp, boolean paramBoolean) {}
  
  public void a(Long paramLong, bafs parambafs)
  {
    Object localObject = (bafs)this.a.get(paramLong);
    if ((localObject != null) && (parambafs != null))
    {
      parambafs.a(((bafs)localObject).b());
      localObject = ((bafs)localObject).a();
      Iterator localIterator1 = parambafs.a().iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label119;
        }
        bafo localbafo1 = (bafo)localIterator1.next();
        Iterator localIterator2 = ((ArrayList)localObject).iterator();
        if (localIterator2.hasNext())
        {
          bafo localbafo2 = (bafo)localIterator2.next();
          if (localbafo1.a() != localbafo2.a()) {
            break;
          }
          localbafo1.b(localbafo2.b());
        }
      }
    }
    label119:
    this.a.put(paramLong, parambafs);
  }
  
  public void a(Long paramLong, List<oidb_0x8c9.GroupAppUnreadInfo> paramList)
  {
    paramLong = (bafs)this.a.get(paramLong);
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
        bafo localbafo = (bafo)paramLong.next();
        long l1 = localbafo.a();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          oidb_0x8c9.GroupAppUnreadInfo localGroupAppUnreadInfo = (oidb_0x8c9.GroupAppUnreadInfo)localIterator.next();
          long l2 = localGroupAppUnreadInfo.opt_uint64_appid.get();
          int i = localGroupAppUnreadInfo.opt_int32_group_unread_num.get();
          if (l2 != l1) {
            break;
          }
          localbafo.b(i);
        }
      }
    }
  }
  
  public bafs b(Long paramLong)
  {
    return (bafs)this.b.get(paramLong);
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = a(Long.valueOf(paramLong1));
    if (localObject == null) {}
    bafo localbafo;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          localObject = ((bafs)localObject).a();
        } while (localObject == null);
        localObject = ((List)localObject).iterator();
      }
      localbafo = (bafo)((Iterator)localObject).next();
    } while (localbafo.a() != paramLong2);
    localbafo.b(paramInt);
  }
  
  public void b(Long paramLong, bafs parambafs)
  {
    this.b.put(paramLong, parambafs);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baft
 * JD-Core Version:    0.7.0.1
 */