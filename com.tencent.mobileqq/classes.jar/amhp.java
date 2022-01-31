import java.util.Comparator;

public class amhp
  implements Comparator<amhq>
{
  private int a;
  
  public amhp(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(amhq paramamhq1, amhq paramamhq2)
  {
    if (this.a == 2) {
      if (paramamhq1.b <= paramamhq2.b) {}
    }
    while (paramamhq1.a > paramamhq2.a)
    {
      return -1;
      if (paramamhq1.b < paramamhq2.b) {
        return 1;
      }
      return 0;
    }
    if (paramamhq1.a < paramamhq2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhp
 * JD-Core Version:    0.7.0.1
 */