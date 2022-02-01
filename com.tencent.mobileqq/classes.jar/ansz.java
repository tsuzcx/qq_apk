import java.util.Comparator;

class ansz
  implements Comparator<ansy>
{
  public int a(ansy paramansy1, ansy paramansy2)
  {
    if (paramansy1.b < paramansy2.b) {
      return -1;
    }
    if (paramansy1.b > paramansy2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ansz
 * JD-Core Version:    0.7.0.1
 */