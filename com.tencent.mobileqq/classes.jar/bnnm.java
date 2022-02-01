import android.app.Activity;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;

class bnnm
  implements OnApplyWindowInsetsListener
{
  bnnm(bnnl parambnnl) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView.findViewById(2131366840);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      int j = paramWindowInsetsCompat.getSystemWindowInsetTop();
      int i = j;
      if (bnnl.a(this.a) != null)
      {
        i = j;
        if (bnnl.a(this.a).a() != null)
        {
          i = j;
          if (!bnqb.j(bnnl.a(this.a).a().getIntent())) {
            i = j / 2;
          }
        }
      }
      if (bnnl.a(this.a)) {
        i = bgtn.a(20.0F);
      }
      localMarginLayoutParams.topMargin = i;
      paramView.setLayoutParams(localMarginLayoutParams);
    }
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnm
 * JD-Core Version:    0.7.0.1
 */