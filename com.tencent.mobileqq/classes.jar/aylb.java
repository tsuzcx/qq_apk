import java.util.Comparator;

class aylb
  implements Comparator
{
  aylb(aykz paramaykz) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    int i = this.a.getSpanStart(paramObject1);
    int j = this.a.getSpanStart(paramObject2);
    if (i == j) {
      return 0;
    }
    if (i > j) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aylb
 * JD-Core Version:    0.7.0.1
 */