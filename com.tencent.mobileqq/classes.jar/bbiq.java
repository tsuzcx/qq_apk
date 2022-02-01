import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class bbiq
  implements bbha
{
  private TextView a;
  protected List<bbhb> a;
  protected View b;
  protected TextView c;
  
  public bbiq() {}
  
  public bbiq(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131371352));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new bbir(this.b.findViewById(2131368850)));
    this.jdField_a_of_type_JavaUtilList.add(new bbir(this.b.findViewById(2131368856)));
    this.jdField_a_of_type_JavaUtilList.add(new bbir(this.b.findViewById(2131368862)));
    if ((paramInt == 2131559640) || (paramInt == 2131562743))
    {
      this.jdField_a_of_type_JavaUtilList.add(new bbir(this.b.findViewById(2131368868)));
      this.jdField_a_of_type_JavaUtilList.add(new bbir(this.b.findViewById(2131368869)));
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
  
  public List<bbhb> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbiq
 * JD-Core Version:    0.7.0.1
 */