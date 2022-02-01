import android.app.Activity;
import android.view.View;

public class bnxk
{
  public static void a(Activity paramActivity, View paramView, bnxl parambnxl, bnxm parambnxm)
  {
    if ((paramActivity == null) || (paramView == null) || (parambnxl == null) || (parambnxm == null)) {}
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
        } while (parambnxm.isShowing());
        paramActivity = new int[2];
        paramView.getLocationOnScreen(paramActivity);
        i = paramActivity[0] + parambnxl.a() + parambnxl.c() / 2;
        j = paramActivity[1] + parambnxl.b() + parambnxl.d() / 2;
        int k = bhtq.b();
        m = parambnxm.a();
        int n = parambnxl.c() / 4;
        i1 = parambnxl.c() / 4;
        i2 = parambnxm.b();
        if (k - j - n < m) {
          break;
        }
      } while (!parambnxm.a(i, j + parambnxl.c() / 4));
      parambnxm.b();
      return;
    } while ((j - i1 - i2 < m) || (!parambnxm.a(i, j - m - parambnxl.c() / 4)));
    parambnxm.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnxk
 * JD-Core Version:    0.7.0.1
 */