import java.util.Comparator;

final class ayid
  implements Comparator<ayhs>
{
  public int a(ayhs paramayhs1, ayhs paramayhs2)
  {
    long l1 = paramayhs1.c();
    long l2 = paramayhs2.c();
    if (l1 < l2) {}
    do
    {
      return 1;
      if (l1 > l2) {
        return -1;
      }
      l1 = paramayhs1.b();
      l2 = paramayhs2.b();
    } while (l1 < l2);
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayid
 * JD-Core Version:    0.7.0.1
 */