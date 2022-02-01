import java.util.Comparator;
import java.util.Map.Entry;

class beou
  implements Comparator<Map.Entry<String, beov>>
{
  beou(beos parambeos) {}
  
  public int a(Map.Entry<String, beov> paramEntry1, Map.Entry<String, beov> paramEntry2)
  {
    long l = ((beov)paramEntry2.getValue()).a - ((beov)paramEntry1.getValue()).a;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beou
 * JD-Core Version:    0.7.0.1
 */