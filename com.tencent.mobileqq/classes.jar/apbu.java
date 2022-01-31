public final class apbu
  implements Comparable<apbu>
{
  public long a;
  public final apbt a;
  
  public int a(apbu paramapbu)
  {
    if (paramapbu == null) {}
    do
    {
      return 1;
      if (this.a > paramapbu.a) {
        return -1;
      }
    } while (this.a < paramapbu.a);
    return 0;
  }
  
  public String toString()
  {
    return "mRemainTime:" + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbu
 * JD-Core Version:    0.7.0.1
 */