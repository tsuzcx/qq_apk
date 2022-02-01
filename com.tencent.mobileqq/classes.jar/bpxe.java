import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class bpxe
  extends bpen
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public bpxe(@NonNull bpxa parambpxa)
  {
    super(parambpxa);
  }
  
  private void d()
  {
    bglp.a(a().getActivity(), 230).setMessage(2131716794).setPositiveButton(2131716309, new bpxh(this)).setNegativeButton(2131690912, new bpxg(this)).show();
  }
  
  public bpxa a()
  {
    return (bpxa)this.jdField_a_of_type_Bpep;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131375320));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131366813));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bpxf(this));
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  public void a_(int paramInt, Object paramObject)
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
 * Qualified Name:     bpxe
 * JD-Core Version:    0.7.0.1
 */