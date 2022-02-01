import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class bcpc
  extends bcpe
{
  public LinearLayout a;
  
  public bcpc(ViewGroup paramViewGroup)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562817, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131371538));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.b.findViewById(2131370281));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView = this.b.findViewById(2131371558);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369722));
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpc
 * JD-Core Version:    0.7.0.1
 */