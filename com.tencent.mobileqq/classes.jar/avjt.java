import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;

public class avjt
  extends avjs
{
  protected View a;
  
  protected int a()
  {
    return 2131561048;
  }
  
  protected LabelContainer a(View paramView, int paramInt1, avau paramavau, int paramInt2)
  {
    paramavau = (ImageView)paramView.findViewById(2131379226);
    if (paramInt1 == 7) {
      paramavau.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 0)
      {
        paramavau = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        paramavau.topMargin = xin.b(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramView.setLayoutParams(paramavau);
      }
      paramInt1 = xin.b(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramInt2 = xin.b(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramView = (LabelContainer)paramView.findViewById(2131369120);
      paramView.setSpace(paramInt1, paramInt2);
      return paramView;
      paramavau.setImageResource(b[paramInt1]);
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout, View paramView)
  {
    super.a(paramContext, paramLinearLayout);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(avau[] paramArrayOfavau)
  {
    if (super.a(paramArrayOfavau))
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
 * Qualified Name:     avjt
 * JD-Core Version:    0.7.0.1
 */