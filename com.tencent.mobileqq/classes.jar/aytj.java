import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class aytj
  implements ayrt
{
  private TextView a;
  protected List<ayru> a;
  protected View b;
  protected TextView c;
  
  public aytj() {}
  
  public aytj(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131370702));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new aytk(this.b.findViewById(2131368432)));
    this.jdField_a_of_type_JavaUtilList.add(new aytk(this.b.findViewById(2131368438)));
    this.jdField_a_of_type_JavaUtilList.add(new aytk(this.b.findViewById(2131368444)));
    if ((paramInt == 2131559502) || (paramInt == 2131562574))
    {
      this.jdField_a_of_type_JavaUtilList.add(new aytk(this.b.findViewById(2131368450)));
      this.jdField_a_of_type_JavaUtilList.add(new aytk(this.b.findViewById(2131368451)));
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
  
  public List<ayru> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytj
 * JD-Core Version:    0.7.0.1
 */