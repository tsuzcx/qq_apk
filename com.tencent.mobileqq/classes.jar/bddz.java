import java.util.concurrent.Callable;

class bddz
  implements Callable<Void>
{
  bddz(bddy parambddy) {}
  
  public Void a()
  {
    synchronized (this.a)
    {
      if (bddy.a(this.a) == null) {
        return null;
      }
      bddy.a(this.a);
      if (bddy.a(this.a))
      {
        bddy.b(this.a);
        bddy.a(this.a, 0);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bddz
 * JD-Core Version:    0.7.0.1
 */