import java.util.Comparator;
import java.util.Map.Entry;

class bfeo
  implements Comparator<Map.Entry<String, bfep>>
{
  bfeo(bfem parambfem) {}
  
  public int a(Map.Entry<String, bfep> paramEntry1, Map.Entry<String, bfep> paramEntry2)
  {
    long l = ((bfep)paramEntry2.getValue()).a - ((bfep)paramEntry1.getValue()).a;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfeo
 * JD-Core Version:    0.7.0.1
 */