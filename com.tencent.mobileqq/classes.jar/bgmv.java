import java.util.concurrent.Callable;

class bgmv
  implements Callable<Void>
{
  bgmv(bgmu parambgmu) {}
  
  public Void a()
  {
    synchronized (this.a)
    {
      if (bgmu.a(this.a) == null) {
        return null;
      }
      bgmu.a(this.a);
      if (bgmu.a(this.a))
      {
        bgmu.b(this.a);
        bgmu.a(this.a, 0);
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmv
 * JD-Core Version:    0.7.0.1
 */