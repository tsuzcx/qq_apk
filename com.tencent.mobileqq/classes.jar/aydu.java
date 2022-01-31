import java.util.Comparator;

final class aydu
  implements Comparator<aydj>
{
  public int a(aydj paramaydj1, aydj paramaydj2)
  {
    long l1 = paramaydj1.c();
    long l2 = paramaydj2.c();
    if (l1 < l2) {}
    do
    {
      return 1;
      if (l1 > l2) {
        return -1;
      }
      l1 = paramaydj1.b();
      l2 = paramaydj2.b();
    } while (l1 < l2);
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydu
 * JD-Core Version:    0.7.0.1
 */