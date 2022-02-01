import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.view.ViewGroup;

class bnfg
  implements OnApplyWindowInsetsListener
{
  bnfg(bnff parambnff) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView.findViewById(2131376788);
      if (paramView != null) {
        paramView.setPadding(0, paramWindowInsetsCompat.getSystemWindowInsetTop(), 0, 0);
      }
    }
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfg
 * JD-Core Version:    0.7.0.1
 */