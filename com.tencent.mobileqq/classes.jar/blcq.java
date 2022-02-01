import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;

public class blcq
{
  public static void a(Activity paramActivity, View paramView, blcr paramblcr, blcs paramblcs)
  {
    if ((paramActivity == null) || (paramView == null) || (paramblcr == null) || (paramblcs == null)) {}
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
        } while (paramblcs.isShowing());
        paramActivity = new int[2];
        paramView.getLocationOnScreen(paramActivity);
        i = paramActivity[0] + paramblcr.a() + paramblcr.c() / 2;
        j = paramActivity[1] + paramblcr.b() + paramblcr.d() / 2;
        int k = ViewUtils.getScreenHeight();
        m = paramblcs.a();
        int n = paramblcr.c() / 4;
        i1 = paramblcr.c() / 4;
        i2 = paramblcs.b();
        if (k - j - n < m) {
          break;
        }
      } while (!paramblcs.a(i, j + paramblcr.c() / 4));
      paramblcs.b();
      return;
    } while ((j - i1 - i2 < m) || (!paramblcs.a(i, j - m - paramblcr.c() / 4)));
    paramblcs.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcq
 * JD-Core Version:    0.7.0.1
 */