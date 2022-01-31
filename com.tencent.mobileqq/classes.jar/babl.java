import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import java.util.List;

public class babl
  extends BaseAdapter
{
  public babl(TableQueryViewer paramTableQueryViewer) {}
  
  private int a()
  {
    return a().size();
  }
  
  private List<babc> a()
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
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562689, paramViewGroup, false);
      paramViewGroup = new babk(this.a, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      babc localbabc = (babc)a().get(paramInt);
      paramViewGroup.a.setText(localbabc.b);
      paramViewGroup.d.setText(localbabc.k);
      paramViewGroup.b.setText(localbabc.c);
      paramViewGroup.c.setText(localbabc.f);
      if (paramInt % 2 != 0) {
        break;
      }
      paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131166486));
      return paramView;
      paramViewGroup = (babk)paramView.getTag();
    }
    paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131167192));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babl
 * JD-Core Version:    0.7.0.1
 */