import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;

public class aydh
  extends aydg
{
  protected View a;
  
  protected int a()
  {
    return 2131561235;
  }
  
  protected LabelContainer a(View paramView, int paramInt1, axug paramaxug, int paramInt2)
  {
    paramaxug = (ImageView)paramView.findViewById(2131380397);
    if (paramInt1 == 7) {
      paramaxug.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 0)
      {
        paramaxug = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        paramaxug.topMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramView.setLayoutParams(paramaxug);
      }
      paramInt1 = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramInt2 = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramView = (LabelContainer)paramView.findViewById(2131369761);
      paramView.setSpace(paramInt1, paramInt2);
      return paramView;
      paramaxug.setImageResource(b[paramInt1]);
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout, View paramView)
  {
    super.a(paramContext, paramLinearLayout);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(axug[] paramArrayOfaxug)
  {
    if (super.a(paramArrayOfaxug))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydh
 * JD-Core Version:    0.7.0.1
 */