import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.GridListView;

public class bcmq
  implements View.OnClickListener
{
  public bcmq(GridListView paramGridListView) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131361808)).intValue();
    this.a.a.onItemClick(this.a, paramView, i, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcmq
 * JD-Core Version:    0.7.0.1
 */