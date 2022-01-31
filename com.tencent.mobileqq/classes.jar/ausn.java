import java.util.Comparator;

final class ausn
  implements Comparator<auso>
{
  public int a(auso paramauso1, auso paramauso2)
  {
    if (paramauso1.b < paramauso2.b) {
      return -1;
    }
    if (paramauso1.b > paramauso2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausn
 * JD-Core Version:    0.7.0.1
 */