import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.now.view.widget.LabelViewItem;
import com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ayck
  extends BaseAdapter
{
  public ayck(TopicLabelListView paramTopicLabelListView) {}
  
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
    Object localObject;
    if (paramView == null)
    {
      paramView = new aycl(this.a, null);
      localObject = new LabelViewItem(TopicLabelListView.a(this.a));
      ((View)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
      ((View)localObject).setTag(paramView);
    }
    for (;;)
    {
      paramView.a = ((String)TopicLabelListView.a(this.a).get(paramInt));
      ((LabelViewItem)localObject).setText(paramView.a);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      aycl localaycl = (aycl)paramView.getTag();
      localObject = paramView;
      paramView = localaycl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayck
 * JD-Core Version:    0.7.0.1
 */