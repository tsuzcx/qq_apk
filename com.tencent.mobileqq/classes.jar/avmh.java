import java.util.Comparator;

class avmh
  implements Comparator<avml>
{
  avmh(avmg paramavmg) {}
  
  public int a(avml paramavml1, avml paramavml2)
  {
    int j = Long.signum(paramavml1.b - paramavml2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramavml1.c - paramavml2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-paramavml1.a + paramavml2.a);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmh
 * JD-Core Version:    0.7.0.1
 */