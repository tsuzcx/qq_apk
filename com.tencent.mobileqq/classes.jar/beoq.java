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

class beoq
  extends BaseAdapter
{
  List<bfhn> jdField_a_of_type_JavaUtilList;
  
  beoq(List<bfhn> paramList)
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
    beor localbeor;
    bfhn localbfhn;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_Beop.getContext()).inflate(2131560583, null);
      localbeor = new beor(this.jdField_a_of_type_Beop);
      localbeor.jdField_a_of_type_ComTencentWidgetSingleLineTextView = ((SingleLineTextView)paramView.findViewById(2131371539));
      localbeor.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367877));
      localbeor.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369522));
      localbeor.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131369846);
      paramView.setOnClickListener(this.jdField_a_of_type_Beop);
      paramView.setTag(localbeor);
      localbfhn = (bfhn)getItem(paramInt);
      localbeor.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localbfhn.a.getTroopName());
      if (localbfhn.a.lastMsgTime == 0L) {
        break label298;
      }
      localbeor.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      localbeor.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131706339) + TimeManager.getInstance().getMsgDisplayTime(localbfhn.a.troopuin, localbfhn.a.lastMsgTime));
      label200:
      if (!localbfhn.a.hasSetTroopHead()) {
        break label387;
      }
    }
    label387:
    for (int i = 4;; i = 113)
    {
      aoch localaoch = aoch.a(this.jdField_a_of_type_Beop.a, i, localbfhn.a.troopuin, 3, aoch.a(4, 3), aoch.a(4, 3));
      localbeor.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localaoch);
      localbeor.jdField_a_of_type_JavaLangString = localbfhn.a.troopuin;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localbeor = (beor)paramView.getTag();
      break;
      label298:
      if (localbfhn.a.troopCreateTime != 0L)
      {
        localbeor.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        localbeor.jdField_a_of_type_AndroidWidgetTextView.setText(anni.a(2131706344) + TimeManager.getInstance().getMsgDisplayTime(localbfhn.a.troopuin, localbfhn.a.troopCreateTime));
        break label200;
      }
      localbeor.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label200;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beoq
 * JD-Core Version:    0.7.0.1
 */