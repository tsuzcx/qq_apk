import java.util.Comparator;

class bhmf
  implements Comparator<bhmg>
{
  public int a(bhmg parambhmg1, bhmg parambhmg2)
  {
    int i = 1;
    if (parambhmg1.a == parambhmg2.a) {
      if (parambhmg1.b == parambhmg2.b) {
        i = 0;
      }
    }
    while (parambhmg1.a > parambhmg2.a)
    {
      do
      {
        return i;
      } while (parambhmg1.b > parambhmg2.b);
      return -1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmf
 * JD-Core Version:    0.7.0.1
 */