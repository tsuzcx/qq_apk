import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfnb
  implements View.OnClickListener
{
  bfnb(bfmy parambfmy, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    bhzm.b("NewUpgradeDialog", bhwn.a(10010, bfmy.a(), 2, 200));
    bhwl.a().a(17, bhwn.a(10010, bfmy.a(), 2, 200));
    if (bfmy.a() == 2) {
      bcef.b(null, "dc00898", "", "", "0X8008F80", "0X8008F80", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bfmy, 0);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        biby.a().b(bfmy.a(this.jdField_a_of_type_Bfmy));
        this.jdField_a_of_type_Bfmy.dismiss();
      }
      bfmy.a(this.jdField_a_of_type_Bfmy, true);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcef.b(null, "dc00898", "", "", "0X8008F83", "0X8008F83", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfnb
 * JD-Core Version:    0.7.0.1
 */