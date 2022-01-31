import android.app.Activity;
import android.view.View;

public class bkhi
{
  public static void a(Activity paramActivity, View paramView, bkhj parambkhj, bkhk parambkhk)
  {
    if ((paramActivity == null) || (paramView == null) || (parambkhj == null) || (parambkhk == null)) {}
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
        } while (parambkhk.isShowing());
        paramActivity = new int[2];
        paramView.getLocationOnScreen(paramActivity);
        i = paramActivity[0] + parambkhj.a() + parambkhj.c() / 2;
        j = paramActivity[1] + parambkhj.b() + parambkhj.d() / 2;
        int k = bdoo.b();
        m = parambkhk.a();
        int n = parambkhj.c() / 4;
        i1 = parambkhj.c() / 4;
        i2 = parambkhk.b();
        if (k - j - n < m) {
          break;
        }
      } while (!parambkhk.a(i, j + parambkhj.c() / 4));
      parambkhk.b();
      return;
    } while ((j - i1 - i2 < m) || (!parambkhk.a(i, j - m - parambkhj.c() / 4)));
    parambkhk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkhi
 * JD-Core Version:    0.7.0.1
 */