import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.datareportviewer.DataReportSettingFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class arjr
  extends BaseAdapter
{
  public arjr(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public arjk a(int paramInt)
  {
    return (arjk)this.a.a.get(paramInt);
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
    arjv localarjv;
    arjk localarjk;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a.getActivity()).inflate(2131559601, paramViewGroup, false);
      localarjv = new arjv(this.a);
      localarjv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)paramView.findViewById(2131368897));
      localarjv.jdField_a_of_type_Arjs = new arjs(this.a);
      localarjv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(localarjv.jdField_a_of_type_Arjs);
      localarjv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnLongClickListener(localarjv.jdField_a_of_type_Arjs);
      paramView.setTag(localarjv);
      localarjk = a(paramInt);
      localarjv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(localarjk.jdField_a_of_type_Boolean);
      if (!(localarjk instanceof arkl)) {
        break label205;
      }
      localarjv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localarjk.jdField_a_of_type_JavaLangString + " - " + ((arkl)localarjk).b);
    }
    for (;;)
    {
      localarjv.jdField_a_of_type_Arjs.a = localarjk;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localarjv = (arjv)paramView.getTag();
      break;
      label205:
      localarjv.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setText(localarjk.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjr
 * JD-Core Version:    0.7.0.1
 */