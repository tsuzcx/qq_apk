import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public class awwx
  extends awwy
{
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  public ImageView b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public awwx(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377350));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131369115));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131367799));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131364810));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376880));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376715));
    this.d = ((TextView)localView.findViewById(2131365042));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_c_of_type_AndroidWidgetTextView.getContext().getResources().getColor(2131166791));
      }
      if (this.d != null) {
        this.d.setTextColor(this.d.getContext().getResources().getColor(2131166791));
      }
    }
    do
    {
      return;
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#737373"));
      }
    } while (this.d == null);
    this.d.setTextColor(Color.parseColor("#737373"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwx
 * JD-Core Version:    0.7.0.1
 */