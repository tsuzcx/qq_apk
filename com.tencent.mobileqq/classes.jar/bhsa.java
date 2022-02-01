import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class bhsa
  extends bhvm
{
  protected List<Friend> a;
  
  public bhsa(List<Friend> paramList)
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
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.getLayoutInflater().inflate(2131562784, paramViewGroup, false);
      paramView = new bhsd();
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369251));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379724));
      paramView.b = ((TextView)localView.findViewById(2131379845));
      localView.setTag(paramView);
    }
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (bhsd)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
    Object localObject1 = (Friend)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    label179:
    Object localObject2;
    if ((((Friend)localObject1).c == null) || ("".equals(((Friend)localObject1).c)))
    {
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Friend)localObject1).b);
      if ((((Friend)localObject1).d == null) || ("".equals(((Friend)localObject1).d))) {
        ((Friend)localObject1).d = bhvv.a(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a(), ((Friend)localObject1).a);
      }
      localObject2 = bhvs.a().a(((Friend)localObject1).d);
      if (localObject2 != null) {
        break label319;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840312);
      localObject2 = paramView.jdField_a_of_type_AndroidWidgetImageView;
      bhvs.a().a(((Friend)localObject1).d, new bhsb(this, (ImageView)localObject2));
      label274:
      if (!this.jdField_a_of_type_ComTencentOpenAgentFriendChooser.a.a(((Friend)localObject1).a)) {
        break label331;
      }
      paramView.b.setText(2131691648);
    }
    for (;;)
    {
      break;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Friend)localObject1).c);
      break label179;
      label319:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
      break label274;
      label331:
      paramView.b.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsa
 * JD-Core Version:    0.7.0.1
 */