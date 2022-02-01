import java.util.Comparator;

final class axsm
  implements Comparator<axsn>
{
  public int a(axsn paramaxsn1, axsn paramaxsn2)
  {
    if (paramaxsn1.b < paramaxsn2.b) {
      return -1;
    }
    if (paramaxsn1.b > paramaxsn2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsm
 * JD-Core Version:    0.7.0.1
 */