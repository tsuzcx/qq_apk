import java.util.Comparator;

final class awis
  implements Comparator<awih>
{
  public int a(awih paramawih1, awih paramawih2)
  {
    long l1 = paramawih1.c();
    long l2 = paramawih2.c();
    if (l1 < l2) {}
    do
    {
      return 1;
      if (l1 > l2) {
        return -1;
      }
      l1 = paramawih1.b();
      l2 = paramawih2.b();
    } while (l1 < l2);
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awis
 * JD-Core Version:    0.7.0.1
 */