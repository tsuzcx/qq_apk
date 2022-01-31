import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.ArrayList;

public class amut
  extends BaseAdapter
{
  public amut(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public amum a(int paramInt)
  {
    return (amum)this.a.a.get(paramInt);
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
    amum localamum;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131493850, paramViewGroup, false);
      paramViewGroup = new amux(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131302756));
      paramViewGroup.jdField_a_of_type_Amuu = new amuu(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(paramViewGroup.jdField_a_of_type_Amuu);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(paramViewGroup.jdField_a_of_type_Amuu);
      paramView.setTag(paramViewGroup);
      localamum = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localamum.jdField_a_of_type_Boolean);
      if (!(localamum instanceof amvn)) {
        break label179;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localamum.jdField_a_of_type_JavaLangString + " - " + ((amvn)localamum).b);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Amuu.a = localamum;
      return paramView;
      paramViewGroup = (amux)paramView.getTag();
      break;
      label179:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localamum.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amut
 * JD-Core Version:    0.7.0.1
 */