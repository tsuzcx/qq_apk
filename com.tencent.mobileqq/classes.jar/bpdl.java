import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class bpdl
  extends bpdj<bpdk>
{
  TextView jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370508);
  
  bpdl(bpdk parambpdk, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561765, paramViewGroup, false);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  public void a(bpdk parambpdk, int paramInt)
  {
    super.a(parambpdk, paramInt);
    if (parambpdk != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(parambpdk.a());
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdl
 * JD-Core Version:    0.7.0.1
 */