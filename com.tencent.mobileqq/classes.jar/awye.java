import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class awye
  implements awwo
{
  private TextView a;
  protected List<awwp> a;
  protected View b;
  protected TextView c;
  
  public awye() {}
  
  public awye(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131370398));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new awyf(this.b.findViewById(2131368286)));
    this.jdField_a_of_type_JavaUtilList.add(new awyf(this.b.findViewById(2131368292)));
    this.jdField_a_of_type_JavaUtilList.add(new awyf(this.b.findViewById(2131368298)));
    if ((paramInt == 2131559450) || (paramInt == 2131562371))
    {
      this.jdField_a_of_type_JavaUtilList.add(new awyf(this.b.findViewById(2131368304)));
      this.jdField_a_of_type_JavaUtilList.add(new awyf(this.b.findViewById(2131368305)));
    }
  }
  
  public View a()
  {
    return this.b;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public List<awwp> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awye
 * JD-Core Version:    0.7.0.1
 */