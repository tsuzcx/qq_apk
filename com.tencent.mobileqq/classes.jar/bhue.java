import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.List;

public class bhue
  extends bhvm
{
  List<bhrj> jdField_a_of_type_JavaUtilList;
  
  private bhue(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public List<bhrj> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<bhrj> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    bhrj localbhrj = (bhrj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment.getActivity().getLayoutInflater().inflate(2131559690, paramViewGroup, false);
      paramView = new bhug(null);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372374));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131372373));
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new bhuf(this, localbhrj));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(localbhrj.b);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localbhrj.a);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      bhug localbhug = (bhug)paramView.getTag();
      localView = paramView;
      paramView = localbhug;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhue
 * JD-Core Version:    0.7.0.1
 */