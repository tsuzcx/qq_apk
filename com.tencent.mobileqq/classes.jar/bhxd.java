import java.util.Comparator;

class bhxd
  implements Comparator<bhxe>
{
  public int a(bhxe parambhxe1, bhxe parambhxe2)
  {
    int i = 1;
    if (parambhxe1.a == parambhxe2.a) {
      if (parambhxe1.b == parambhxe2.b) {
        i = 0;
      }
    }
    while (parambhxe1.a > parambhxe2.a)
    {
      do
      {
        return i;
      } while (parambhxe1.b > parambhxe2.b);
      return -1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxd
 * JD-Core Version:    0.7.0.1
 */