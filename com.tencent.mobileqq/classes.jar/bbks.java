import java.util.Comparator;

class bbks
  implements Comparator<bbkw>
{
  bbks(bbkr parambbkr) {}
  
  public int a(bbkw parambbkw1, bbkw parambbkw2)
  {
    int j = Long.signum(parambbkw1.b - parambbkw2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(parambbkw1.c - parambbkw2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-parambbkw1.a + parambbkw2.a);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbks
 * JD-Core Version:    0.7.0.1
 */