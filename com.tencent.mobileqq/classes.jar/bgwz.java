import java.util.Comparator;

class bgwz
  implements Comparator<bgxa>
{
  public int a(bgxa parambgxa1, bgxa parambgxa2)
  {
    int i = 1;
    if (parambgxa1.a == parambgxa2.a) {
      if (parambgxa1.b == parambgxa2.b) {
        i = 0;
      }
    }
    while (parambgxa1.a > parambgxa2.a)
    {
      do
      {
        return i;
      } while (parambgxa1.b > parambgxa2.b);
      return -1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwz
 * JD-Core Version:    0.7.0.1
 */