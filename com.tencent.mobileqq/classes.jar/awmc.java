import java.util.Comparator;

class awmc
  implements Comparator<awmg>
{
  awmc(awmb paramawmb) {}
  
  public int a(awmg paramawmg1, awmg paramawmg2)
  {
    int j = Long.signum(paramawmg1.b - paramawmg2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramawmg1.c - paramawmg2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-paramawmg1.a + paramawmg2.a);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmc
 * JD-Core Version:    0.7.0.1
 */