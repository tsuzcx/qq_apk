import com.tencent.qphone.base.util.QLog;

public class axxt
  implements alpg
{
  protected void a(long paramLong, int paramInt) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2, axsr paramaxsr) {}
  
  protected void b(long paramLong, int paramInt) {}
  
  protected void c(long paramLong, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TransObserver", 2, new Object[] { "onUpdate, type=", Integer.valueOf(paramInt), ", isSuccess=", Boolean.valueOf(paramBoolean) });
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        a(((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (String)paramObject[4], (String)paramObject[5]);
        return;
      }
      c(-1L, -1);
      return;
    case 1: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        paramInt = ((Integer)paramObject[1]).intValue();
        int i = ((Integer)paramObject[2]).intValue();
        if (paramObject[3] != null) {}
        for (paramObject = (axsr)paramObject[3];; paramObject = null)
        {
          a(l, paramInt, i, paramObject);
          return;
        }
      }
      c(-1L, -1);
      return;
    case 2: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        a(((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue());
        return;
      }
      c(-1L, -1);
      return;
    case 3: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        c(((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue());
        return;
      }
      c(-1L, -1);
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      b(((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue());
      return;
    }
    c(-1L, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxt
 * JD-Core Version:    0.7.0.1
 */