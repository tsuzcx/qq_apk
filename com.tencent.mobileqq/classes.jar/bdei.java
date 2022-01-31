import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bdei
  implements View.OnClickListener
{
  bdei(bdef parambdef, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    bfhg.b("NewUpgradeDialog", bfeh.a(10010, bdef.a(), 2, 200));
    bfef.a().a(17, bfeh.a(10010, bdef.a(), 2, 200));
    if (bdef.a() == 2) {
      azmj.b(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bdef, 0);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        bfkb.a().b(bdef.a(this.jdField_a_of_type_Bdef));
        this.jdField_a_of_type_Bdef.dismiss();
      }
      bdef.a(this.jdField_a_of_type_Bdef, true);
      return;
      azmj.b(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdei
 * JD-Core Version:    0.7.0.1
 */