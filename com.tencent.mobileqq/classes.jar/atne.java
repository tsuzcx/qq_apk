import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView;
import com.tencent.mobileqq.nearby.now.view.widget.TopicViewItem;
import java.util.List;

public class atne
  extends BaseAdapter
{
  public atne(StartLiveTopicLabelListView paramStartLiveTopicLabelListView) {}
  
  public int getCount()
  {
    if ((StartLiveTopicLabelListView.a(this.a) == null) || (StartLiveTopicLabelListView.a(this.a).size() == 0)) {
      return 0;
    }
    return StartLiveTopicLabelListView.a(this.a).size();
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
      paramViewGroup = new atnh(this.a, null);
      paramView = new TopicViewItem(StartLiveTopicLabelListView.a(this.a));
      paramView.setTag(paramViewGroup);
      paramViewGroup.a = ((String)StartLiveTopicLabelListView.a(this.a).get(paramInt));
      if (!ajyc.a(2131714346).equals(paramViewGroup.a)) {
        break label133;
      }
      paramView.setBackgroundResource(StartLiveTopicLabelListView.a(this.a));
      ((TopicViewItem)paramView).setTextColor(StartLiveTopicLabelListView.b(this.a));
    }
    for (;;)
    {
      paramView.setOnClickListener(new atnf(this));
      ((TopicViewItem)paramView).setText(paramViewGroup.a);
      return paramView;
      paramViewGroup = (atnh)paramView.getTag();
      break;
      label133:
      paramView.setBackgroundResource(StartLiveTopicLabelListView.c(this.a));
      ((TopicViewItem)paramView).setTextColor(StartLiveTopicLabelListView.d(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atne
 * JD-Core Version:    0.7.0.1
 */