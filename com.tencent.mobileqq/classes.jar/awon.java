import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.profile.CustomCoverFragment;

public class awon
  extends RecyclerView.ViewHolder
{
  int jdField_a_of_type_Int;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public awon(CustomCoverFragment paramCustomCoverFragment, View paramView)
  {
    super(paramView);
    paramView.setTag(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367944));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377620));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363798));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramCustomCoverFragment.a);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramCustomCoverFragment.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awon
 * JD-Core Version:    0.7.0.1
 */