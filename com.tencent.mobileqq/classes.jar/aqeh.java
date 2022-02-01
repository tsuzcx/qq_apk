import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aqeh
  implements DialogInterface.OnClickListener
{
  aqeh(aqeg paramaqeg, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = aqeg.a(this.jdField_a_of_type_Aqeg);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < aqeg.a(this.jdField_a_of_type_Aqeg).size())
        {
          aqej localaqej = (aqej)aqeg.a(this.jdField_a_of_type_Aqeg).get(i);
          if (localaqej == null) {
            break label269;
          }
          localaqej.a.onClick(aqeg.a(this.jdField_a_of_type_Aqeg), paramInt);
          break label269;
        }
      }
      finally {}
      try
      {
        aqeg.a(this.jdField_a_of_type_Aqeg, false);
        if ((aqeg.a(this.jdField_a_of_type_Aqeg) != null) && (aqeg.a(this.jdField_a_of_type_Aqeg).isShowing())) {
          aqeg.a(this.jdField_a_of_type_Aqeg).dismiss();
        }
        aqeg.a(this.jdField_a_of_type_Aqeg, this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception paramDialogInterface)
      {
        QLog.e("ark.download.ctrl", 1, "ark.dctrl [onClickListener] clicked dismiss exception:", paramDialogInterface);
        continue;
        if (paramInt != 0) {
          continue;
        }
        bdll.a(null, "dc00898", "", "", "0X800AD1E", "0X800AD1E", 3, 0, String.valueOf(aqeg.a(this.jdField_a_of_type_Aqeg)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [onClickListener] which=", Integer.valueOf(paramInt), ",cost=", Long.valueOf(Math.abs(System.currentTimeMillis() - aqeg.a(this.jdField_a_of_type_Aqeg))) });
      if (paramInt == 1)
      {
        bdll.a(null, "dc00898", "", "", "0X800AD1D", "0X800AD1D", 3, 0, String.valueOf(aqeg.a(this.jdField_a_of_type_Aqeg)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      label269:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqeh
 * JD-Core Version:    0.7.0.1
 */