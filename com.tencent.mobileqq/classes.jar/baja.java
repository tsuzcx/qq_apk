public class baja
{
  private static bajb a;
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (a == null) {
      a = new bajb(3, 10L);
    }
    a.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baja
 * JD-Core Version:    0.7.0.1
 */