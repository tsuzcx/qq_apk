import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController.3;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfxt
  implements View.OnClickListener
{
  public bfxt(HomeworkTroopController.3 param3) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfxt
 * JD-Core Version:    0.7.0.1
 */