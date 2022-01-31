import com.tencent.mobileqq.app.QQAppInterface;

public class bafg
  implements ajtg
{
  protected QQAppInterface a;
  
  public bafg(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void a(long paramLong1, boolean paramBoolean, long paramLong2, int paramInt) {}
  
  protected void b(long paramLong, boolean paramBoolean) {}
  
  protected void c(long paramLong, boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      b(((Long)((Object[])(Object[])paramObject)[0]).longValue(), paramBoolean);
      return;
    case 1: 
      a(((Long)((Object[])(Object[])paramObject)[0]).longValue(), paramBoolean);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      a(((Long)paramObject[0]).longValue(), paramBoolean, ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      a(((Long)paramObject[0]).longValue(), paramBoolean, ((Integer)paramObject[1]).intValue());
      return;
    case 5: 
      c(((Long)((Object[])(Object[])paramObject)[0]).longValue(), paramBoolean);
      return;
    }
    a(((Long)((Object[])(Object[])paramObject)[0]).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bafg
 * JD-Core Version:    0.7.0.1
 */