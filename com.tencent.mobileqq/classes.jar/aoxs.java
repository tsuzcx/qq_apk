import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aoxs
  implements DialogInterface.OnClickListener
{
  aoxs(aoxr paramaoxr, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = aoxr.a(this.jdField_a_of_type_Aoxr);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < aoxr.a(this.jdField_a_of_type_Aoxr).size())
        {
          aoxu localaoxu = (aoxu)aoxr.a(this.jdField_a_of_type_Aoxr).get(i);
          if (localaoxu == null) {
            break label269;
          }
          localaoxu.a.onClick(aoxr.a(this.jdField_a_of_type_Aoxr), paramInt);
          break label269;
        }
      }
      finally {}
      try
      {
        aoxr.a(this.jdField_a_of_type_Aoxr, false);
        if ((aoxr.a(this.jdField_a_of_type_Aoxr) != null) && (aoxr.a(this.jdField_a_of_type_Aoxr).isShowing())) {
          aoxr.a(this.jdField_a_of_type_Aoxr).dismiss();
        }
        aoxr.a(this.jdField_a_of_type_Aoxr, this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception paramDialogInterface)
      {
        QLog.e("ark.download.ctrl", 1, "ark.dctrl [onClickListener] clicked dismiss exception:", paramDialogInterface);
        continue;
        if (paramInt != 0) {
          continue;
        }
        bcef.a(null, "dc00898", "", "", "0X800AD1E", "0X800AD1E", 3, 0, String.valueOf(aoxr.a(this.jdField_a_of_type_Aoxr)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [onClickListener] which=", Integer.valueOf(paramInt), ",cost=", Long.valueOf(Math.abs(System.currentTimeMillis() - aoxr.a(this.jdField_a_of_type_Aoxr))) });
      if (paramInt == 1)
      {
        bcef.a(null, "dc00898", "", "", "0X800AD1D", "0X800AD1D", 3, 0, String.valueOf(aoxr.a(this.jdField_a_of_type_Aoxr)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      label269:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoxs
 * JD-Core Version:    0.7.0.1
 */