import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aqtd
  extends BaseAdapter
{
  public aqtd(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public aqsw a(int paramInt)
  {
    return (aqsw)this.a.a.get(paramInt);
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
    aqth localaqth;
    aqsw localaqsw;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131559608, paramViewGroup, false);
      localaqth = new aqth(this.a);
      localaqth.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131369016));
      localaqth.jdField_a_of_type_Aqte = new aqte(this.a);
      localaqth.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(localaqth.jdField_a_of_type_Aqte);
      localaqth.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(localaqth.jdField_a_of_type_Aqte);
      paramView.setTag(localaqth);
      localaqsw = a(paramInt);
      localaqth.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localaqsw.jdField_a_of_type_Boolean);
      if (!(localaqsw instanceof aqtx)) {
        break label205;
      }
      localaqth.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localaqsw.jdField_a_of_type_JavaLangString + " - " + ((aqtx)localaqsw).b);
    }
    for (;;)
    {
      localaqth.jdField_a_of_type_Aqte.a = localaqsw;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localaqth = (aqth)paramView.getTag();
      break;
      label205:
      localaqth.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localaqsw.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtd
 * JD-Core Version:    0.7.0.1
 */