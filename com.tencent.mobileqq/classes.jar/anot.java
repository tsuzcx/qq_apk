import NearbyGroup.RspGetAreaList;
import NearbyGroup.RspGetGroupInArea;
import NearbyGroup.RspGetNearbyGroup;
import NeighborSvc.RespGetNeighbors;
import com.tencent.av.service.LBSInfo;
import java.util.List;
import tencent.im.oidb.cmd0x7f5.cmd0x7f5.GroupInfo;

public class anot
  implements anil
{
  private void a(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (List)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean == true) && (paramObject != null))
    {
      paramObject = (Object[])paramObject;
      a(true, new LBSInfo(String.valueOf(paramObject[0]), String.valueOf(paramObject[1]), String.valueOf(paramObject[2]), String.valueOf(paramObject[3]), String.valueOf(paramObject[4]), String.valueOf(paramObject[5]), String.valueOf(paramObject[6]), String.valueOf(paramObject[7]), ((Integer)paramObject[8]).doubleValue(), ((Integer)paramObject[9]).doubleValue(), ((Integer)paramObject[10]).doubleValue(), (String[])paramObject[11]));
      return;
    }
    a(false, null);
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null)) {
      a(true, (byte[])paramObject);
    }
  }
  
  private void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      paramObject = (Object[])paramObject;
      a(true, ((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue());
      return;
    }
    a(false, 0L, false);
  }
  
  private void e(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (paramObject == null)
      {
        a(true, null);
        return;
      }
      a(true, (RspGetGroupInArea)((Object[])(Object[])paramObject)[0]);
      return;
    }
    a(false, null);
  }
  
  private void f(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (paramObject == null)
      {
        a(true, null, false);
        return;
      }
      paramObject = (Object[])paramObject;
      paramBoolean = ((Boolean)paramObject[0]).booleanValue();
      a(true, (RspGetAreaList)paramObject[1], paramBoolean);
      return;
    }
    a(false, null, false);
  }
  
  private void f(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramBoolean)
    {
      a(true, ((Integer)paramArrayOfObject[0]).intValue(), ((Boolean)paramArrayOfObject[1]).booleanValue());
      return;
    }
    a(false, -1, false);
  }
  
  private void g(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (paramObject == null) {
        return;
      }
      paramObject = (Object[])paramObject;
      a(true, (String)paramObject[0], (RespGetNeighbors)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), 0);
      return;
    }
    a(false, null, null, false, -1);
  }
  
  private void g(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (RspGetNearbyGroup)paramArrayOfObject[2];
    if (paramBoolean)
    {
      a(i, true, bool, paramArrayOfObject);
      return;
    }
    a(i, false, bool, paramArrayOfObject);
  }
  
  private void h(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if (paramBoolean)
    {
      paramObject = (Object[])paramObject;
      a(true, (byte[])paramObject[0], (String)paramObject[1], (String)paramObject[2], (String)paramObject[3]);
      return;
    }
    a(false, (byte[])paramObject, null, null, null);
  }
  
  protected void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, RspGetNearbyGroup paramRspGetNearbyGroup) {}
  
  protected void a(asqy paramasqy, boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt) {}
  
  protected void a(boolean paramBoolean, int paramInt, cmd0x7f5.GroupInfo paramGroupInfo) {}
  
  protected void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, RspGetAreaList paramRspGetAreaList, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, RspGetGroupInArea paramRspGetGroupInArea) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo) {}
  
  protected void a(boolean paramBoolean1, String paramString, RespGetNeighbors paramRespGetNeighbors, boolean paramBoolean2, int paramInt) {}
  
  protected void a(boolean paramBoolean, List<asqy> paramList, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void b(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void c(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void d(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void e(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    default: 
    case 1: 
    case 2: 
    case 8: 
    case 12: 
    case 13: 
    case 14: 
    case 9: 
    case 10: 
    case 11: 
    case 18: 
    case 15: 
    case 16: 
    case 17: 
    case 19: 
    case 25: 
    case 26: 
      do
      {
        return;
        h(paramBoolean, paramObject);
        return;
        g(paramBoolean, paramObject);
        return;
        g(paramBoolean, (Object[])paramObject);
        return;
        f(paramBoolean, paramObject);
        return;
        e(paramBoolean, paramObject);
        return;
        d(paramBoolean, paramObject);
        return;
        a(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
        f(paramBoolean, (Object[])paramObject);
        return;
        c(paramBoolean, paramObject);
        return;
        b(paramBoolean, paramObject);
        return;
        a(paramBoolean, (Object[])paramObject);
        return;
        b(paramBoolean, (Object[])paramObject);
        return;
        c(paramBoolean, (Object[])paramObject);
        return;
        a(paramBoolean, ((Integer)paramObject).intValue());
        return;
        a(paramBoolean, paramObject);
        return;
      } while (paramObject == null);
      paramObject = (Object[])paramObject;
      a((asqy)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 24: 
      d(paramBoolean, (Object[])paramObject);
      return;
    case 27: 
      e(paramBoolean, (Object[])paramObject);
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, ((Integer)paramObject[0]).intValue(), (cmd0x7f5.GroupInfo)paramObject[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anot
 * JD-Core Version:    0.7.0.1
 */