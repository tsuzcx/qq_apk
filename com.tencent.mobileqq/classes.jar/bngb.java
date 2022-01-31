import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class bngb
  extends bmnh
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public bngb(@NonNull bnfx parambnfx)
  {
    super(parambnfx);
  }
  
  private void d()
  {
    bdgm.a(a().getActivity(), 230).setMessage(2131718641).setPositiveButton(2131718149, new bnge(this)).setNegativeButton(2131691089, new bngd(this)).show();
  }
  
  public bnfx a()
  {
    return (bnfx)this.jdField_a_of_type_Bmnj;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131374600));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131366548));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bngc(this));
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
 * Qualified Name:     bngb
 * JD-Core Version:    0.7.0.1
 */