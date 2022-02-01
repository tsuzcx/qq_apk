import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class bipb
  implements View.OnClickListener
{
  public bipb(GridListView paramGridListView) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131361811)).intValue();
    this.a.a.onItemClick(this.a, paramView, i, 0L);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipb
 * JD-Core Version:    0.7.0.1
 */