import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.GroupListOpenFrame;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjdf
  extends bjgn
{
  public bjdf(GroupListOpenFrame paramGroupListOpenFrame) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_Bjgp.b();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    int i;
    if (paramView == null)
    {
      paramView = new bjdh(this);
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559722, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363792));
      paramView.b = ((TextView)localView.findViewById(2131367872));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131367871));
      localView.setTag(paramView);
      localObject = this.a.jdField_a_of_type_Bjgp.a(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramView.b.setText(String.valueOf(this.a.jdField_a_of_type_Bjgp.a(paramInt)));
      i = (int)(10.0F * this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a);
      if (paramInt != 0) {
        break label222;
      }
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839512);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, 0, i, 0);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bjdg(this, paramInt, (String)localObject));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (bjdh)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label222:
      if (paramInt == getCount() - 1) {
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839503);
      } else {
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839506);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjdf
 * JD-Core Version:    0.7.0.1
 */