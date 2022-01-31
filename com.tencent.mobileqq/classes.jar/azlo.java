import java.util.Comparator;
import java.util.Map.Entry;

class azlo
  implements Comparator<Map.Entry<String, azlp>>
{
  azlo(azlm paramazlm) {}
  
  public int a(Map.Entry<String, azlp> paramEntry1, Map.Entry<String, azlp> paramEntry2)
  {
    long l = ((azlp)paramEntry2.getValue()).a - ((azlp)paramEntry1.getValue()).a;
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
 * Qualified Name:     azlo
 * JD-Core Version:    0.7.0.1
 */