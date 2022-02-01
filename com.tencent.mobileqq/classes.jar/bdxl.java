import java.util.Comparator;
import java.util.Map.Entry;

class bdxl
  implements Comparator<Map.Entry<String, bdxm>>
{
  bdxl(bdxj parambdxj) {}
  
  public int a(Map.Entry<String, bdxm> paramEntry1, Map.Entry<String, bdxm> paramEntry2)
  {
    long l = ((bdxm)paramEntry2.getValue()).a - ((bdxm)paramEntry1.getValue()).a;
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
 * Qualified Name:     bdxl
 * JD-Core Version:    0.7.0.1
 */