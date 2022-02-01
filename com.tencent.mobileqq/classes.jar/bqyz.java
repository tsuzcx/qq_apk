import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class bqyz
  extends bqgi
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public bqyz(@NonNull bqyv parambqyv)
  {
    super(parambqyv);
  }
  
  private void d()
  {
    bhlq.a(a().getActivity(), 230).setMessage(2131716910).setPositiveButton(2131716423, new bqzc(this)).setNegativeButton(2131690912, new bqzb(this)).show();
  }
  
  public bqyv a()
  {
    return (bqyv)this.jdField_a_of_type_Bqgk;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131375457));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131366864));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bqza(this));
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
 * Qualified Name:     bqyz
 * JD-Core Version:    0.7.0.1
 */