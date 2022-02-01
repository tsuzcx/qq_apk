import android.app.Activity;
import android.view.View;

public class bmwc
{
  public static void a(Activity paramActivity, View paramView, bmwd parambmwd, bmwe parambmwe)
  {
    if ((paramActivity == null) || (paramView == null) || (parambmwd == null) || (parambmwe == null)) {}
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
        } while (parambmwe.isShowing());
        paramActivity = new int[2];
        paramView.getLocationOnScreen(paramActivity);
        i = paramActivity[0] + parambmwd.a() + parambmwd.c() / 2;
        j = paramActivity[1] + parambmwd.b() + parambmwd.d() / 2;
        int k = bgtn.b();
        m = parambmwe.a();
        int n = parambmwd.c() / 4;
        i1 = parambmwd.c() / 4;
        i2 = parambmwe.b();
        if (k - j - n < m) {
          break;
        }
      } while (!parambmwe.a(i, j + parambmwd.c() / 4));
      parambmwe.b();
      return;
    } while ((j - i1 - i2 < m) || (!parambmwe.a(i, j - m - parambmwd.c() / 4)));
    parambmwe.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwc
 * JD-Core Version:    0.7.0.1
 */