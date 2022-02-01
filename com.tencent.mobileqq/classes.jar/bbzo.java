import java.util.Comparator;

final class bbzo
  implements Comparator<bbzd>
{
  public int a(bbzd parambbzd1, bbzd parambbzd2)
  {
    long l1 = parambbzd1.c();
    long l2 = parambbzd2.c();
    if (l1 < l2) {}
    do
    {
      return 1;
      if (l1 > l2) {
        return -1;
      }
      l1 = parambbzd1.b();
      l2 = parambbzd2.b();
    } while (l1 < l2);
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzo
 * JD-Core Version:    0.7.0.1
 */