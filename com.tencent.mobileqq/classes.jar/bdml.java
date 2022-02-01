import java.util.Comparator;
import java.util.Map.Entry;

final class bdml
  implements Comparator<Map.Entry<String, Long>>
{
  public int a(Map.Entry<String, Long> paramEntry1, Map.Entry<String, Long> paramEntry2)
  {
    return -((Long)paramEntry1.getValue()).compareTo((Long)paramEntry2.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdml
 * JD-Core Version:    0.7.0.1
 */