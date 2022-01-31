import java.util.Comparator;

public class azpi
  implements Comparator<azpg>
{
  public int a(azpg paramazpg1, azpg paramazpg2)
  {
    if (paramazpg1.b < paramazpg2.b) {
      return 1;
    }
    if (paramazpg1.b == paramazpg2.b) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azpi
 * JD-Core Version:    0.7.0.1
 */