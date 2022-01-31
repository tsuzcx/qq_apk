import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.widget.BubblePopupWindow;

public class bdld
  extends TextView
{
  public bdld(QQCustomMenuNoIconLayout paramQQCustomMenuNoIconLayout, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    this.a.a.b();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdld
 * JD-Core Version:    0.7.0.1
 */