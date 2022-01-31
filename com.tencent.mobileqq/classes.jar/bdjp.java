public class bdjp
{
  private static bdjq a;
  
  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (a == null) {
      a = new bdjq(3, 10L);
    }
    a.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjp
 * JD-Core Version:    0.7.0.1
 */