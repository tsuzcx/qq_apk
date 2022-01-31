import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.now.view.widget.LabelViewItem;
import com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView;
import java.util.List;

public class aven
  extends BaseAdapter
{
  public aven(TopicLabelListView paramTopicLabelListView) {}
  
  public int getCount()
  {
    if ((TopicLabelListView.a(this.a) == null) || (TopicLabelListView.a(this.a).size() == 0)) {
      return 0;
    }
    return TopicLabelListView.a(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new aveo(this.a, null);
      paramView = new LabelViewItem(TopicLabelListView.a(this.a));
      paramView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a = ((String)TopicLabelListView.a(this.a).get(paramInt));
      ((LabelViewItem)paramView).setText(paramViewGroup.a);
      return paramView;
      paramViewGroup = (aveo)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aven
 * JD-Core Version:    0.7.0.1
 */