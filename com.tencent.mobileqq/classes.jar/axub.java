import java.util.Comparator;

class axub
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (axtx)paramObject1;
    paramObject2 = (axtx)paramObject2;
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
 * Qualified Name:     axub
 * JD-Core Version:    0.7.0.1
 */