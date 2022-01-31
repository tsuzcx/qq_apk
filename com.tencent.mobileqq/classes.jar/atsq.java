import java.util.Comparator;

class atsq
  implements Comparator<atse>
{
  public int a(atse paramatse1, atse paramatse2)
  {
    if (paramatse1.a >= paramatse2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsq
 * JD-Core Version:    0.7.0.1
 */