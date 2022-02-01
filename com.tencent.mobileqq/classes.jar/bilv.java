import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.GroupListOpenFrame;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bilv
  extends bioy
{
  public bilv(GroupListOpenFrame paramGroupListOpenFrame) {}
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_Bipa.b();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    int i;
    if (paramView == null)
    {
      paramView = new bilx(this);
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559678, this.a.jdField_a_of_type_ComTencentWidgetXListView, false);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363667));
      paramView.b = ((TextView)localView.findViewById(2131367635));
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131367634));
      localView.setTag(paramView);
      localObject = this.a.jdField_a_of_type_Bipa.a(paramInt);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramView.b.setText(String.valueOf(this.a.jdField_a_of_type_Bipa.a(paramInt)));
      i = (int)(10.0F * this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a);
      if (paramInt != 0) {
        break label222;
      }
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839448);
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(i, 0, i, 0);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new bilw(this, paramInt, (String)localObject));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (bilx)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label222:
      if (paramInt == getCount() - 1) {
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839439);
      } else {
        paramView.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839442);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bilv
 * JD-Core Version:    0.7.0.1
 */