import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class anql
  implements DialogInterface.OnClickListener
{
  anql(anqk paramanqk, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = anqk.a(this.jdField_a_of_type_Anqk);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < anqk.a(this.jdField_a_of_type_Anqk).size())
        {
          anqn localanqn = (anqn)anqk.a(this.jdField_a_of_type_Anqk).get(i);
          if (localanqn == null) {
            break label269;
          }
          localanqn.a.onClick(anqk.a(this.jdField_a_of_type_Anqk), paramInt);
          break label269;
        }
      }
      finally {}
      try
      {
        anqk.a(this.jdField_a_of_type_Anqk, false);
        if ((anqk.a(this.jdField_a_of_type_Anqk) != null) && (anqk.a(this.jdField_a_of_type_Anqk).isShowing())) {
          anqk.a(this.jdField_a_of_type_Anqk).dismiss();
        }
        anqk.a(this.jdField_a_of_type_Anqk, this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception paramDialogInterface)
      {
        QLog.e("ark.download.ctrl", 1, "ark.dctrl [onClickListener] clicked dismiss exception:", paramDialogInterface);
        continue;
        if (paramInt != 0) {
          continue;
        }
        azqs.a(null, "dc00898", "", "", "0X800AD1E", "0X800AD1E", 3, 0, String.valueOf(anqk.a(this.jdField_a_of_type_Anqk)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [onClickListener] which=", Integer.valueOf(paramInt), ",cost=", Long.valueOf(Math.abs(System.currentTimeMillis() - anqk.a(this.jdField_a_of_type_Anqk))) });
      if (paramInt == 1)
      {
        azqs.a(null, "dc00898", "", "", "0X800AD1D", "0X800AD1D", 3, 0, String.valueOf(anqk.a(this.jdField_a_of_type_Anqk)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      label269:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anql
 * JD-Core Version:    0.7.0.1
 */