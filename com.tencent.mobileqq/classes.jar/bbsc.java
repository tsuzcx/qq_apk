import java.util.Comparator;

public class bbsc
  implements Comparator<bbsa>
{
  public int a(bbsa parambbsa1, bbsa parambbsa2)
  {
    if (parambbsa1.b < parambbsa2.b) {
      return 1;
    }
    if (parambbsa1.b == parambbsa2.b) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsc
 * JD-Core Version:    0.7.0.1
 */