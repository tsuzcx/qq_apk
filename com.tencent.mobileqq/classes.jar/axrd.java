import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;

public class axrd
  extends axrc
{
  protected View a;
  
  protected int a()
  {
    return 2131561261;
  }
  
  protected LabelContainer a(View paramView, int paramInt1, axid paramaxid, int paramInt2)
  {
    paramaxid = (ImageView)paramView.findViewById(2131380151);
    if (paramInt1 == 7) {
      paramaxid.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 0)
      {
        paramaxid = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        paramaxid.topMargin = zby.b(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramView.setLayoutParams(paramaxid);
      }
      paramInt1 = zby.b(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramInt2 = zby.b(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramView = (LabelContainer)paramView.findViewById(2131369508);
      paramView.setSpace(paramInt1, paramInt2);
      return paramView;
      paramaxid.setImageResource(b[paramInt1]);
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout, View paramView)
  {
    super.a(paramContext, paramLinearLayout);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(axid[] paramArrayOfaxid)
  {
    if (super.a(paramArrayOfaxid))
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
 * Qualified Name:     axrd
 * JD-Core Version:    0.7.0.1
 */