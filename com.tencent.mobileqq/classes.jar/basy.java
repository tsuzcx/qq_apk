import java.util.Comparator;

final class basy
  implements Comparator<baso>
{
  public int a(baso parambaso1, baso parambaso2)
  {
    long l1 = parambaso1.c();
    long l2 = parambaso2.c();
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
 * Qualified Name:     basy
 * JD-Core Version:    0.7.0.1
 */