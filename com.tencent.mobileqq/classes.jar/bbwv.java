import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class bbwv
  implements bbvf
{
  private TextView a;
  protected List<bbvg> a;
  protected View b;
  protected TextView c;
  
  public bbwv() {}
  
  public bbwv(ViewGroup paramViewGroup, int paramInt)
  {
    this.b = LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup, false);
    this.c = ((TextView)this.b.findViewById(2131371277));
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add(new bbww(this.b.findViewById(2131368751)));
    this.jdField_a_of_type_JavaUtilList.add(new bbww(this.b.findViewById(2131368757)));
    this.jdField_a_of_type_JavaUtilList.add(new bbww(this.b.findViewById(2131368763)));
    if ((paramInt == 2131559633) || (paramInt == 2131562830))
    {
      this.jdField_a_of_type_JavaUtilList.add(new bbww(this.b.findViewById(2131368769)));
      this.jdField_a_of_type_JavaUtilList.add(new bbww(this.b.findViewById(2131368770)));
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
  
  public List<bbvg> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public TextView b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwv
 * JD-Core Version:    0.7.0.1
 */