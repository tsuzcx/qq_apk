import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;

public class atoi
  extends atoh
{
  protected View a;
  
  protected int a()
  {
    return 2131560848;
  }
  
  protected LabelContainer a(View paramView, int paramInt1, atfk paramatfk, int paramInt2)
  {
    paramatfk = (ImageView)paramView.findViewById(2131378551);
    if (paramInt1 == 7) {
      paramatfk.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() != 0)
      {
        paramatfk = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        paramatfk.topMargin = vpp.b(this.jdField_a_of_type_AndroidContentContext, 16.0F);
        paramView.setLayoutParams(paramatfk);
      }
      paramInt1 = vpp.b(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramInt2 = vpp.b(this.jdField_a_of_type_AndroidContentContext, 7.0F);
      paramView = (LabelContainer)paramView.findViewById(2131368874);
      paramView.setSpace(paramInt1, paramInt2);
      return paramView;
      paramatfk.setImageResource(b[paramInt1]);
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout, View paramView)
  {
    super.a(paramContext, paramLinearLayout);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public boolean a(atfk[] paramArrayOfatfk)
  {
    if (super.a(paramArrayOfatfk))
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
 * Qualified Name:     atoi
 * JD-Core Version:    0.7.0.1
 */