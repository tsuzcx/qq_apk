import java.util.Comparator;

class bebc
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (beaz)paramObject1;
    paramObject2 = (beaz)paramObject2;
    if (paramObject1.c > paramObject2.c) {}
    do
    {
      return -1;
      if (paramObject1.c < paramObject2.c) {
        return 1;
      }
    } while (paramObject1.d > paramObject2.d);
    if (paramObject1.d < paramObject2.d) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bebc
 * JD-Core Version:    0.7.0.1
 */