import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.ArrayList;

public class apgw
  extends BaseAdapter
{
  public apgw(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public apgp a(int paramInt)
  {
    return (apgp)this.a.a.get(paramInt);
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
    apgp localapgp;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131559469, paramViewGroup, false);
      paramViewGroup = new apha(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131368574));
      paramViewGroup.jdField_a_of_type_Apgx = new apgx(this.a);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(paramViewGroup.jdField_a_of_type_Apgx);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(paramViewGroup.jdField_a_of_type_Apgx);
      paramView.setTag(paramViewGroup);
      localapgp = a(paramInt);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localapgp.jdField_a_of_type_Boolean);
      if (!(localapgp instanceof aphq)) {
        break label179;
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localapgp.jdField_a_of_type_JavaLangString + " - " + ((aphq)localapgp).b);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Apgx.a = localapgp;
      return paramView;
      paramViewGroup = (apha)paramView.getTag();
      break;
      label179:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localapgp.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgw
 * JD-Core Version:    0.7.0.1
 */