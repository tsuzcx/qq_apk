import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class bdzt
  extends BaseAdapter
{
  public bdzt(TableQueryViewer paramTableQueryViewer) {}
  
  private int a()
  {
    return a().size();
  }
  
  private List<bdzk> a()
  {
    return TableQueryViewer.a(this.a);
  }
  
  public int getCount()
  {
    return a();
  }
  
  public Object getItem(int paramInt)
  {
    return a().get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.a.getContext()).inflate(2131562980, paramViewGroup, false);
      paramView = new bdzs(this.a, localView);
      localView.setTag(paramView);
      localObject = (bdzk)a().get(paramInt);
      paramView.a.setText(((bdzk)localObject).b);
      paramView.d.setText(((bdzk)localObject).k);
      paramView.b.setText(((bdzk)localObject).c);
      paramView.c.setText(((bdzk)localObject).f);
      if (paramInt % 2 != 0) {
        break label168;
      }
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131166566));
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (bdzs)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label168:
      localView.setBackgroundColor(this.a.getContext().getResources().getColor(2131167302));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzt
 * JD-Core Version:    0.7.0.1
 */