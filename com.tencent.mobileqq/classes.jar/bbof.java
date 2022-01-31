import java.util.Comparator;
import java.util.Map.Entry;

class bbof
  implements Comparator<Map.Entry<String, bboh>>
{
  bbof(bboe parambboe) {}
  
  public int a(Map.Entry<String, bboh> paramEntry1, Map.Entry<String, bboh> paramEntry2)
  {
    float f = ((bboh)paramEntry2.getValue()).a() - ((bboh)paramEntry1.getValue()).a();
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
 * Qualified Name:     bbof
 * JD-Core Version:    0.7.0.1
 */