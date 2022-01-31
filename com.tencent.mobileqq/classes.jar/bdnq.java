import java.util.Comparator;

class bdnq
  implements Comparator<bdnr>
{
  public int a(bdnr parambdnr1, bdnr parambdnr2)
  {
    int i = 1;
    if (parambdnr1.a == parambdnr2.a) {
      if (parambdnr1.b == parambdnr2.b) {
        i = 0;
      }
    }
    while (parambdnr1.a > parambdnr2.a)
    {
      do
      {
        return i;
      } while (parambdnr1.b > parambdnr2.b);
      return -1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnq
 * JD-Core Version:    0.7.0.1
 */