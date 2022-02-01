import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.SquareImageView;

public class bbhg
  extends bbhi
{
  public int a;
  public LinearLayout a;
  public TextView a;
  public URLImageView a;
  public SquareImageView a;
  public int b;
  public LinearLayout b;
  public LinearLayout c;
  public LinearLayout d;
  
  public bbhg(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    View localView = a(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378707));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)localView.findViewById(2131377526));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368435));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131369846));
    this.jdField_b_of_type_Int = this.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount();
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131368438));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131372632));
    this.d = ((LinearLayout)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131372633));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbhg
 * JD-Core Version:    0.7.0.1
 */