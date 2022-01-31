import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.appstore.component.CommonTitleBar;

public class bfga
  implements View.OnClickListener
{
  public bfga(CommonTitleBar paramCommonTitleBar) {}
  
  public void onClick(View paramView)
  {
    if (CommonTitleBar.a(this.a) != null) {
      CommonTitleBar.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfga
 * JD-Core Version:    0.7.0.1
 */