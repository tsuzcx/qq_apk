import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody;

public class bbfq
  implements ajfe
{
  public void a(int paramInt) {}
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean) {}
  
  public void a(submsgtype0xdd.MsgBody paramMsgBody) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a((submsgtype0xdd.MsgBody)paramObject);
      return;
    case 2: 
      paramObject = (Object[])paramObject;
      a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    }
    a(((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbfq
 * JD-Core Version:    0.7.0.1
 */