import android.app.Activity;
import android.view.View;

public class bibf
{
  public static void a(Activity paramActivity, View paramView, bibg parambibg, bibh parambibh)
  {
    if ((paramActivity == null) || (paramView == null) || (parambibg == null) || (parambibh == null)) {}
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
        } while (parambibh.isShowing());
        paramActivity = new int[2];
        paramView.getLocationOnScreen(paramActivity);
        i = paramActivity[0] + parambibg.a() + parambibg.c() / 2;
        j = paramActivity[1] + parambibg.b() + parambibg.d() / 2;
        int k = bbll.b();
        m = parambibh.a();
        int n = parambibg.c() / 4;
        i1 = parambibg.c() / 4;
        i2 = parambibh.b();
        if (k - j - n < m) {
          break;
        }
      } while (!parambibh.a(i, j + parambibg.c() / 4));
      parambibh.b();
      return;
    } while ((j - i1 - i2 < m) || (!parambibh.a(i, j - m - parambibg.c() / 4)));
    parambibh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bibf
 * JD-Core Version:    0.7.0.1
 */