import java.util.Comparator;

final class azcf
  implements Comparator<azch>
{
  public int a(azch paramazch1, azch paramazch2)
  {
    if (paramazch1.b < paramazch2.b) {
      return -1;
    }
    if (paramazch1.b > paramazch2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azcf
 * JD-Core Version:    0.7.0.1
 */