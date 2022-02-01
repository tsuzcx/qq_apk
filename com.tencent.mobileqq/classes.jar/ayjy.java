import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayjy
  extends ayjw
  implements View.OnClickListener
{
  protected int a()
  {
    return 2131561300;
  }
  
  protected LabelContainer a(View paramView, int paramInt1, ayaw paramayaw, int paramInt2)
  {
    ((TextView)paramView.findViewById(2131380338)).setText(c[paramInt1]);
    paramInt1 = zft.b(this.jdField_a_of_type_AndroidContentContext, 6.0F);
    int i = zft.b(this.jdField_a_of_type_AndroidContentContext, 6.0F);
    LabelContainer localLabelContainer = (LabelContainer)paramView.findViewById(2131369601);
    localLabelContainer.setSpace(paramInt1, i);
    paramView.setTag(paramayaw);
    paramView.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == paramInt2 - 1)
    {
      paramInt1 = zft.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramView.setBackgroundResource(2130839447);
      paramView.setPadding(0, paramInt1, 0, paramInt1);
    }
    return localLabelContainer;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ayaw))
    {
      ayaw localayaw = (ayaw)paramView.getTag();
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChooseInterestTagActivity.class);
      localIntent.putExtra("interest_tag_type", localayaw.jdField_a_of_type_Int);
      localIntent.putExtra("is_from_judge", false);
      localIntent.putExtra("is_from_nearby", true);
      localIntent.putExtra("from_where", "NearbyPeopleProfileActivity");
      localIntent.putParcelableArrayListExtra("choosed_interest_tags", localayaw.jdField_a_of_type_JavaUtilArrayList);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 11);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayjy
 * JD-Core Version:    0.7.0.1
 */