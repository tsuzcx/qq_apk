import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class bcpi
  extends bcpk
{
  public LinearLayout a;
  
  public bcpi(ViewGroup paramViewGroup)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562867, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131371384));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.b.findViewById(2131370112));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView = this.b.findViewById(2131371405);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369569));
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpi
 * JD-Core Version:    0.7.0.1
 */