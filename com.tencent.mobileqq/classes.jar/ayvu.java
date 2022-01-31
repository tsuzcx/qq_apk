import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ayvu
  implements aywc
{
  protected View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aywd jdField_a_of_type_Aywd;
  private List<aywd> jdField_a_of_type_JavaUtilList;
  private TextView b;
  
  public ayvu() {}
  
  public ayvu(ViewGroup paramViewGroup, int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370721));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new ayvx(this.jdField_a_of_type_AndroidViewView.findViewById(2131368443)));
    this.jdField_a_of_type_JavaUtilList.add(new ayvx(this.jdField_a_of_type_AndroidViewView.findViewById(2131368449)));
    this.jdField_a_of_type_JavaUtilList.add(new ayvx(this.jdField_a_of_type_AndroidViewView.findViewById(2131368455)));
    this.jdField_a_of_type_JavaUtilList.add(new ayvx(this.jdField_a_of_type_AndroidViewView.findViewById(2131368461)));
    this.jdField_a_of_type_JavaUtilList.add(new ayvx(this.jdField_a_of_type_AndroidViewView.findViewById(2131368462)));
    this.jdField_a_of_type_Aywd = new ayvx(this.jdField_a_of_type_AndroidViewView.findViewById(2131368463));
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List<aywd> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayvu
 * JD-Core Version:    0.7.0.1
 */