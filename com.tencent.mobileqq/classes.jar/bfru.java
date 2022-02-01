import java.util.Comparator;

public class bfru
  implements Comparator<bfrs>
{
  public int a(bfrs parambfrs1, bfrs parambfrs2)
  {
    if (parambfrs1.b < parambfrs2.b) {
      return 1;
    }
    if (parambfrs1.b == parambfrs2.b) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfru
 * JD-Core Version:    0.7.0.1
 */