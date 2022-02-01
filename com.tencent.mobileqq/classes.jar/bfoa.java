import java.util.Comparator;
import java.util.Map.Entry;

class bfoa
  implements Comparator<Map.Entry<String, bfoc>>
{
  bfoa(bfnz parambfnz) {}
  
  public int a(Map.Entry<String, bfoc> paramEntry1, Map.Entry<String, bfoc> paramEntry2)
  {
    float f = ((bfoc)paramEntry2.getValue()).a() - ((bfoc)paramEntry1.getValue()).a();
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
 * Qualified Name:     bfoa
 * JD-Core Version:    0.7.0.1
 */