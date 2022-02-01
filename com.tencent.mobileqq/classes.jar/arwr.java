import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class arwr
  extends BaseAdapter
{
  public arwr(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public arwk a(int paramInt)
  {
    return (arwk)this.a.a.get(paramInt);
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
    arwv localarwv;
    arwk localarwk;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131559643, paramViewGroup, false);
      localarwv = new arwv(this.a);
      localarwv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131369179));
      localarwv.jdField_a_of_type_Arws = new arws(this.a);
      localarwv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(localarwv.jdField_a_of_type_Arws);
      localarwv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(localarwv.jdField_a_of_type_Arws);
      paramView.setTag(localarwv);
      localarwk = a(paramInt);
      localarwv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localarwk.jdField_a_of_type_Boolean);
      if (!(localarwk instanceof arxl)) {
        break label205;
      }
      localarwv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localarwk.jdField_a_of_type_JavaLangString + " - " + ((arxl)localarwk).b);
    }
    for (;;)
    {
      localarwv.jdField_a_of_type_Arws.a = localarwk;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localarwv = (arwv)paramView.getTag();
      break;
      label205:
      localarwv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localarwk.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arwr
 * JD-Core Version:    0.7.0.1
 */