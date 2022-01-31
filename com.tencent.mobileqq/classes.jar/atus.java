import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.profile.CustomCoverFragment;

public class atus
  extends RecyclerView.ViewHolder
{
  int jdField_a_of_type_Int;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public atus(CustomCoverFragment paramCustomCoverFragment, View paramView)
  {
    super(paramView);
    paramView.setTag(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131302181));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131311233));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131298186));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramCustomCoverFragment.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramCustomCoverFragment.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atus
 * JD-Core Version:    0.7.0.1
 */