import java.util.Comparator;

final class bhju
  implements Comparator<bhjs>
{
  public int a(bhjs parambhjs1, bhjs parambhjs2)
  {
    if (parambhjs1 == parambhjs2) {
      return 0;
    }
    if (parambhjs1 == null) {
      return 1;
    }
    if (parambhjs2 == null) {
      return -1;
    }
    return parambhjs2.c - parambhjs1.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhju
 * JD-Core Version:    0.7.0.1
 */