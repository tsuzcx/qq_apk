import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class bpit
  extends botu
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public bpit(@NonNull bpip parambpip)
  {
    super(parambpip);
  }
  
  private void b()
  {
    bhdj.a(a().getActivity(), 230).setMessage(2131717507).setPositiveButton(2131717020, new bpiw(this)).setNegativeButton(2131691037, new bpiv(this)).show();
  }
  
  public bpip a()
  {
    return (bpip)this.jdField_a_of_type_Botw;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131375467));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131367006));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bpiu(this));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpit
 * JD-Core Version:    0.7.0.1
 */