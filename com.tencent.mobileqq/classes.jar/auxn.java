import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;

public class auxn
  extends BaseAdapter
{
  protected int a;
  
  public auxn(GameQuickWordsPanel paramGameQuickWordsPanel)
  {
    this.jdField_a_of_type_Int = -1;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.getContext()).inflate(2131558578, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, aepi.a(46.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.getResources())));
      paramViewGroup = new auxo(this);
      paramViewGroup.a = ((TextView)paramView.findViewById(2131373997));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = (String)getItem(paramInt);
      paramViewGroup.a.setText(str);
      paramViewGroup.a.setTextColor(this.jdField_a_of_type_Int);
      return paramView;
      paramViewGroup = (auxo)paramView.getTag();
    }
  }
  
  public void notifyDataSetChanged()
  {
    HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.jdField_a_of_type_Agqq.a();
    if (localHashMap.containsKey("quickWordColor")) {
      this.jdField_a_of_type_Int = ((Integer)localHashMap.get("quickWordColor")).intValue();
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auxn
 * JD-Core Version:    0.7.0.1
 */