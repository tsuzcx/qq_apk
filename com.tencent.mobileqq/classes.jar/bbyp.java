import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.open.agent.OpenSelectPermissionFragment;
import com.tencent.widget.Switch;
import java.util.List;

public class bbyp
  extends bbzt
{
  List<bbvs> jdField_a_of_type_JavaUtilList;
  
  public bbyp(OpenSelectPermissionFragment paramOpenSelectPermissionFragment) {}
  
  public List<bbvs> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<bbvs> paramList)
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
    bbvs localbbvs = (bbvs)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentOpenAgentOpenSelectPermissionFragment.getActivity().getLayoutInflater().inflate(2131493927, paramViewGroup, false);
      paramView = new bbyr();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131305687));
      paramView.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)localView.findViewById(2131305686));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(new bbyq(this, localbbvs));
      paramViewGroup.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(localbbvs.b);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localbbvs.a);
      return localView;
      paramViewGroup = (bbyr)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbyp
 * JD-Core Version:    0.7.0.1
 */