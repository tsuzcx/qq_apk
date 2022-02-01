public class aqia
  implements anui
{
  protected void a(boolean paramBoolean1, aqhv paramaqhv, Long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool = false;
    int j = -1;
    switch (paramInt)
    {
    default: 
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    paramObject = null;
    long l = -1L;
    int i;
    if ((arrayOfObject != null) && (arrayOfObject.length == 6))
    {
      paramObject = (aqhv)arrayOfObject[0];
      l = ((Long)arrayOfObject[1]).longValue();
      paramInt = ((Integer)arrayOfObject[2]).intValue();
      i = ((Integer)arrayOfObject[3]).intValue();
      j = ((Integer)arrayOfObject[4]).intValue();
      bool = ((Boolean)arrayOfObject[5]).booleanValue();
    }
    for (;;)
    {
      a(paramBoolean, paramObject, Long.valueOf(l), paramInt, i, j, bool);
      return;
      i = -1;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqia
 * JD-Core Version:    0.7.0.1
 */