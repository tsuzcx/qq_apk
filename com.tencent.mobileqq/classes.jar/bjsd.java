import android.view.View;
import com.tencent.widget.ListView;

public abstract interface bjsd
{
  public abstract void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView);
  
  public abstract void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView);
  
  public abstract boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView);
  
  public abstract void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bjsd
 * JD-Core Version:    0.7.0.1
 */