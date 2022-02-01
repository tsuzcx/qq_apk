import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class bcpo
  implements bcny
{
  private TextView a;
  protected List<bcnz> a;
  protected View b;
  protected TextView c;
  
  public bcpo() {}
  
  public bcpo(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131371384));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new bcpp(this.b.findViewById(2131368825)));
    this.jdField_a_of_type_JavaUtilList.add(new bcpp(this.b.findViewById(2131368831)));
    this.jdField_a_of_type_JavaUtilList.add(new bcpp(this.b.findViewById(2131368837)));
    if ((paramInt == 2131559638) || (paramInt == 2131562864))
    {
      this.jdField_a_of_type_JavaUtilList.add(new bcpp(this.b.findViewById(2131368843)));
      this.jdField_a_of_type_JavaUtilList.add(new bcpp(this.b.findViewById(2131368844)));
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
  
  public List<bcnz> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpo
 * JD-Core Version:    0.7.0.1
 */