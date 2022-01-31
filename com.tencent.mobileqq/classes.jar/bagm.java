import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ClearableEditText;
import java.lang.ref.SoftReference;

class bagm
  implements View.OnClickListener
{
  bagm(bagl parambagl, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    paramView = bagl.a(this.jdField_a_of_type_Bagl).getText().toString();
    if (paramView != null)
    {
      if ((!axkd.a(paramView)) && (!axkd.b(paramView))) {
        break label78;
      }
      paramView = (Context)bagl.a(this.jdField_a_of_type_Bagl).get();
      if (paramView != null)
      {
        paramView = new bbmy(paramView);
        paramView.d(2000);
        paramView.c(2131654432);
        paramView.a();
      }
    }
    label78:
    do
    {
      return;
      if ((bagl.a(this.jdField_a_of_type_Bagl) != null) || (24 >= paramView.getBytes().length)) {
        break;
      }
      paramView = (Context)bagl.a(this.jdField_a_of_type_Bagl).get();
    } while (paramView == null);
    paramView = new bbmy(paramView);
    paramView.d(2000);
    paramView.c(2131654433);
    paramView.a();
    return;
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bagl, 1);
    }
    this.jdField_a_of_type_Bagl.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bagm
 * JD-Core Version:    0.7.0.1
 */