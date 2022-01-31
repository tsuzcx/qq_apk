import java.util.Comparator;

final class awiu
  implements Comparator<awij>
{
  public int a(awij paramawij1, awij paramawij2)
  {
    long l1 = paramawij1.c();
    long l2 = paramawij2.c();
    if (l1 < l2) {}
    do
    {
      return 1;
      if (l1 > l2) {
        return -1;
      }
      l1 = paramawij1.b();
      l2 = paramawij2.b();
    } while (l1 < l2);
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awiu
 * JD-Core Version:    0.7.0.1
 */