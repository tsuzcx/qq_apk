import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class bntb
  extends bnec
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public bntb(@NonNull bnsx parambnsx)
  {
    super(parambnsx);
  }
  
  private void b()
  {
    bfur.a(a().getActivity(), 230).setMessage(2131717144).setPositiveButton(2131716657, new bnte(this)).setNegativeButton(2131690952, new bntd(this)).show();
  }
  
  public bnsx a()
  {
    return (bnsx)this.jdField_a_of_type_Bnee;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131375225));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131366888));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new bntc(this));
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
 * Qualified Name:     bntb
 * JD-Core Version:    0.7.0.1
 */