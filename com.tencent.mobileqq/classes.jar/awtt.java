import java.util.Comparator;

final class awtt
  implements Comparator<awoc>
{
  public int a(awoc paramawoc1, awoc paramawoc2)
  {
    int j = Long.signum(paramawoc2.b() - paramawoc1.b());
    int i = j;
    if (j == 0) {
      i = awts.a(paramawoc1, paramawoc2);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtt
 * JD-Core Version:    0.7.0.1
 */