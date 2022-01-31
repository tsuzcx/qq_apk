import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.armap.map.RoundCorneredFrameLayout;

public class bizn
  extends RecyclerView.ViewHolder
{
  public FrameLayout a;
  public ImageView a;
  public TextView a;
  public RoundCorneredFrameLayout a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  
  public bizn(bizk parambizk, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131379023));
    this.jdField_a_of_type_ComTencentMobileqqArmapMapRoundCorneredFrameLayout = ((RoundCorneredFrameLayout)paramView.findViewById(2131368324));
    this.c = ((ImageView)paramView.findViewById(2131368337));
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367662));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368340));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367663));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368341));
  }
  
  public void a()
  {
    this.itemView.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizn
 * JD-Core Version:    0.7.0.1
 */