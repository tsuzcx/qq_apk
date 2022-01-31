package c.t.m.g;

public final class cy
{
  private static a a = null;
  
  public static void a(a parama)
  {
    if (parama == null) {
      a("CC_Log", "set log callback null!");
    }
    a = parama;
  }
  
  public static final void a(String paramString1, String paramString2)
  {
    if (a()) {
      a.onLog(3, paramString1, paramString2);
    }
  }
  
  public static final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a()) {
      a.onLog(6, paramString1, paramString2, paramThrowable);
    }
  }
  
  private static boolean a()
  {
    return a != null;
  }
  
  public static final void b(String paramString1, String paramString2)
  {
    if (a()) {
      a.onLog(6, paramString1, paramString2);
    }
  }
  
  public static abstract interface a
  {
    public abstract void onLog(int paramInt, String paramString1, String paramString2);
    
    public abstract void onLog(int paramInt, String paramString1, String paramString2, Throwable paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cy
 * JD-Core Version:    0.7.0.1
 */