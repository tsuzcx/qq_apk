import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.datamodel.Friend;
import java.util.List;

public class bbwn
  extends bbzt
{
  protected List<Friend> a;
  
  public bbwn(List<Friend> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getLayoutInflater().inflate(2131496812, paramViewGroup, false);
      paramViewGroup = new bbwq();
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302951));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131312436));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131312528));
      paramView.setTag(paramViewGroup);
    }
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      return paramView;
      paramViewGroup = (bbwq)paramView.getTag();
    }
    Friend localFriend = (Friend)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if ((localFriend.c == null) || ("".equals(localFriend.c)))
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFriend.b);
      if ((localFriend.d == null) || ("".equals(localFriend.d))) {
        localFriend.d = bcac.a(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(), localFriend.a);
      }
      localObject = bbzz.a().a(localFriend.d);
      if (localObject != null) {
        break label290;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839687);
      localObject = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      bbzz.a().a(localFriend.d, new bbwo(this, (ImageView)localObject));
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a.a(localFriend.a)) {
        break label302;
      }
      paramViewGroup.b.setText(2131626262);
      return paramView;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localFriend.c);
      break;
      label290:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
    label302:
    paramViewGroup.b.setText("");
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbwn
 * JD-Core Version:    0.7.0.1
 */