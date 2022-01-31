import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.GridListView;

public class bbje
  implements View.OnClickListener
{
  public bbje(GridListView paramGridListView) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131296273)).intValue();
    this.a.a.onItemClick(this.a, paramView, i, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbje
 * JD-Core Version:    0.7.0.1
 */