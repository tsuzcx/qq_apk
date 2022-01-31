import java.util.Comparator;

class axud
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (axtz)paramObject1;
    paramObject2 = (axtz)paramObject2;
    if (paramObject1.a > paramObject2.a) {
      return -1;
    }
    if (paramObject1.a < paramObject2.a) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axud
 * JD-Core Version:    0.7.0.1
 */