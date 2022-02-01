import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

public class bnhc
  extends bnbj
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public bnhc(ViewStub paramViewStub)
  {
    super(paramViewStub);
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366359);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366358));
  }
  
  public void b()
  {
    a();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131692435);
  }
  
  public void c()
  {
    if (a())
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void d()
  {
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhc
 * JD-Core Version:    0.7.0.1
 */