import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class asny
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public asny(Context paramContext, List<String> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
    this.jdField_a_of_type_AndroidContentContext = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559129, null);
    }
    for (;;)
    {
      Button localButton = (Button)paramView.findViewById(2131363961);
      localButton.setText((CharSequence)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      localButton.setContentDescription((CharSequence)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      localButton.setBackgroundDrawable(this.jdField_a_of_type_Asnw.a(12));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_Asnw.a(), false, null)) {
        localButton.setTextColor(Color.parseColor("#B0B3BF"));
      }
      for (;;)
      {
        localButton.setOnClickListener(new asnz(this, localButton));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localButton.setTextColor(Color.parseColor("#03081A"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asny
 * JD-Core Version:    0.7.0.1
 */