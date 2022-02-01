import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgdo
  implements View.OnClickListener
{
  bgdo(bgdl parambgdl, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    bisy.b("NewUpgradeDialog", bipz.a(10010, bgdl.a(), 2, 200));
    bipx.a().a(17, bipz.a(10010, bgdl.a(), 2, 200));
    if (bgdl.a() == 2) {
      bcst.b(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bgdl, 0);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        bivr.a().b(bgdl.a(this.jdField_a_of_type_Bgdl));
        this.jdField_a_of_type_Bgdl.dismiss();
      }
      bgdl.a(this.jdField_a_of_type_Bgdl, true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcst.b(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdo
 * JD-Core Version:    0.7.0.1
 */