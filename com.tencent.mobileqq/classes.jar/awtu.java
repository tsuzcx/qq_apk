import java.util.Comparator;

final class awtu
  implements Comparator<awoc>
{
  public int a(awoc paramawoc1, awoc paramawoc2)
  {
    int j = Long.signum(paramawoc2.b() - paramawoc1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramawoc2.a() - paramawoc1.a());
    }
    j = i;
    if (i == 0) {
      j = awts.a(paramawoc1, paramawoc2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtu
 * JD-Core Version:    0.7.0.1
 */