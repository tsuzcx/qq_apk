import java.util.Comparator;

final class asxf
  implements Comparator<asxg>
{
  public int a(asxg paramasxg1, asxg paramasxg2)
  {
    if (paramasxg1.b < paramasxg2.b) {
      return -1;
    }
    if (paramasxg1.b > paramasxg2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asxf
 * JD-Core Version:    0.7.0.1
 */