import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

public class bmph
{
  public static void a(Activity paramActivity, View paramView, bmpi parambmpi, bmpj parambmpj)
  {
    if ((paramActivity == null) || (paramView == null) || (parambmpi == null) || (parambmpj == null)) {}
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
        } while (parambmpj.isShowing());
        paramActivity = new int[2];
        paramView.getLocationOnScreen(paramActivity);
        i = paramActivity[0] + parambmpi.a() + parambmpi.c() / 2;
        j = paramActivity[1] + parambmpi.b() + parambmpi.d() / 2;
        int k = ViewUtils.getScreenHeight();
        m = parambmpj.a();
        int n = parambmpi.c() / 4;
        i1 = parambmpi.c() / 4;
        i2 = parambmpj.b();
        if (k - j - n < m) {
          break;
        }
      } while (!parambmpj.a(i, j + parambmpi.c() / 4));
      parambmpj.b();
      return;
    } while ((j - i1 - i2 < m) || (!parambmpj.a(i, j - m - parambmpi.c() / 4)));
    parambmpj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmph
 * JD-Core Version:    0.7.0.1
 */