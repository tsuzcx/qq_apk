import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class apqr
  implements DialogInterface.OnClickListener
{
  apqr(apqq paramapqq, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = apqq.a(this.jdField_a_of_type_Apqq);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < apqq.a(this.jdField_a_of_type_Apqq).size())
        {
          apqt localapqt = (apqt)apqq.a(this.jdField_a_of_type_Apqq).get(i);
          if (localapqt == null) {
            break label269;
          }
          localapqt.a.onClick(apqq.a(this.jdField_a_of_type_Apqq), paramInt);
          break label269;
        }
      }
      finally {}
      try
      {
        apqq.a(this.jdField_a_of_type_Apqq, false);
        if ((apqq.a(this.jdField_a_of_type_Apqq) != null) && (apqq.a(this.jdField_a_of_type_Apqq).isShowing())) {
          apqq.a(this.jdField_a_of_type_Apqq).dismiss();
        }
        apqq.a(this.jdField_a_of_type_Apqq, this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception paramDialogInterface)
      {
        QLog.e("ark.download.ctrl", 1, "ark.dctrl [onClickListener] clicked dismiss exception:", paramDialogInterface);
        continue;
        if (paramInt != 0) {
          continue;
        }
        bcst.a(null, "dc00898", "", "", "0X800AD1E", "0X800AD1E", 3, 0, String.valueOf(apqq.a(this.jdField_a_of_type_Apqq)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [onClickListener] which=", Integer.valueOf(paramInt), ",cost=", Long.valueOf(Math.abs(System.currentTimeMillis() - apqq.a(this.jdField_a_of_type_Apqq))) });
      if (paramInt == 1)
      {
        bcst.a(null, "dc00898", "", "", "0X800AD1D", "0X800AD1D", 3, 0, String.valueOf(apqq.a(this.jdField_a_of_type_Apqq)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      label269:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqr
 * JD-Core Version:    0.7.0.1
 */