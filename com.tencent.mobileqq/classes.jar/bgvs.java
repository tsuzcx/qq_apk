import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgvs
  implements View.OnClickListener
{
  bgvs(bgvp parambgvp, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    bjko.b("NewUpgradeDialog", bjhp.a(10010, bgvp.a(), 2, 200));
    bjhn.a().a(17, bjhp.a(10010, bgvp.a(), 2, 200));
    if (bgvp.a() == 2) {
      bdla.b(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bgvp, 0);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        bjna.a().b(bgvp.a(this.jdField_a_of_type_Bgvp));
        this.jdField_a_of_type_Bgvp.dismiss();
      }
      bgvp.a(this.jdField_a_of_type_Bgvp, true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.b(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvs
 * JD-Core Version:    0.7.0.1
 */