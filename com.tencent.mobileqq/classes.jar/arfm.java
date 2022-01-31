import java.util.Comparator;

class arfm
  implements Comparator<arfa>
{
  public int a(arfa paramarfa1, arfa paramarfa2)
  {
    if (paramarfa1.a >= paramarfa2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     arfm
 * JD-Core Version:    0.7.0.1
 */