import java.util.Comparator;

class bcdd
  implements Comparator<bcdh>
{
  bcdd(bcdc parambcdc) {}
  
  public int a(bcdh parambcdh1, bcdh parambcdh2)
  {
    int j = Long.signum(parambcdh1.b - parambcdh2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(parambcdh1.c - parambcdh2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-parambcdh1.a + parambcdh2.a);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcdd
 * JD-Core Version:    0.7.0.1
 */