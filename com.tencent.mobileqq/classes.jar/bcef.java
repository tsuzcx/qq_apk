import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.GroupAppUnreadInfo;

public class bcef
  implements Manager
{
  private HashMap<Long, bcee> a = new HashMap();
  private HashMap<Long, bcee> b = new HashMap();
  
  public bcef()
  {
    this.a.clear();
    this.b.clear();
  }
  
  public bcee a(Long paramLong)
  {
    return (bcee)this.a.get(paramLong);
  }
  
  public void a(long paramLong)
  {
    bcee localbcee = (bcee)this.a.get(Long.valueOf(paramLong));
    if (localbcee != null) {
      localbcee.c(0);
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = (bcee)this.a.get(Long.valueOf(paramLong));
    if (localObject != null) {
      ((bcee)localObject).c(0);
    }
    localObject = (bcee)this.b.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (;;)
    {
      return;
      ((bcee)localObject).a(paramInt);
      if (paramBoolean) {
        ((bcee)localObject).b(paramInt);
      }
      if (paramInt == 0)
      {
        localObject = ((bcee)localObject).a().iterator();
        while (((Iterator)localObject).hasNext())
        {
          bcea localbcea = (bcea)((Iterator)localObject).next();
          localbcea.a(localbcea.c());
        }
      }
      else
      {
        localObject = ((bcee)localObject).a().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((bcea)((Iterator)localObject).next()).a(1);
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = (bcee)this.a.get(Long.valueOf(paramLong1));
    if (localObject != null) {
      ((bcee)localObject).c(0);
    }
    localObject = (bcee)this.b.get(Long.valueOf(paramLong1));
    if (localObject != null)
    {
      localObject = ((bcee)localObject).a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        bcea localbcea = (bcea)((Iterator)localObject).next();
        if (localbcea.a() == paramLong2) {
          localbcea.a(paramInt);
        }
      }
    }
  }
  
  public void a(bceb parambceb, boolean paramBoolean) {}
  
  public void a(Long paramLong, bcee parambcee)
  {
    Object localObject = (bcee)this.a.get(paramLong);
    if ((localObject != null) && (parambcee != null))
    {
      parambcee.a(((bcee)localObject).b());
      localObject = ((bcee)localObject).a();
      Iterator localIterator1 = parambcee.a().iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label119;
        }
        bcea localbcea1 = (bcea)localIterator1.next();
        Iterator localIterator2 = ((ArrayList)localObject).iterator();
        if (localIterator2.hasNext())
        {
          bcea localbcea2 = (bcea)localIterator2.next();
          if (localbcea1.a() != localbcea2.a()) {
            break;
          }
          localbcea1.b(localbcea2.b());
        }
      }
    }
    label119:
    this.a.put(paramLong, parambcee);
  }
  
  public void a(Long paramLong, List<oidb_0x8c9.GroupAppUnreadInfo> paramList)
  {
    paramLong = (bcee)this.a.get(paramLong);
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
        bcea localbcea = (bcea)paramLong.next();
        long l1 = localbcea.a();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          oidb_0x8c9.GroupAppUnreadInfo localGroupAppUnreadInfo = (oidb_0x8c9.GroupAppUnreadInfo)localIterator.next();
          long l2 = localGroupAppUnreadInfo.opt_uint64_appid.get();
          int i = localGroupAppUnreadInfo.opt_int32_group_unread_num.get();
          if (l2 != l1) {
            break;
          }
          localbcea.b(i);
        }
      }
    }
  }
  
  public bcee b(Long paramLong)
  {
    return (bcee)this.b.get(paramLong);
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = a(Long.valueOf(paramLong1));
    if (localObject == null) {}
    bcea localbcea;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          localObject = ((bcee)localObject).a();
        } while (localObject == null);
        localObject = ((List)localObject).iterator();
      }
      localbcea = (bcea)((Iterator)localObject).next();
    } while (localbcea.a() != paramLong2);
    localbcea.b(paramInt);
  }
  
  public void b(Long paramLong, bcee parambcee)
  {
    this.b.put(paramLong, parambcee);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcef
 * JD-Core Version:    0.7.0.1
 */