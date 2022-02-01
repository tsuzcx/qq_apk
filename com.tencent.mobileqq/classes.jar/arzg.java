import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class arzg
  extends BaseAdapter
{
  public arzg(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public aryz a(int paramInt)
  {
    return (aryz)this.a.a.get(paramInt);
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
    arzk localarzk;
    aryz localaryz;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131559606, paramViewGroup, false);
      localarzk = new arzk(this.a);
      localarzk.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131368990));
      localarzk.jdField_a_of_type_Arzh = new arzh(this.a);
      localarzk.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(localarzk.jdField_a_of_type_Arzh);
      localarzk.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(localarzk.jdField_a_of_type_Arzh);
      paramView.setTag(localarzk);
      localaryz = a(paramInt);
      localarzk.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localaryz.jdField_a_of_type_Boolean);
      if (!(localaryz instanceof asaa)) {
        break label205;
      }
      localarzk.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localaryz.jdField_a_of_type_JavaLangString + " - " + ((asaa)localaryz).b);
    }
    for (;;)
    {
      localarzk.jdField_a_of_type_Arzh.a = localaryz;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localarzk = (arzk)paramView.getTag();
      break;
      label205:
      localarzk.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localaryz.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzg
 * JD-Core Version:    0.7.0.1
 */