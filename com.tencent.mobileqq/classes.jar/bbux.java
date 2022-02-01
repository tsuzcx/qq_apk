import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class bbux
  implements bbvf
{
  protected View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbvg jdField_a_of_type_Bbvg;
  private List<bbvg> jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public bbux() {}
  
  public bbux(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371277));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new bbva(this.jdField_a_of_type_AndroidViewView.findViewById(2131368751)));
    this.jdField_a_of_type_JavaUtilList.add(new bbva(this.jdField_a_of_type_AndroidViewView.findViewById(2131368757)));
    this.jdField_a_of_type_JavaUtilList.add(new bbva(this.jdField_a_of_type_AndroidViewView.findViewById(2131368763)));
    this.jdField_a_of_type_JavaUtilList.add(new bbva(this.jdField_a_of_type_AndroidViewView.findViewById(2131368769)));
    this.jdField_a_of_type_JavaUtilList.add(new bbva(this.jdField_a_of_type_AndroidViewView.findViewById(2131368770)));
    this.jdField_a_of_type_Bbvg = new bbva(this.jdField_a_of_type_AndroidViewView.findViewById(2131368771));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List<bbvg> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbux
 * JD-Core Version:    0.7.0.1
 */