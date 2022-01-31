import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.GroupListOpenFrame;

public class bfai
  extends bfdg
{
  public bfai(GroupListOpenFrame paramGroupListOpenFrame) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_Bfdi.b();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str;
    int i;
    if (paramView == null)
    {
      paramViewGroup = new bfak(this);
      paramView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559543, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363469));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131367319));
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131367318));
      paramView.setTag(paramViewGroup);
      str = this.a.jdField_a_of_type_Bfdi.a(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramViewGroup.b.setText(String.valueOf(this.a.jdField_a_of_type_Bfdi.a(paramInt)));
      i = (int)(10.0F * this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a);
      if (paramInt != 0) {
        break label194;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839269);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, 0, i, 0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bfaj(this, paramInt, str));
      return paramView;
      paramViewGroup = (bfak)paramView.getTag();
      break;
      label194:
      if (paramInt == getCount() - 1) {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839260);
      } else {
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839263);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfai
 * JD-Core Version:    0.7.0.1
 */