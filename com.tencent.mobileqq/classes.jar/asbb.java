import java.util.Comparator;

final class asbb
  implements Comparator<asbc>
{
  public int a(asbc paramasbc1, asbc paramasbc2)
  {
    if (paramasbc1.b < paramasbc2.b) {
      return -1;
    }
    if (paramasbc1.b > paramasbc2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asbb
 * JD-Core Version:    0.7.0.1
 */