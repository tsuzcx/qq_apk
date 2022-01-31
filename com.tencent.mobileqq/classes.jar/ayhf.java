import java.util.Comparator;

class ayhf
  implements Comparator<ayhj>
{
  ayhf(ayhe paramayhe) {}
  
  public int a(ayhj paramayhj1, ayhj paramayhj2)
  {
    int j = Long.signum(paramayhj1.b - paramayhj2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramayhj1.c - paramayhj2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-paramayhj1.a + paramayhj2.a);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhf
 * JD-Core Version:    0.7.0.1
 */