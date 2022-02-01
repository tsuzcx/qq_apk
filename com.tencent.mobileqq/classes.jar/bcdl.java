import java.util.Comparator;

class bcdl
  implements Comparator<bcdp>
{
  bcdl(bcdk parambcdk) {}
  
  public int a(bcdp parambcdp1, bcdp parambcdp2)
  {
    int j = Long.signum(parambcdp1.b - parambcdp2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(parambcdp1.c - parambcdp2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-parambcdp1.a + parambcdp2.a);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdl
 * JD-Core Version:    0.7.0.1
 */