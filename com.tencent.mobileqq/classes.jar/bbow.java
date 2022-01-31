import java.util.Comparator;

class bbow
  implements Comparator<bbox>
{
  public int a(bbox parambbox1, bbox parambbox2)
  {
    int i = 1;
    if (parambbox1.a == parambbox2.a) {
      if (parambbox1.b == parambbox2.b) {
        i = 0;
      }
    }
    while (parambbox1.a > parambbox2.a)
    {
      do
      {
        return i;
      } while (parambbox1.b > parambbox2.b);
      return -1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbow
 * JD-Core Version:    0.7.0.1
 */