import java.util.Comparator;

public class aohc
  implements Comparator<aohd>
{
  private int a;
  
  public aohc(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int a(aohd paramaohd1, aohd paramaohd2)
  {
    if (this.a == 2) {
      if (paramaohd1.b <= paramaohd2.b) {}
    }
    while (paramaohd1.a > paramaohd2.a)
    {
      return -1;
      if (paramaohd1.b < paramaohd2.b) {
        return 1;
      }
      return 0;
    }
    if (paramaohd1.a < paramaohd2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aohc
 * JD-Core Version:    0.7.0.1
 */