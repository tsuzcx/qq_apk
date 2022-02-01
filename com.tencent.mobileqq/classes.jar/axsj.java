import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axsj
  implements View.OnClickListener
{
  axsj(axsd paramaxsd) {}
  
  public void onClick(View paramView)
  {
    bkho localbkho = bkho.a(this.a.a);
    localbkho.a(2131716603, 1);
    localbkho.c(2131690582);
    localbkho.a(new axsk(this, localbkho));
    localbkho.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsj
 * JD-Core Version:    0.7.0.1
 */