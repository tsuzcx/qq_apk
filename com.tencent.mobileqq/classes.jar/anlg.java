import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.ArrayList;

public class anlg
  extends BaseAdapter
{
  public anlg(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public ankz a(int paramInt)
  {
    return (ankz)this.a.a.get(paramInt);
  }
  
  public int getCount()
  {
    return this.a.a.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ankz localankz;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131559418, paramViewGroup, false);
      paramViewGroup = new anlk(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131368380));
      paramViewGroup.jdField_a_of_type_Anlh = new anlh(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(paramViewGroup.jdField_a_of_type_Anlh);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(paramViewGroup.jdField_a_of_type_Anlh);
      paramView.setTag(paramViewGroup);
      localankz = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localankz.jdField_a_of_type_Boolean);
      if (!(localankz instanceof anma)) {
        break label179;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localankz.jdField_a_of_type_JavaLangString + " - " + ((anma)localankz).b);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Anlh.a = localankz;
      return paramView;
      paramViewGroup = (anlk)paramView.getTag();
      break;
      label179:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localankz.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anlg
 * JD-Core Version:    0.7.0.1
 */