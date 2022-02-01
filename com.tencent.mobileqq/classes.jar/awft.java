import java.util.Comparator;

final class awft
  implements Comparator<awfu>
{
  public int a(awfu paramawfu1, awfu paramawfu2)
  {
    if (paramawfu1.b < paramawfu2.b) {
      return -1;
    }
    if (paramawfu1.b > paramawfu2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awft
 * JD-Core Version:    0.7.0.1
 */