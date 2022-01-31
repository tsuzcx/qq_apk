import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.tablequery.TableQueryViewer;
import java.util.List;

public class aydo
  extends BaseAdapter
{
  public aydo(TableQueryViewer paramTableQueryViewer) {}
  
  private int a()
  {
    return a().size();
  }
  
  private List<aydf> a()
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
      paramView = LayoutInflater.from(this.a.getContext()).inflate(2131562485, paramViewGroup, false);
      paramViewGroup = new aydn(this.a, paramView);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      aydf localaydf = (aydf)a().get(paramInt);
      paramViewGroup.a.setText(localaydf.b);
      paramViewGroup.d.setText(localaydf.k);
      paramViewGroup.b.setText(localaydf.c);
      paramViewGroup.c.setText(localaydf.f);
      if (paramInt % 2 != 0) {
        break;
      }
      paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131166439));
      return paramView;
      paramViewGroup = (aydn)paramView.getTag();
    }
    paramView.setBackgroundColor(this.a.getContext().getResources().getColor(2131167134));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aydo
 * JD-Core Version:    0.7.0.1
 */