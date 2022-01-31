import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.widget.Switch;
import java.util.List;

public class bdcp
  extends bddt
{
  List<bczs> jdField_a_of_type_JavaUtilList;
  
  public bdcp(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public List<bczs> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<bczs> paramList)
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
    bczs localbczs = (bczs)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment.getActivity().getLayoutInflater().inflate(2131559495, paramViewGroup, false);
      paramView = new bdcr();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371383));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131371382));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new bdcq(this, localbczs));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(localbczs.b);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbczs.a);
      return localView;
      paramViewGroup = (bdcr)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdcp
 * JD-Core Version:    0.7.0.1
 */