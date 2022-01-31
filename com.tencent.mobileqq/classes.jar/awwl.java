import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class awwl
  extends awyh
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public awwl(View paramView)
  {
    super(paramView);
  }
  
  public awwl(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  protected void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.b.findViewById(2131376246));
    this.jdField_a_of_type_AndroidViewView = this.b.findViewById(2131378332);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public TextView e()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwl
 * JD-Core Version:    0.7.0.1
 */