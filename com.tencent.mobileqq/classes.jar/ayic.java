import java.util.Comparator;

final class ayic
  implements Comparator<ayhs>
{
  public int a(ayhs paramayhs1, ayhs paramayhs2)
  {
    long l1 = paramayhs1.c();
    long l2 = paramayhs2.c();
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
 * Qualified Name:     ayic
 * JD-Core Version:    0.7.0.1
 */