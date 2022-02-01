import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BusinessObserver;

public class amqk
  implements BusinessObserver
{
  protected void a() {}
  
  protected void a(int paramInt, String paramString, long paramLong) {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, float paramFloat) {}
  
  protected void a(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2) {}
  
  protected void a(Session paramSession) {}
  
  protected void a(Session paramSession, float paramFloat) {}
  
  protected void a(Session paramSession, boolean paramBoolean) {}
  
  protected void a(Object paramObject, boolean paramBoolean) {}
  
  protected void a(String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, Long paramLong) {}
  
  protected void a(boolean paramBoolean, Long paramLong, String paramString) {}
  
  protected void b() {}
  
  protected void b(long paramLong1, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong2) {}
  
  protected void b(Session paramSession) {}
  
  protected void b(boolean paramBoolean, long paramLong, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Long localLong;
    switch (paramInt)
    {
    case 13: 
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      a(paramBoolean, (Long)paramObject[0], (String)paramObject[1]);
      return;
    case 2: 
      paramObject = (Object[])paramObject;
      localLong = (Long)paramObject[0];
      b(paramBoolean, ((Long)paramObject[1]).longValue(), (String)paramObject[2]);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      localLong = (Long)paramObject[0];
      a(paramBoolean, ((Long)paramObject[1]).longValue(), (String)paramObject[2]);
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      ((Long)paramObject[0]).longValue();
      a(((Long)paramObject[1]).longValue(), ((Float)paramObject[2]).floatValue());
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      localLong = (Long)paramObject[0];
      a(paramBoolean, ((Long)paramObject[1]).longValue());
      return;
    case 6: 
      paramObject = (Object[])paramObject;
      localLong = (Long)paramObject[0];
      a(((Long)paramObject[1]).longValue(), (String)paramObject[2], ((Byte)paramObject[3]).byteValue(), ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), ((Long)paramObject[6]).longValue());
      return;
    case 7: 
      paramObject = (Object[])paramObject;
      localLong = (Long)paramObject[0];
      b(((Long)paramObject[1]).longValue(), (String)paramObject[2], ((Byte)paramObject[3]).byteValue(), ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), ((Long)paramObject[6]).longValue());
      return;
    case 8: 
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), (String)paramObject[1], ((Long)paramObject[2]).longValue());
      return;
    case 9: 
      a((String)((Object[])(Object[])paramObject)[0]);
      return;
    case 10: 
      a(((Long)((Object[])(Object[])paramObject)[0]).longValue());
      return;
    case 11: 
      a();
      return;
    case 12: 
      b();
      return;
    case 18: 
      a(paramBoolean, (Long)paramObject);
      return;
    case 17: 
      a((Session)paramObject);
      return;
    case 14: 
      b((Session)paramObject);
      return;
    case 15: 
      paramObject = (Object[])paramObject;
      a((Session)paramObject[0], ((Float)paramObject[1]).floatValue());
      return;
    case 16: 
      a((Session)paramObject, paramBoolean);
      return;
    }
    a(paramObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqk
 * JD-Core Version:    0.7.0.1
 */