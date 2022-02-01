import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.List;

class bfnx
  extends BaseAdapter
{
  List<bgho> jdField_a_of_type_JavaUtilList;
  
  bfnx(List<bgho> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
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
    bfny localbfny;
    bgho localbgho;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Bfnw.getContext()).inflate(2131560598, null);
      localbfny = new bfny(this.jdField_a_of_type_Bfnw);
      localbfny.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371647));
      localbfny.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367946));
      localbfny.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369615));
      localbfny.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369944);
      paramView.setOnClickListener(this.jdField_a_of_type_Bfnw);
      paramView.setTag(localbfny);
      localbgho = (bgho)getItem(paramInt);
      localbfny.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbgho.a.getTroopName());
      if (localbgho.a.lastMsgTime == 0L) {
        break label298;
      }
      localbfny.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbfny.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131706446) + TimeManager.getInstance().getMsgDisplayTime(localbgho.a.troopuin, localbgho.a.lastMsgTime));
      label200:
      if (!localbgho.a.hasSetTroopHead()) {
        break label387;
      }
    }
    label387:
    for (int i = 4;; i = 113)
    {
      aoot localaoot = aoot.a(this.jdField_a_of_type_Bfnw.a, i, localbgho.a.troopuin, 3, aoot.a(4, 3), aoot.a(4, 3));
      localbfny.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localaoot);
      localbfny.jdField_a_of_type_JavaLangString = localbgho.a.troopuin;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbfny = (bfny)paramView.getTag();
      break;
      label298:
      if (localbgho.a.troopCreateTime != 0L)
      {
        localbfny.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localbfny.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131706451) + TimeManager.getInstance().getMsgDisplayTime(localbgho.a.troopuin, localbgho.a.troopCreateTime));
        break label200;
      }
      localbfny.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label200;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnx
 * JD-Core Version:    0.7.0.1
 */