import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class anmc
  implements DialogInterface.OnClickListener
{
  anmc(anmb paramanmb, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = anmb.a(this.jdField_a_of_type_Anmb);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < anmb.a(this.jdField_a_of_type_Anmb).size())
        {
          anme localanme = (anme)anmb.a(this.jdField_a_of_type_Anmb).get(i);
          if (localanme == null) {
            break label269;
          }
          localanme.a.onClick(anmb.a(this.jdField_a_of_type_Anmb), paramInt);
          break label269;
        }
      }
      finally {}
      try
      {
        anmb.a(this.jdField_a_of_type_Anmb, false);
        if ((anmb.a(this.jdField_a_of_type_Anmb) != null) && (anmb.a(this.jdField_a_of_type_Anmb).isShowing())) {
          anmb.a(this.jdField_a_of_type_Anmb).dismiss();
        }
        anmb.a(this.jdField_a_of_type_Anmb, this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception paramDialogInterface)
      {
        QLog.e("ark.download.ctrl", 1, "ark.dctrl [onClickListener] clicked dismiss exception:", paramDialogInterface);
        continue;
        if (paramInt != 0) {
          continue;
        }
        azmj.a(null, "dc00898", "", "", "0X800AD1E", "0X800AD1E", 3, 0, String.valueOf(anmb.a(this.jdField_a_of_type_Anmb)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [onClickListener] which=", Integer.valueOf(paramInt), ",cost=", Long.valueOf(Math.abs(System.currentTimeMillis() - anmb.a(this.jdField_a_of_type_Anmb))) });
      if (paramInt == 1)
      {
        azmj.a(null, "dc00898", "", "", "0X800AD1D", "0X800AD1D", 3, 0, String.valueOf(anmb.a(this.jdField_a_of_type_Anmb)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      label269:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmc
 * JD-Core Version:    0.7.0.1
 */