import java.util.Comparator;

final class axls
  implements Comparator<axms>
{
  public int a(axms paramaxms1, axms paramaxms2)
  {
    if (paramaxms1.a < paramaxms2.a) {
      return -1;
    }
    if (paramaxms1.a > paramaxms2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axls
 * JD-Core Version:    0.7.0.1
 */