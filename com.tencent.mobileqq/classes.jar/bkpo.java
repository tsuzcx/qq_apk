import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class bkpo
  extends bjwu
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public bkpo(@NonNull bkpk parambkpk)
  {
    super(parambkpk);
  }
  
  private void d()
  {
    bbcv.a(a().getActivity(), 230).setMessage(2131718243).setPositiveButton(2131717755, new bkpr(this)).setNegativeButton(2131691035, new bkpq(this)).show();
  }
  
  public bkpk a()
  {
    return (bkpk)this.jdField_a_of_type_Bjww;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131374092));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131366436));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bkpp(this));
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
 * Qualified Name:     bkpo
 * JD-Core Version:    0.7.0.1
 */