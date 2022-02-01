import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuImageLayout;
import com.tencent.widget.BubblePopupWindow;

public class bhjr
  extends TextView
{
  public bhjr(QQCustomMenuImageLayout paramQQCustomMenuImageLayout, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    QQCustomMenuImageLayout.a(this.a).a();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjr
 * JD-Core Version:    0.7.0.1
 */