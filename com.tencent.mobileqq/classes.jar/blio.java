import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mobileqq.armap.map.RoundCorneredFrameLayout;

public class blio
  extends RecyclerView.ViewHolder
{
  public FrameLayout a;
  public ImageView a;
  public TextView a;
  public RoundCorneredFrameLayout a;
  public ImageView b;
  public TextView b;
  public ImageView c;
  
  public blio(blil paramblil, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131379750));
    this.jdField_a_of_type_ComTencentMobileqqArmapMapRoundCorneredFrameLayout = ((RoundCorneredFrameLayout)paramView.findViewById(2131368482));
    this.c = ((ImageView)paramView.findViewById(2131368520));
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367801));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368523));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367802));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368524));
  }
  
  public void a()
  {
    this.itemView.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blio
 * JD-Core Version:    0.7.0.1
 */