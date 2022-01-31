import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.GroupListOpenFrame;

public class bdbk
  extends bdei
{
  public bdbk(GroupListOpenFrame paramGroupListOpenFrame) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_Bdek.b();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str;
    int i;
    if (paramView == null)
    {
      paramViewGroup = new bdbm(this);
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559491, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363429));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131367189));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367188));
      paramView.setTag(paramViewGroup);
      str = this.a.jdField_a_of_type_Bdek.a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramViewGroup.b.setText(String.valueOf(this.a.jdField_a_of_type_Bdek.a(paramInt)));
      i = (int)(10.0F * this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a);
      if (paramInt != 0) {
        break label194;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839185);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, 0, i, 0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bdbl(this, paramInt, str));
      return paramView;
      paramViewGroup = (bdbm)paramView.getTag();
      break;
      label194:
      if (paramInt == getCount() - 1) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839176);
      } else {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839179);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdbk
 * JD-Core Version:    0.7.0.1
 */