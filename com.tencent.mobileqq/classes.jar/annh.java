import java.util.Comparator;

public class annh
  implements Comparator<anni>
{
  private int a;
  
  public annh(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(anni paramanni1, anni paramanni2)
  {
    if (this.a == 2) {
      if (paramanni1.b <= paramanni2.b) {}
    }
    while (paramanni1.a > paramanni2.a)
    {
      return -1;
      if (paramanni1.b < paramanni2.b) {
        return 1;
      }
      return 0;
    }
    if (paramanni1.a < paramanni2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annh
 * JD-Core Version:    0.7.0.1
 */