import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class awwj
  implements awwq
{
  protected View a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awwr jdField_a_of_type_Awwr;
  private List<awwr> jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public awwj() {}
  
  public awwj(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370397));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369348));
    this.jdField_a_of_type_Awwr = new awwl(this.jdField_a_of_type_AndroidViewView.findViewById(2131368306));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public awwr a()
  {
    return this.jdField_a_of_type_Awwr;
  }
  
  public List<awwr> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwj
 * JD-Core Version:    0.7.0.1
 */