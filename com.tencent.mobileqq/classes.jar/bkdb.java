import android.app.Activity;
import android.view.View;

public class bkdb
{
  public static void a(Activity paramActivity, View paramView, bkdc parambkdc, bkdd parambkdd)
  {
    if ((paramActivity == null) || (paramView == null) || (parambkdc == null) || (parambkdd == null)) {}
    int i;
    int j;
    int m;
    int i1;
    int i2;
    do
    {
      do
      {
        do
        {
          return;
        } while (parambkdd.isShowing());
        paramActivity = new int[2];
        paramView.getLocationOnScreen(paramActivity);
        i = paramActivity[0] + parambkdc.a() + parambkdc.c() / 2;
        j = paramActivity[1] + parambkdc.b() + parambkdc.d() / 2;
        int k = bdkf.b();
        m = parambkdd.a();
        int n = parambkdc.c() / 4;
        i1 = parambkdc.c() / 4;
        i2 = parambkdd.b();
        if (k - j - n < m) {
          break;
        }
      } while (!parambkdd.a(i, j + parambkdc.c() / 4));
      parambkdd.b();
      return;
    } while ((j - i1 - i2 < m) || (!parambkdd.a(i, j - m - parambkdc.c() / 4)));
    parambkdd.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdb
 * JD-Core Version:    0.7.0.1
 */