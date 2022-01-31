import java.util.Comparator;
import java.util.Map.Entry;

class azlm
  implements Comparator<Map.Entry<String, azln>>
{
  azlm(azlk paramazlk) {}
  
  public int a(Map.Entry<String, azln> paramEntry1, Map.Entry<String, azln> paramEntry2)
  {
    long l = ((azln)paramEntry2.getValue()).a - ((azln)paramEntry1.getValue()).a;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlm
 * JD-Core Version:    0.7.0.1
 */