import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class bcpk
  extends bcpo
{
  public View a;
  public ImageView a;
  public TextView a;
  public LinearLayout b;
  public TextView b;
  
  public bcpk() {}
  
  public bcpk(ViewGroup paramViewGroup)
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562869, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131371405);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369569));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368320));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365413));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370112));
  }
  
  public LinearLayout a()
  {
    return this.jdField_b_of_type_AndroidWidgetLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpk
 * JD-Core Version:    0.7.0.1
 */