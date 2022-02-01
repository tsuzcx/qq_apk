import com.tencent.av.service.LBSInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.pb.now.ilive_feeds_near_anchor.NearAnchorInfo;
import com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend.QueryRspItem;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.RspBody;

public class amxe
  implements BusinessObserver
{
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (Object[])paramObject;
    } while (localObject.length < 4);
    int i = ((Integer)localObject[0]).intValue();
    if ((localObject[1] instanceof oidb_0x8dd.RspBody)) {}
    for (paramObject = (oidb_0x8dd.RspBody)localObject[1];; paramObject = null)
    {
      if ((localObject[2] instanceof ToServiceMsg)) {}
      for (ToServiceMsg localToServiceMsg = (ToServiceMsg)localObject[2];; localToServiceMsg = null)
      {
        if ((localObject[3] instanceof List)) {}
        for (localObject = (List)localObject[3];; localObject = null)
        {
          if (paramInt == 1)
          {
            b(paramBoolean, i, paramObject, localToServiceMsg, (List)localObject);
            return;
          }
          a(paramBoolean, i, paramObject, localToServiceMsg, (List)localObject);
          return;
        }
      }
    }
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      a((List)((Object[])(Object[])paramObject)[0]);
    }
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
    }
  }
  
  private void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramBoolean) && (paramArrayOfObject != null))
    {
      b(true, (NearbyMyTabCard)paramArrayOfObject[0]);
      return;
    }
    b(false, null);
  }
  
  private void b(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 3);
    a((FromServiceMsg)paramObject[0], (ToServiceMsg)paramObject[1], (Object[])paramObject[2]);
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      b(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
    }
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      a(paramBoolean, (List)((Object[])(Object[])paramObject)[0]);
    }
  }
  
  private void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
    }
  }
  
  private void e(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue(), (String)paramObject[9], (String)paramObject[10], (String)paramObject[11]);
    }
  }
  
  private void f(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), ((Integer)paramObject[7]).intValue(), (String)paramObject[8]);
    }
  }
  
  private void g(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      a(((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), ((Integer)paramObject[6]).intValue(), (String)paramObject[7]);
    }
  }
  
  private void h(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean == true) && (paramObject != null))
    {
      paramObject = (Object[])paramObject;
      a(true, new LBSInfo(String.valueOf(paramObject[0]), String.valueOf(paramObject[1]), String.valueOf(paramObject[2]), String.valueOf(paramObject[3]), String.valueOf(paramObject[4]), String.valueOf(paramObject[5]), String.valueOf(paramObject[6]), String.valueOf(paramObject[7]), ((Integer)paramObject[8]).doubleValue(), ((Integer)paramObject[9]).doubleValue(), ((Integer)paramObject[10]).doubleValue(), (String[])paramObject[11]));
      return;
    }
    a(false, null);
  }
  
  private void i(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null)) {
      a(true, (byte[])paramObject);
    }
  }
  
  private void j(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Object[])))
    {
      a(paramBoolean, (NearbyMyTabCard)((Object[])(Object[])paramObject)[0]);
      return;
    }
    a(false, null);
  }
  
  protected void a() {}
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString) {}
  
  protected void a(FromServiceMsg paramFromServiceMsg, ToServiceMsg paramToServiceMsg, Object paramObject) {}
  
  public void a(List<nearbyPeopleRecommend.QueryRspItem> paramList) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, String paramString1, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean, int paramInt, oidb_0x8dd.RspBody paramRspBody, ToServiceMsg paramToServiceMsg, List<Object> paramList) {}
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo) {}
  
  protected void a(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void a(boolean paramBoolean, String paramString1, List<awoe> paramList, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void a(boolean paramBoolean1, ArrayList<StrangerInfo> paramArrayList, byte[] paramArrayOfByte, int paramInt, long paramLong1, String paramString, boolean paramBoolean2, long paramLong2, long paramLong3) {}
  
  protected void a(boolean paramBoolean, List<ilive_feeds_near_anchor.NearAnchorInfo> paramList) {}
  
  protected void a(boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void b() {}
  
  protected void b(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void b(boolean paramBoolean, int paramInt, oidb_0x8dd.RspBody paramRspBody, ToServiceMsg paramToServiceMsg, List<Object> paramList) {}
  
  public void b(boolean paramBoolean, NearbyMyTabCard paramNearbyMyTabCard) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 2: 
    case 7: 
    case 14: 
    default: 
      return;
    case 15: 
      b(paramObject);
      return;
    case 1: 
    case 13: 
      a(paramInt, paramBoolean, paramObject);
      return;
    case 12: 
      a();
      return;
    case 3: 
      j(paramBoolean, paramObject);
      return;
    case 4: 
      a(paramBoolean, (Object[])paramObject);
      return;
    case 5: 
      i(paramBoolean, paramObject);
      return;
    case 6: 
      h(paramBoolean, paramObject);
      return;
    case 8: 
      g(paramBoolean, paramObject);
      return;
    case 9: 
      f(paramBoolean, paramObject);
      return;
    case 10: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], (List)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
      return;
    case 11: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (ArrayList)paramObject[0], (byte[])paramObject[1], ((Integer)paramObject[2]).intValue(), ((Long)paramObject[3]).longValue(), (String)paramObject[4], ((Boolean)paramObject[5]).booleanValue(), ((Long)paramObject[6]).longValue(), ((Long)paramObject[7]).longValue());
      return;
    case 16: 
      e(paramBoolean, paramObject);
      return;
    case 17: 
      a(paramBoolean, paramObject);
      return;
    case 18: 
      b(paramBoolean, paramObject);
      return;
    case 19: 
      c(paramBoolean, paramObject);
      return;
    case 20: 
      b();
      return;
    case 21: 
      d(paramBoolean, paramObject);
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxe
 * JD-Core Version:    0.7.0.1
 */