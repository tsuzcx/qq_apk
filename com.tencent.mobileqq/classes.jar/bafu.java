import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import java.util.List;

public class bafu
  extends BaseAdapter
{
  public bafu(TableQueryViewer paramTableQueryViewer) {}
  
  private int a()
  {
    return a().size();
  }
  
  private List<bafl> a()
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
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562707, paramViewGroup, false);
      paramViewGroup = new baft(this.a, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      bafl localbafl = (bafl)a().get(paramInt);
      paramViewGroup.a.setText(localbafl.b);
      paramViewGroup.d.setText(localbafl.k);
      paramViewGroup.b.setText(localbafl.c);
      paramViewGroup.c.setText(localbafl.f);
      if (paramInt % 2 != 0) {
        break;
      }
      paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131166488));
      return paramView;
      paramViewGroup = (baft)paramView.getTag();
    }
    paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131167194));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafu
 * JD-Core Version:    0.7.0.1
 */