import java.util.Comparator;
import java.util.Map.Entry;

class azln
  implements Comparator<Map.Entry<String, azlp>>
{
  azln(azlm paramazlm) {}
  
  public int a(Map.Entry<String, azlp> paramEntry1, Map.Entry<String, azlp> paramEntry2)
  {
    float f = ((azlp)paramEntry2.getValue()).a() - ((azlp)paramEntry1.getValue()).a();
    if (f > 0.0F) {
      return 1;
    }
    if (f < 0.0F) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azln
 * JD-Core Version:    0.7.0.1
 */