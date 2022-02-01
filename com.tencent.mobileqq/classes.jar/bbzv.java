import java.util.Comparator;

final class bbzv
  implements Comparator<bbzg>
{
  public int a(bbzg parambbzg1, bbzg parambbzg2)
  {
    long l1 = parambbzg1.c();
    long l2 = parambbzg2.c();
    if (l1 < l2) {}
    do
    {
      return 1;
      if (l1 > l2) {
        return -1;
      }
      l1 = parambbzg1.b();
      l2 = parambbzg2.b();
    } while (l1 < l2);
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzv
 * JD-Core Version:    0.7.0.1
 */