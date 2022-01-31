import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class bizc
  extends bifz
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public bizc(@NonNull biyy parambiyy)
  {
    super(parambiyy);
  }
  
  private void d()
  {
    babr.a(a().getActivity(), 230).setMessage(2131652424).setPositiveButton(2131651963, new bizf(this)).setNegativeButton(2131625463, new bize(this)).show();
  }
  
  public biyy a()
  {
    return (biyy)this.jdField_a_of_type_Bigb;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131308371));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131300826));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bizd(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizc
 * JD-Core Version:    0.7.0.1
 */