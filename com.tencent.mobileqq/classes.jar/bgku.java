import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg;

public class bgku
  implements anui
{
  public bgku(QQAppInterface paramQQAppInterface) {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt) {}
  
  protected void a(long paramLong, boolean paramBoolean, List<oidb_0xea3.BackMsg> paramList, List<Long> paramList1) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(((Long)((Object[])(Object[])paramObject)[0]).longValue(), paramBoolean);
      return;
    case 2: 
      paramObject = (Object[])paramObject;
      a(((Long)paramObject[0]).longValue(), paramBoolean, ((Integer)paramObject[1]).intValue());
      return;
    case 3: 
      a(((Long)((Object[])(Object[])paramObject)[0]).longValue());
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    if (arrayOfObject[1] != null) {}
    for (paramObject = (List)arrayOfObject[1];; paramObject = null)
    {
      if (arrayOfObject[2] != null) {}
      for (List localList = (List)arrayOfObject[2];; localList = null)
      {
        a(((Long)arrayOfObject[0]).longValue(), paramBoolean, paramObject, localList);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgku
 * JD-Core Version:    0.7.0.1
 */