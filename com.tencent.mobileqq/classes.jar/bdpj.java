import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuImageLayout;
import com.tencent.widget.BubblePopupWindow;

public class bdpj
  extends TextView
{
  public bdpj(QQCustomMenuImageLayout paramQQCustomMenuImageLayout, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    QQCustomMenuImageLayout.a(this.a).b();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdpj
 * JD-Core Version:    0.7.0.1
 */