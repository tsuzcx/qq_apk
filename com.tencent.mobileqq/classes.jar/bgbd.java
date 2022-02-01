import java.util.Comparator;

final class bgbd
  implements Comparator<bgbb>
{
  public int a(bgbb parambgbb1, bgbb parambgbb2)
  {
    if (parambgbb1 == parambgbb2) {
      return 0;
    }
    if (parambgbb1 == null) {
      return 1;
    }
    if (parambgbb2 == null) {
      return -1;
    }
    return parambgbb2.c - parambgbb1.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbd
 * JD-Core Version:    0.7.0.1
 */