import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aydi
  extends aydg
  implements View.OnClickListener
{
  protected int a()
  {
    return 2131561236;
  }
  
  protected LabelContainer a(View paramView, int paramInt1, axug paramaxug, int paramInt2)
  {
    ((TextView)paramView.findViewById(2131380399)).setText(c[paramInt1]);
    paramInt1 = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 6.0F);
    int i = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 6.0F);
    LabelContainer localLabelContainer = (LabelContainer)paramView.findViewById(2131369761);
    localLabelContainer.setSpace(paramInt1, i);
    paramView.setTag(paramaxug);
    paramView.setOnClickListener(this);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() == paramInt2 - 1)
    {
      paramInt1 = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F);
      paramView.setBackgroundResource(2130839503);
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
    if ((paramView.getTag() instanceof axug))
    {
      axug localaxug = (axug)paramView.getTag();
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChooseInterestTagActivity.class);
      localIntent.putExtra("interest_tag_type", localaxug.jdField_a_of_type_Int);
      localIntent.putExtra("is_from_judge", false);
      localIntent.putExtra("is_from_nearby", true);
      localIntent.putExtra("from_where", "NearbyPeopleProfileActivity");
      localIntent.putParcelableArrayListExtra("choosed_interest_tags", localaxug.jdField_a_of_type_JavaUtilArrayList);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 11);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydi
 * JD-Core Version:    0.7.0.1
 */