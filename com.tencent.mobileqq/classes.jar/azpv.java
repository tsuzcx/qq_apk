import java.util.Comparator;

class azpv
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (azps)paramObject1;
    paramObject2 = (azps)paramObject2;
    if (paramObject1.b > paramObject2.b) {
      return -1;
    }
    if (paramObject1.b < paramObject2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpv
 * JD-Core Version:    0.7.0.1
 */