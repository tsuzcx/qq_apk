import java.util.Comparator;
import java.util.Map.Entry;

class azll
  implements Comparator<Map.Entry<String, azln>>
{
  azll(azlk paramazlk) {}
  
  public int a(Map.Entry<String, azln> paramEntry1, Map.Entry<String, azln> paramEntry2)
  {
    float f = ((azln)paramEntry2.getValue()).a() - ((azln)paramEntry1.getValue()).a();
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
 * Qualified Name:     azll
 * JD-Core Version:    0.7.0.1
 */