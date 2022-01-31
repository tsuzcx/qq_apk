import java.util.Comparator;

final class aviz
  implements Comparator<avio>
{
  public int a(avio paramavio1, avio paramavio2)
  {
    long l1 = paramavio1.c();
    long l2 = paramavio2.c();
    if (l1 < l2) {}
    do
    {
      return 1;
      if (l1 > l2) {
        return -1;
      }
      l1 = paramavio1.b();
      l2 = paramavio2.b();
    } while (l1 < l2);
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aviz
 * JD-Core Version:    0.7.0.1
 */