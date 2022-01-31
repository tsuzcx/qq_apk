import java.util.Comparator;

public class amme
  implements Comparator<ammf>
{
  private int a;
  
  public amme(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(ammf paramammf1, ammf paramammf2)
  {
    if (this.a == 2) {
      if (paramammf1.b <= paramammf2.b) {}
    }
    while (paramammf1.a > paramammf2.a)
    {
      return -1;
      if (paramammf1.b < paramammf2.b) {
        return 1;
      }
      return 0;
    }
    if (paramammf1.a < paramammf2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amme
 * JD-Core Version:    0.7.0.1
 */