import java.util.Comparator;

final class awfq
  implements Comparator<awgq>
{
  public int a(awgq paramawgq1, awgq paramawgq2)
  {
    if (paramawgq1.a < paramawgq2.a) {
      return -1;
    }
    if (paramawgq1.a > paramawgq2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfq
 * JD-Core Version:    0.7.0.1
 */