import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.ArrayList;

public class apcn
  extends BaseAdapter
{
  public apcn(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public apcg a(int paramInt)
  {
    return (apcg)this.a.a.get(paramInt);
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
    apcg localapcg;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131559470, paramViewGroup, false);
      paramViewGroup = new apcr(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131368563));
      paramViewGroup.jdField_a_of_type_Apco = new apco(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(paramViewGroup.jdField_a_of_type_Apco);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(paramViewGroup.jdField_a_of_type_Apco);
      paramView.setTag(paramViewGroup);
      localapcg = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localapcg.jdField_a_of_type_Boolean);
      if (!(localapcg instanceof apdh)) {
        break label179;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localapcg.jdField_a_of_type_JavaLangString + " - " + ((apdh)localapcg).b);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Apco.a = localapcg;
      return paramView;
      paramViewGroup = (apcr)paramView.getTag();
      break;
      label179:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localapcg.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcn
 * JD-Core Version:    0.7.0.1
 */