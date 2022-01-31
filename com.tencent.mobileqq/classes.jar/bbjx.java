import java.util.Comparator;
import java.util.Map.Entry;

class bbjx
  implements Comparator<Map.Entry<String, bbjy>>
{
  bbjx(bbjv parambbjv) {}
  
  public int a(Map.Entry<String, bbjy> paramEntry1, Map.Entry<String, bbjy> paramEntry2)
  {
    long l = ((bbjy)paramEntry2.getValue()).a - ((bbjy)paramEntry1.getValue()).a;
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
 * Qualified Name:     bbjx
 * JD-Core Version:    0.7.0.1
 */