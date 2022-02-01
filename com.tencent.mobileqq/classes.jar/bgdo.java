import java.util.Comparator;

class bgdo
  implements Comparator<bgdp>
{
  public int a(bgdp parambgdp1, bgdp parambgdp2)
  {
    int i = 1;
    if (parambgdp1.a == parambgdp2.a) {
      if (parambgdp1.b == parambgdp2.b) {
        i = 0;
      }
    }
    while (parambgdp1.a > parambgdp2.a)
    {
      do
      {
        return i;
      } while (parambgdp1.b > parambgdp2.b);
      return -1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdo
 * JD-Core Version:    0.7.0.1
 */