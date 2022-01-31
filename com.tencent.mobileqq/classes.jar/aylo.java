import java.util.Comparator;

class aylo
  implements Comparator<ayls>
{
  aylo(ayln paramayln) {}
  
  public int a(ayls paramayls1, ayls paramayls2)
  {
    int j = Long.signum(paramayls1.b - paramayls2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramayls1.c - paramayls2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-paramayls1.a + paramayls2.a);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylo
 * JD-Core Version:    0.7.0.1
 */