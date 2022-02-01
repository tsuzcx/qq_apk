package com.tencent.mobileqq.app;

public class GVideoObserver
  implements BusinessObserver
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  private static int e;
  
  static
  {
    int i = e;
    e = i + 1;
    a = i;
    i = e;
    e = i + 1;
    b = i;
    i = e;
    e = i + 1;
    c = i;
    i = e;
    e = i + 1;
    d = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != a) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5], (String)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue(), ((Long)paramObject[9]).longValue());
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    a(paramObject);
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramObject.length > 3)
    {
      a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue());
      return;
    }
    a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), false, 0, 0);
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    paramObject = (Object[])paramObject;
    a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  protected void a(Object paramObject) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3) {}
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.GVideoObserver
 * JD-Core Version:    0.7.0.1
 */