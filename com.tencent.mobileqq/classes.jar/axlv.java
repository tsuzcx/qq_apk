import java.util.Comparator;

final class axlv
  implements Comparator<axlw>
{
  public int a(axlw paramaxlw1, axlw paramaxlw2)
  {
    if (paramaxlw1.b < paramaxlw2.b) {
      return -1;
    }
    if (paramaxlw1.b > paramaxlw2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axlv
 * JD-Core Version:    0.7.0.1
 */