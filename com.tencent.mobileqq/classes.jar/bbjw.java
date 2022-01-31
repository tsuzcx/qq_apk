import java.util.Comparator;
import java.util.Map.Entry;

class bbjw
  implements Comparator<Map.Entry<String, bbjy>>
{
  bbjw(bbjv parambbjv) {}
  
  public int a(Map.Entry<String, bbjy> paramEntry1, Map.Entry<String, bbjy> paramEntry2)
  {
    float f = ((bbjy)paramEntry2.getValue()).a() - ((bbjy)paramEntry1.getValue()).a();
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
 * Qualified Name:     bbjw
 * JD-Core Version:    0.7.0.1
 */