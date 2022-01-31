import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;

public class avfk
  extends avfj
{
  protected View a;
  
  protected int a()
  {
    return 2131561030;
  }
  
  protected LabelContainer a(View paramView, int paramInt1, auwl paramauwl, int paramInt2)
  {
    paramauwl = (ImageView)paramView.findViewById(2131379168);
    if (paramInt1 == 7) {
      paramauwl.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 0)
      {
        paramauwl = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        paramauwl.topMargin = xee.b(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramView.setLayoutParams(paramauwl);
      }
      paramInt1 = xee.b(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramInt2 = xee.b(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramView = (LabelContainer)paramView.findViewById(2131369102);
      paramView.setSpace(paramInt1, paramInt2);
      return paramView;
      paramauwl.setImageResource(b[paramInt1]);
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout, View paramView)
  {
    super.a(paramContext, paramLinearLayout);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(auwl[] paramArrayOfauwl)
  {
    if (super.a(paramArrayOfauwl))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avfk
 * JD-Core Version:    0.7.0.1
 */