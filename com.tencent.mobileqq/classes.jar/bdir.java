import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bdir
  implements View.OnClickListener
{
  bdir(bdio parambdio, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    bflp.b("NewUpgradeDialog", bfiq.a(10010, bdio.a(), 2, 200));
    bfio.a().a(17, bfiq.a(10010, bdio.a(), 2, 200));
    if (bdio.a() == 2) {
      azqs.b(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bdio, 0);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        bfok.a().b(bdio.a(this.jdField_a_of_type_Bdio));
        this.jdField_a_of_type_Bdio.dismiss();
      }
      bdio.a(this.jdField_a_of_type_Bdio, true);
      return;
      azqs.b(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdir
 * JD-Core Version:    0.7.0.1
 */