import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.widget.Switch;
import java.util.List;

public class bfgl
  extends bfhp
{
  List<bfds> jdField_a_of_type_JavaUtilList;
  
  public bfgl(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public List<bfds> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<bfds> paramList)
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
    bfds localbfds = (bfds)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment.getActivity().getLayoutInflater().inflate(2131559546, paramViewGroup, false);
      paramView = new bfgn();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371719));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131371718));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new bfgm(this, localbfds));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(localbfds.b);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbfds.a);
      return localView;
      paramViewGroup = (bfgn)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfgl
 * JD-Core Version:    0.7.0.1
 */