import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.1.1;
import mqq.os.MqqHandler;

public class bacp
  implements View.OnClickListener
{
  bacp(baco parambaco) {}
  
  public void onClick(View paramView)
  {
    if (!paramView.hasFocus())
    {
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      ThreadManager.getUIHandler().post(new TextItem.1.1(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacp
 * JD-Core Version:    0.7.0.1
 */