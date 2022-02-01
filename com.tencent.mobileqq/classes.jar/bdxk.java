import java.util.Comparator;
import java.util.Map.Entry;

class bdxk
  implements Comparator<Map.Entry<String, bdxm>>
{
  bdxk(bdxj parambdxj) {}
  
  public int a(Map.Entry<String, bdxm> paramEntry1, Map.Entry<String, bdxm> paramEntry2)
  {
    float f = ((bdxm)paramEntry2.getValue()).a() - ((bdxm)paramEntry1.getValue()).a();
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
 * Qualified Name:     bdxk
 * JD-Core Version:    0.7.0.1
 */