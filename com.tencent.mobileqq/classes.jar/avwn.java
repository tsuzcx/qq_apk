import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class avwn
  implements avwv
{
  protected View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avww jdField_a_of_type_Avww;
  private List<avww> jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public avwn() {}
  
  public avwn(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304741));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new avwq(this.jdField_a_of_type_AndroidViewView.findViewById(2131302664)));
    this.jdField_a_of_type_JavaUtilList.add(new avwq(this.jdField_a_of_type_AndroidViewView.findViewById(2131302670)));
    this.jdField_a_of_type_JavaUtilList.add(new avwq(this.jdField_a_of_type_AndroidViewView.findViewById(2131302676)));
    this.jdField_a_of_type_JavaUtilList.add(new avwq(this.jdField_a_of_type_AndroidViewView.findViewById(2131302682)));
    this.jdField_a_of_type_JavaUtilList.add(new avwq(this.jdField_a_of_type_AndroidViewView.findViewById(2131302683)));
    this.jdField_a_of_type_Avww = new avwq(this.jdField_a_of_type_AndroidViewView.findViewById(2131302684));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List<avww> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwn
 * JD-Core Version:    0.7.0.1
 */