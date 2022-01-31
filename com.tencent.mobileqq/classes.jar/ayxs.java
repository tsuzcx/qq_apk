import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ayxs
  implements aywc
{
  private TextView a;
  protected List<aywd> a;
  protected View b;
  protected TextView c;
  
  public ayxs() {}
  
  public ayxs(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131370721));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new ayxt(this.b.findViewById(2131368443)));
    this.jdField_a_of_type_JavaUtilList.add(new ayxt(this.b.findViewById(2131368449)));
    this.jdField_a_of_type_JavaUtilList.add(new ayxt(this.b.findViewById(2131368455)));
    if ((paramInt == 2131559501) || (paramInt == 2131562592))
    {
      this.jdField_a_of_type_JavaUtilList.add(new ayxt(this.b.findViewById(2131368461)));
      this.jdField_a_of_type_JavaUtilList.add(new ayxt(this.b.findViewById(2131368462)));
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
  
  public List<aywd> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxs
 * JD-Core Version:    0.7.0.1
 */