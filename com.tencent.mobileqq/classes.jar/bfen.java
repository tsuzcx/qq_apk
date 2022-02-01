import java.util.Comparator;
import java.util.Map.Entry;

class bfen
  implements Comparator<Map.Entry<String, bfep>>
{
  bfen(bfem parambfem) {}
  
  public int a(Map.Entry<String, bfep> paramEntry1, Map.Entry<String, bfep> paramEntry2)
  {
    float f = ((bfep)paramEntry2.getValue()).a() - ((bfep)paramEntry1.getValue()).a();
    if (f > 0.0F) {
      return 1;
    }
    if (f < 0.0F) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfen
 * JD-Core Version:    0.7.0.1
 */