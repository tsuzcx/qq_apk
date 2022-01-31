import java.util.Comparator;

final class bgxm
  implements Comparator<bgxo>
{
  public int a(bgxo parambgxo1, bgxo parambgxo2)
  {
    if (parambgxo1.a) {
      return 1;
    }
    if (parambgxo2.a) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgxm
 * JD-Core Version:    0.7.0.1
 */