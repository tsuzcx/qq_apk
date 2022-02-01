import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class bcpi
  implements bcns
{
  private TextView a;
  protected List<bcnt> a;
  protected View b;
  protected TextView c;
  
  public bcpi() {}
  
  public bcpi(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131371538));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new bcpj(this.b.findViewById(2131369008)));
    this.jdField_a_of_type_JavaUtilList.add(new bcpj(this.b.findViewById(2131369014)));
    this.jdField_a_of_type_JavaUtilList.add(new bcpj(this.b.findViewById(2131369020)));
    if ((paramInt == 2131559675) || (paramInt == 2131562814))
    {
      this.jdField_a_of_type_JavaUtilList.add(new bcpj(this.b.findViewById(2131369026)));
      this.jdField_a_of_type_JavaUtilList.add(new bcpj(this.b.findViewById(2131369027)));
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
  
  public List<bcnt> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpi
 * JD-Core Version:    0.7.0.1
 */