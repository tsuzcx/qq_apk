import java.util.Comparator;
import java.util.Map.Entry;

class bfob
  implements Comparator<Map.Entry<String, bfoc>>
{
  bfob(bfnz parambfnz) {}
  
  public int a(Map.Entry<String, bfoc> paramEntry1, Map.Entry<String, bfoc> paramEntry2)
  {
    long l = ((bfoc)paramEntry2.getValue()).a - ((bfoc)paramEntry1.getValue()).a;
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
 * Qualified Name:     bfob
 * JD-Core Version:    0.7.0.1
 */