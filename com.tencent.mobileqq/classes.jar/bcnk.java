import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class bcnk
  implements bcns
{
  protected View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcnt jdField_a_of_type_Bcnt;
  private List<bcnt> jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public bcnk() {}
  
  public bcnk(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371538));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new bcnn(this.jdField_a_of_type_AndroidViewView.findViewById(2131369008)));
    this.jdField_a_of_type_JavaUtilList.add(new bcnn(this.jdField_a_of_type_AndroidViewView.findViewById(2131369014)));
    this.jdField_a_of_type_JavaUtilList.add(new bcnn(this.jdField_a_of_type_AndroidViewView.findViewById(2131369020)));
    this.jdField_a_of_type_JavaUtilList.add(new bcnn(this.jdField_a_of_type_AndroidViewView.findViewById(2131369026)));
    this.jdField_a_of_type_JavaUtilList.add(new bcnn(this.jdField_a_of_type_AndroidViewView.findViewById(2131369027)));
    this.jdField_a_of_type_Bcnt = new bcnn(this.jdField_a_of_type_AndroidViewView.findViewById(2131369028));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List<bcnt> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnk
 * JD-Core Version:    0.7.0.1
 */