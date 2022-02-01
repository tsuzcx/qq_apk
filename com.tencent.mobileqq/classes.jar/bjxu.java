import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjxu
  implements View.OnClickListener
{
  public bjxu(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    Object localObject = QidianProfileCardActivity.a(this.a);
    int i;
    if (QidianProfileCardActivity.a(this.a))
    {
      i = 1;
      ((TextView)localObject).setMaxLines(i);
      localObject = this.a;
      if (QidianProfileCardActivity.a(this.a)) {
        break label65;
      }
    }
    for (;;)
    {
      QidianProfileCardActivity.a((QidianProfileCardActivity)localObject, bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 3;
      break;
      label65:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxu
 * JD-Core Version:    0.7.0.1
 */