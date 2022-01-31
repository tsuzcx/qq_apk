import java.util.Comparator;

class awma
  implements Comparator<awme>
{
  awma(awlz paramawlz) {}
  
  public int a(awme paramawme1, awme paramawme2)
  {
    int j = Long.signum(paramawme1.b - paramawme2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramawme1.c - paramawme2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-paramawme1.a + paramawme2.a);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awma
 * JD-Core Version:    0.7.0.1
 */