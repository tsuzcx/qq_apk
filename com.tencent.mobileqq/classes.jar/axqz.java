import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;

public class axqz
  extends BaseAdapter
{
  protected int a;
  
  public axqz(GameQuickWordsPanel paramGameQuickWordsPanel)
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
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.getContext()).inflate(2131558622, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(-1, AIOUtils.dp2px(46.0F, this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.getResources())));
      paramView = new axra(this);
      paramView.a = ((TextView)localView.findViewById(2131374861));
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject = (String)getItem(paramInt);
      paramView.a.setText((CharSequence)localObject);
      paramView.a.setTextColor(this.jdField_a_of_type_Int);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (axra)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
    }
  }
  
  public void notifyDataSetChanged()
  {
    HashMap localHashMap = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameQuickWordsPanel.jdField_a_of_type_Aiav.a();
    if (localHashMap.containsKey("quickWordColor")) {
      this.jdField_a_of_type_Int = ((Integer)localHashMap.get("quickWordColor")).intValue();
    }
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqz
 * JD-Core Version:    0.7.0.1
 */