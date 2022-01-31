import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class avyl
  implements avwv
{
  private TextView a;
  protected List<avww> a;
  protected View b;
  protected TextView c;
  
  public avyl() {}
  
  public avyl(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131304741));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new avym(this.b.findViewById(2131302664)));
    this.jdField_a_of_type_JavaUtilList.add(new avym(this.b.findViewById(2131302670)));
    this.jdField_a_of_type_JavaUtilList.add(new avym(this.b.findViewById(2131302676)));
    if ((paramInt == 2131493882) || (paramInt == 2131496770))
    {
      this.jdField_a_of_type_JavaUtilList.add(new avym(this.b.findViewById(2131302682)));
      this.jdField_a_of_type_JavaUtilList.add(new avym(this.b.findViewById(2131302683)));
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
  
  public List<avww> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyl
 * JD-Core Version:    0.7.0.1
 */