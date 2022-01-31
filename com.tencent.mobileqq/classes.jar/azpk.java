import java.util.Comparator;

public class azpk
  implements Comparator<azpi>
{
  public int a(azpi paramazpi1, azpi paramazpi2)
  {
    if (paramazpi1.b < paramazpi2.b) {
      return 1;
    }
    if (paramazpi1.b == paramazpi2.b) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azpk
 * JD-Core Version:    0.7.0.1
 */