import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bhxj
  implements View.OnClickListener
{
  public bhxj(GridListView paramGridListView) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131361809)).intValue();
    this.a.a.onItemClick(this.a, paramView, i, 0L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhxj
 * JD-Core Version:    0.7.0.1
 */