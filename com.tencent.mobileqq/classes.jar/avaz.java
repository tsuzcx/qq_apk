import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class avaz
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<avbx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public avaz(Context paramContext, ArrayList<avbx> paramArrayList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public avbx a(int paramInt)
  {
    return (avbx)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
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
      paramView = new avba();
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559230, paramViewGroup, false);
      paramView.a = ((TextView)localView.findViewById(2131377622));
      localView.setTag(paramView);
      localObject = a(paramInt);
      boolean bool = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
      if (!bool) {
        break label151;
      }
      paramView.a.setTextColor(Color.parseColor("#ffffff"));
      label83:
      if (!bool) {
        break label166;
      }
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838680));
    }
    for (;;)
    {
      paramView.a.setText(((avbx)localObject).a);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (avba)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label151:
      paramView.a.setTextColor(Color.parseColor("#1C1D1E"));
      break label83;
      label166:
      localView.setBackgroundDrawable(localView.getResources().getDrawable(2130838679));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avaz
 * JD-Core Version:    0.7.0.1
 */