import java.util.Comparator;

class aofh
  implements Comparator<aofg>
{
  public int a(aofg paramaofg1, aofg paramaofg2)
  {
    if (paramaofg1.b < paramaofg2.b) {
      return -1;
    }
    if (paramaofg1.b > paramaofg2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aofh
 * JD-Core Version:    0.7.0.1
 */