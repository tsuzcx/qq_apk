import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhdp
  implements View.OnClickListener
{
  bhdp(bhdm parambhdm, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    bjtx.b("NewUpgradeDialog", bjqy.a(10010, bhdm.a(), 2, 200));
    bjqw.a().a(17, bjqy.a(10010, bhdm.a(), 2, 200));
    if (bhdm.a() == 2) {
      bdll.b(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bhdm, 0);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        bjwq.a().b(bhdm.a(this.jdField_a_of_type_Bhdm));
        this.jdField_a_of_type_Bhdm.dismiss();
      }
      bhdm.a(this.jdField_a_of_type_Bhdm, true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdll.b(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdp
 * JD-Core Version:    0.7.0.1
 */