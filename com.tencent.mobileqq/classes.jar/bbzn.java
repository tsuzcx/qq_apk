import java.util.Comparator;

final class bbzn
  implements Comparator<bbzd>
{
  public int a(bbzd parambbzd1, bbzd parambbzd2)
  {
    long l1 = parambbzd1.c();
    long l2 = parambbzd2.c();
    if (l1 < l2) {
      return 1;
    }
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzn
 * JD-Core Version:    0.7.0.1
 */