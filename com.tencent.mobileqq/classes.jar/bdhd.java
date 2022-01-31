import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.appstore.component.CommonTitleBar;

public class bdhd
  implements View.OnClickListener
{
  public bdhd(CommonTitleBar paramCommonTitleBar) {}
  
  public void onClick(View paramView)
  {
    if (CommonTitleBar.a(this.a) != null) {
      CommonTitleBar.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdhd
 * JD-Core Version:    0.7.0.1
 */