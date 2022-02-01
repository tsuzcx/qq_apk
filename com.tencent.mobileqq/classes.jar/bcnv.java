import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class bcnv
  extends bcpp
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public bcnv(View paramView)
  {
    super(paramView);
  }
  
  public bcnv(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    this.a = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377358));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377357));
    this.c = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377356));
    this.d = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131377234));
  }
  
  public TextView e()
  {
    return this.a;
  }
  
  public TextView f()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public TextView g()
  {
    return this.c;
  }
  
  public TextView h()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnv
 * JD-Core Version:    0.7.0.1
 */