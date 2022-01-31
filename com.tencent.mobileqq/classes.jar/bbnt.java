import java.util.Comparator;

public class bbnt
  implements Comparator<bbnr>
{
  public int a(bbnr parambbnr1, bbnr parambbnr2)
  {
    if (parambbnr1.b < parambbnr2.b) {
      return 1;
    }
    if (parambbnr1.b == parambbnr2.b) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbnt
 * JD-Core Version:    0.7.0.1
 */