import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class bnbp
  extends bmiv
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public bnbp(@NonNull bnbl parambnbl)
  {
    super(parambnbl);
  }
  
  private void d()
  {
    bdcd.a(a().getActivity(), 230).setMessage(2131718629).setPositiveButton(2131718137, new bnbs(this)).setNegativeButton(2131691088, new bnbr(this)).show();
  }
  
  public bnbl a()
  {
    return (bnbl)this.jdField_a_of_type_Bmix;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131374549));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131366542));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bnbq(this));
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
 * Qualified Name:     bnbp
 * JD-Core Version:    0.7.0.1
 */