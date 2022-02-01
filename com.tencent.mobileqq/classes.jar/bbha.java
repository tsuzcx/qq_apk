import java.util.Comparator;

final class bbha
  implements Comparator<bbgm>
{
  public int a(bbgm parambbgm1, bbgm parambbgm2)
  {
    long l1 = parambbgm1.c();
    long l2 = parambbgm2.c();
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
 * Qualified Name:     bbha
 * JD-Core Version:    0.7.0.1
 */