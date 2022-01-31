package c.t.m.g;

public final class ct
{
  private static int[] a = { 0, 8, 10, 33, 65535, 50594049, 268435455, 2147483647 };
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt5 <= 0) || (paramInt2 == 535) || (paramInt3 == 535) || (paramInt4 == 65535) || (paramInt5 == 65535)) {}
    label75:
    label104:
    label111:
    label114:
    for (;;)
    {
      return false;
      paramInt2 = cp.a.a;
      if (paramInt1 == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0)
        {
          if (paramInt4 == 25840) {
            continue;
          }
          int[] arrayOfInt = a;
          paramInt1 = 0;
          if (paramInt1 >= arrayOfInt.length) {
            break label111;
          }
          if (paramInt5 != arrayOfInt[paramInt1]) {
            break label104;
          }
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label114;
        }
        return true;
        paramInt1 = 0;
        break;
        paramInt1 += 1;
        break label75;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.ct
 * JD-Core Version:    0.7.0.1
 */