package com.tencent.mobileqq.app;

public class RegisterProxySvcPackObserver
  implements BusinessObserver
{
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, long paramLong1, long paramLong2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramObject == null);
        paramObject = (Object[])paramObject;
        a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
        return;
      } while (paramObject == null);
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 3);
    a(((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RegisterProxySvcPackObserver
 * JD-Core Version:    0.7.0.1
 */