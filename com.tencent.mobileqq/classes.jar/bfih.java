import java.util.Comparator;

public class bfih
  implements Comparator<bfif>
{
  public int a(bfif parambfif1, bfif parambfif2)
  {
    if (parambfif1.b < parambfif2.b) {
      return 1;
    }
    if (parambfif1.b == parambfif2.b) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfih
 * JD-Core Version:    0.7.0.1
 */