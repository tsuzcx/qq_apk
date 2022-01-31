package c.t.m.g;

final class eg$b
  implements Runnable
{
  eu a;
  private ea b;
  
  public eg$b(ea paramea)
  {
    this.b = paramea;
  }
  
  public final void run()
  {
    ea localea = this.b;
    eu localeu = this.a;
    if (localeu != null)
    {
      localeu.a(fj.c(localea));
      localea.b(localeu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.eg.b
 * JD-Core Version:    0.7.0.1
 */