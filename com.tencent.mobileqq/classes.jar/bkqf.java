import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class bkqf
  extends bjxl
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public bkqf(@NonNull bkqb parambkqb)
  {
    super(parambkqb);
  }
  
  private void d()
  {
    bbdj.a(a().getActivity(), 230).setMessage(2131718254).setPositiveButton(2131717766, new bkqi(this)).setNegativeButton(2131691035, new bkqh(this)).show();
  }
  
  public bkqb a()
  {
    return (bkqb)this.jdField_a_of_type_Bjxn;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131374094));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131366436));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bkqg(this));
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
 * Qualified Name:     bkqf
 * JD-Core Version:    0.7.0.1
 */