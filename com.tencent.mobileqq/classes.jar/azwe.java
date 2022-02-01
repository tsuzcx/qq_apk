import java.util.Comparator;
import java.util.Map.Entry;

class azwe
  implements Comparator<Map.Entry<String, Long>>
{
  azwe(azwd paramazwd) {}
  
  public int a(Map.Entry<String, Long> paramEntry1, Map.Entry<String, Long> paramEntry2)
  {
    return ((Long)paramEntry2.getValue()).compareTo((Long)paramEntry1.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwe
 * JD-Core Version:    0.7.0.1
 */