import java.util.Comparator;
import java.util.Map.Entry;

class beot
  implements Comparator<Map.Entry<String, beov>>
{
  beot(beos parambeos) {}
  
  public int a(Map.Entry<String, beov> paramEntry1, Map.Entry<String, beov> paramEntry2)
  {
    float f = ((beov)paramEntry2.getValue()).a() - ((beov)paramEntry1.getValue()).a();
    if (f > 0.0F) {
      return 1;
    }
    if (f < 0.0F) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beot
 * JD-Core Version:    0.7.0.1
 */