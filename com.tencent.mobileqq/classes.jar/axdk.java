import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import java.util.List;

public class axdk
  extends BaseAdapter
{
  public axdk(TableQueryViewer paramTableQueryViewer) {}
  
  private int a()
  {
    return a().size();
  }
  
  private List<axdb> a()
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
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131496886, paramViewGroup, false);
      paramViewGroup = new axdj(this.a, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      axdb localaxdb = (axdb)a().get(paramInt);
      paramViewGroup.a.setText(localaxdb.b);
      paramViewGroup.d.setText(localaxdb.k);
      paramViewGroup.b.setText(localaxdb.c);
      paramViewGroup.c.setText(localaxdb.f);
      if (paramInt % 2 != 0) {
        break;
      }
      paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131100846));
      return paramView;
      paramViewGroup = (axdj)paramView.getTag();
    }
    paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131101537));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axdk
 * JD-Core Version:    0.7.0.1
 */