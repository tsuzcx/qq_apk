import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.appstore.component.CommonTitleBar;

public class bdhc
  implements View.OnClickListener
{
  public bdhc(CommonTitleBar paramCommonTitleBar) {}
  
  public void onClick(View paramView)
  {
    if (CommonTitleBar.a(this.a) != null) {
      CommonTitleBar.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdhc
 * JD-Core Version:    0.7.0.1
 */