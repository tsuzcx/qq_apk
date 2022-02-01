import java.util.Comparator;

class amyz
  implements Comparator<amyy>
{
  public int a(amyy paramamyy1, amyy paramamyy2)
  {
    if (paramamyy1.b < paramamyy2.b) {
      return -1;
    }
    if (paramamyy1.b > paramamyy2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amyz
 * JD-Core Version:    0.7.0.1
 */