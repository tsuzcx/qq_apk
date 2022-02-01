import java.util.Comparator;

public class aoqa
  implements Comparator<aoqb>
{
  private int a;
  
  public aoqa(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(aoqb paramaoqb1, aoqb paramaoqb2)
  {
    if (this.a == 2) {
      if (paramaoqb1.b <= paramaoqb2.b) {}
    }
    while (paramaoqb1.a > paramaoqb2.a)
    {
      return -1;
      if (paramaoqb1.b < paramaoqb2.b) {
        return 1;
      }
      return 0;
    }
    if (paramaoqb1.a < paramaoqb2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqa
 * JD-Core Version:    0.7.0.1
 */