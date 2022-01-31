import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.armap.map.RoundCorneredFrameLayout;

public class bleh
  extends RecyclerView.ViewHolder
{
  public FrameLayout a;
  public ImageView a;
  public TextView a;
  public RoundCorneredFrameLayout a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  
  public bleh(blee paramblee, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131379692));
    this.jdField_a_of_type_ComTencentMobileqqArmapMapRoundCorneredFrameLayout = ((RoundCorneredFrameLayout)paramView.findViewById(2131368471));
    this.c = ((ImageView)paramView.findViewById(2131368509));
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367791));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368512));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367792));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368513));
  }
  
  public void a()
  {
    this.itemView.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bleh
 * JD-Core Version:    0.7.0.1
 */