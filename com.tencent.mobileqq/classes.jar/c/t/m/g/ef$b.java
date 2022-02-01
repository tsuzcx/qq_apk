package c.t.m.g;

final class ef$b
  implements Runnable
{
  et a;
  private ea b;
  
  public ef$b(ea paramea)
  {
    this.b = paramea;
  }
  
  public final void run()
  {
    ea localea = this.b;
    et localet = this.a;
    if (localet != null)
    {
      localet.a(fj.c(localea));
      localea.b(localet);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.ef.b
 * JD-Core Version:    0.7.0.1
 */