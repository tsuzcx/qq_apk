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

public class aywk
  extends ayxt
{
  public RelativeLayout b;
  public SquareImageView b;
  public ImageView c;
  public SquareImageView c;
  public TextView e;
  public TextView f;
  public TextView g;
  
  public aywk(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    paramViewGroup.getResources();
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(1);
    localLinearLayout.addView(LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, null, false), new LinearLayout.LayoutParams(-1, -2));
    localLinearLayout.setBackgroundResource(2130849646);
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
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131375933));
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131368002));
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131368820));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368753));
    this.e = ((TextView)paramView.findViewById(2131379025));
    this.f = ((TextView)paramView.findViewById(2131378977));
    this.jdField_c_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)paramView.findViewById(2131375799));
    this.g = ((TextView)paramView.findViewById(2131375800));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.f.setTextColor(this.f.getContext().getResources().getColor(2131166841));
      this.g.setTextColor(this.g.getContext().getResources().getColor(2131166841));
      return;
    }
    this.f.setTextColor(this.f.getContext().getResources().getColor(2131167194));
    this.g.setTextColor(this.g.getContext().getResources().getColor(2131167194));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywk
 * JD-Core Version:    0.7.0.1
 */