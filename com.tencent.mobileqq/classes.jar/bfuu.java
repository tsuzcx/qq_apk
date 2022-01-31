import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qidian.QidianProfileCardActivity;

public class bfuu
  implements View.OnClickListener
{
  public bfuu(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    paramView = QidianProfileCardActivity.a(this.a);
    int i;
    if (QidianProfileCardActivity.a(this.a))
    {
      i = 1;
      paramView.setMaxLines(i);
      paramView = this.a;
      if (QidianProfileCardActivity.a(this.a)) {
        break label54;
      }
    }
    for (;;)
    {
      QidianProfileCardActivity.a(paramView, bool);
      return;
      i = 3;
      break;
      label54:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfuu
 * JD-Core Version:    0.7.0.1
 */