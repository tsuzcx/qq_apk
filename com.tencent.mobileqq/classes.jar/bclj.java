import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.CustomedTabWidget;

public class bclj
  implements View.OnClickListener
{
  public bclj(CustomedTabWidget paramCustomedTabWidget) {}
  
  public void onClick(View paramView)
  {
    this.a.setCurrentTab(this.a.indexOfChild(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bclj
 * JD-Core Version:    0.7.0.1
 */