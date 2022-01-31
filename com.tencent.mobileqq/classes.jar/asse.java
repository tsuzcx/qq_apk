import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;

public class asse
  extends assd
{
  protected View a;
  
  protected int a()
  {
    return 2131495269;
  }
  
  protected LabelContainer a(View paramView, int paramInt1, asjg paramasjg, int paramInt2)
  {
    paramasjg = (ImageView)paramView.findViewById(2131312727);
    if (paramInt1 == 7) {
      paramasjg.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 0)
      {
        paramasjg = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        paramasjg.topMargin = vct.a(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramView.setLayoutParams(paramasjg);
      }
      paramInt1 = vct.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramInt2 = vct.a(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramView = (LabelContainer)paramView.findViewById(2131303208);
      paramView.setSpace(paramInt1, paramInt2);
      return paramView;
      paramasjg.setImageResource(b[paramInt1]);
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout, View paramView)
  {
    super.a(paramContext, paramLinearLayout);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(asjg[] paramArrayOfasjg)
  {
    if (super.a(paramArrayOfasjg))
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
 * Qualified Name:     asse
 * JD-Core Version:    0.7.0.1
 */