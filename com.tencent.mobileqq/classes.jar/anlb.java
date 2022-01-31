import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.ArrayList;

public class anlb
  extends BaseAdapter
{
  public anlb(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public anku a(int paramInt)
  {
    return (anku)this.a.a.get(paramInt);
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
    anku localanku;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131559418, paramViewGroup, false);
      paramViewGroup = new anlf(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131368380));
      paramViewGroup.jdField_a_of_type_Anlc = new anlc(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(paramViewGroup.jdField_a_of_type_Anlc);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(paramViewGroup.jdField_a_of_type_Anlc);
      paramView.setTag(paramViewGroup);
      localanku = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localanku.jdField_a_of_type_Boolean);
      if (!(localanku instanceof anlv)) {
        break label179;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localanku.jdField_a_of_type_JavaLangString + " - " + ((anlv)localanku).b);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Anlc.a = localanku;
      return paramView;
      paramViewGroup = (anlf)paramView.getTag();
      break;
      label179:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localanku.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anlb
 * JD-Core Version:    0.7.0.1
 */