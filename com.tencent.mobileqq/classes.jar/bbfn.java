import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bbfn
  implements View.OnClickListener
{
  bbfn(bbfk parambbfk, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    bdii.b("NewUpgradeDialog", bdfj.a(10010, bbfk.a(), 2, 200));
    bdfh.a().a(17, bdfj.a(10010, bbfk.a(), 2, 200));
    if (bbfk.a() == 2) {
      axqy.b(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bbfk, 0);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        bdle.a().b(bbfk.a(this.jdField_a_of_type_Bbfk));
        this.jdField_a_of_type_Bbfk.dismiss();
      }
      bbfk.a(this.jdField_a_of_type_Bbfk, true);
      return;
      axqy.b(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfn
 * JD-Core Version:    0.7.0.1
 */