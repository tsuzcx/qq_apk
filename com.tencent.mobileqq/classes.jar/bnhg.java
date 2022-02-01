import android.app.Activity;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.utils.ViewUtils;

class bnhg
  implements OnApplyWindowInsetsListener
{
  bnhg(bnhf parambnhf) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView.findViewById(2131367033);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      int j = paramWindowInsetsCompat.getSystemWindowInsetTop();
      int i = j;
      if (bnhf.a(this.a) != null)
      {
        i = j;
        if (bnhf.a(this.a).a() != null)
        {
          i = j;
          if (!bnlb.j(bnhf.a(this.a).a().getIntent())) {
            i = j / 2;
          }
        }
      }
      if (bnhf.a(this.a)) {
        i = ViewUtils.dip2px(20.0F);
      }
      localMarginLayoutParams.topMargin = i;
      paramView.setLayoutParams(localMarginLayoutParams);
    }
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhg
 * JD-Core Version:    0.7.0.1
 */