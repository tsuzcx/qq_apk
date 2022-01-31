import java.util.Comparator;

class axuc
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (axtz)paramObject1;
    paramObject2 = (axtz)paramObject2;
    if (paramObject1.b > paramObject2.b) {
      return -1;
    }
    if (paramObject1.b < paramObject2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axuc
 * JD-Core Version:    0.7.0.1
 */