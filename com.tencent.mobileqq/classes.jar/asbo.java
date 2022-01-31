import java.util.Comparator;

class asbo
  implements Comparator<asbc>
{
  public int a(asbc paramasbc1, asbc paramasbc2)
  {
    if (paramasbc1.a >= paramasbc2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asbo
 * JD-Core Version:    0.7.0.1
 */