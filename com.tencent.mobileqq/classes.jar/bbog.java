import java.util.Comparator;
import java.util.Map.Entry;

class bbog
  implements Comparator<Map.Entry<String, bboh>>
{
  bbog(bboe parambboe) {}
  
  public int a(Map.Entry<String, bboh> paramEntry1, Map.Entry<String, bboh> paramEntry2)
  {
    long l = ((bboh)paramEntry2.getValue()).a - ((bboh)paramEntry1.getValue()).a;
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
 * Qualified Name:     bbog
 * JD-Core Version:    0.7.0.1
 */