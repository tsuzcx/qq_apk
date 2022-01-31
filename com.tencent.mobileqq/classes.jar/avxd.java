import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.SquareImageView;

public class avxd
  extends avym
{
  public RelativeLayout b;
  public SquareImageView b;
  public ImageView c;
  public SquareImageView c;
  public TextView e;
  public TextView f;
  public TextView g;
  
  public avxd(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    paramViewGroup.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, null, false), new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setBackgroundResource(2130848905);
    localLinearLayout.setClickable(true);
    localLinearLayout.setFocusable(true);
    this.jdField_b_of_type_AndroidViewView = localLinearLayout;
    a();
  }
  
  protected void a()
  {
    super.a();
  }
  
  protected void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131309642));
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131302236));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131302973));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302919));
    this.e = ((TextView)paramView.findViewById(2131312543));
    this.f = ((TextView)paramView.findViewById(2131312500));
    this.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131309516));
    this.g = ((TextView)paramView.findViewById(2131309517));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.f.setTextColor(this.f.getContext().getResources().getColor(2131101198));
      this.g.setTextColor(this.g.getContext().getResources().getColor(2131101198));
      return;
    }
    this.f.setTextColor(this.f.getContext().getResources().getColor(2131101537));
    this.g.setTextColor(this.g.getContext().getResources().getColor(2131101537));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxd
 * JD-Core Version:    0.7.0.1
 */