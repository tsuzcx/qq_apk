import java.util.Comparator;
import java.util.Map.Entry;

class aykw
  implements Comparator<Map.Entry<String, aykx>>
{
  aykw(ayku paramayku) {}
  
  public int a(Map.Entry<String, aykx> paramEntry1, Map.Entry<String, aykx> paramEntry2)
  {
    long l = ((aykx)paramEntry2.getValue()).a - ((aykx)paramEntry1.getValue()).a;
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aykw
 * JD-Core Version:    0.7.0.1
 */