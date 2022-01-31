package c.t.m.g;

public final class cp
{
  private static cy.a a = null;
  
  public static void a(cy.a parama)
  {
    if (parama == null) {
      a("FC_Log", "set log callback null!");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cp
 * JD-Core Version:    0.7.0.1
 */