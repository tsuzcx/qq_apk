import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class bcnq
  implements bcny
{
  protected View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcnz jdField_a_of_type_Bcnz;
  private List<bcnz> jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public bcnq() {}
  
  public bcnq(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371384));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new bcnt(this.jdField_a_of_type_AndroidViewView.findViewById(2131368825)));
    this.jdField_a_of_type_JavaUtilList.add(new bcnt(this.jdField_a_of_type_AndroidViewView.findViewById(2131368831)));
    this.jdField_a_of_type_JavaUtilList.add(new bcnt(this.jdField_a_of_type_AndroidViewView.findViewById(2131368837)));
    this.jdField_a_of_type_JavaUtilList.add(new bcnt(this.jdField_a_of_type_AndroidViewView.findViewById(2131368843)));
    this.jdField_a_of_type_JavaUtilList.add(new bcnt(this.jdField_a_of_type_AndroidViewView.findViewById(2131368844)));
    this.jdField_a_of_type_Bcnz = new bcnt(this.jdField_a_of_type_AndroidViewView.findViewById(2131368845));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List<bcnz> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnq
 * JD-Core Version:    0.7.0.1
 */