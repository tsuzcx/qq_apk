import java.util.Comparator;
import java.util.Map.Entry;

class aykv
  implements Comparator<Map.Entry<String, aykx>>
{
  aykv(ayku paramayku) {}
  
  public int a(Map.Entry<String, aykx> paramEntry1, Map.Entry<String, aykx> paramEntry2)
  {
    float f = ((aykx)paramEntry2.getValue()).a() - ((aykx)paramEntry1.getValue()).a();
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
 * Qualified Name:     aykv
 * JD-Core Version:    0.7.0.1
 */