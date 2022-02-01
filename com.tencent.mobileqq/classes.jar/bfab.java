import java.util.Comparator;

class bfab
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    paramObject1 = (bezy)paramObject1;
    paramObject2 = (bezy)paramObject2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfab
 * JD-Core Version:    0.7.0.1
 */