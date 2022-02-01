import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class aqaw
  implements DialogInterface.OnClickListener
{
  aqaw(aqav paramaqav, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = aqav.a(this.jdField_a_of_type_Aqav);
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < aqav.a(this.jdField_a_of_type_Aqav).size())
        {
          aqay localaqay = (aqay)aqav.a(this.jdField_a_of_type_Aqav).get(i);
          if (localaqay == null) {
            break label269;
          }
          localaqay.a.onClick(aqav.a(this.jdField_a_of_type_Aqav), paramInt);
          break label269;
        }
      }
      finally {}
      try
      {
        aqav.a(this.jdField_a_of_type_Aqav, false);
        if ((aqav.a(this.jdField_a_of_type_Aqav) != null) && (aqav.a(this.jdField_a_of_type_Aqav).isShowing())) {
          aqav.a(this.jdField_a_of_type_Aqav).dismiss();
        }
        aqav.a(this.jdField_a_of_type_Aqav, this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception paramDialogInterface)
      {
        QLog.e("ark.download.ctrl", 1, "ark.dctrl [onClickListener] clicked dismiss exception:", paramDialogInterface);
        continue;
        if (paramInt != 0) {
          continue;
        }
        bdla.a(null, "dc00898", "", "", "0X800AD1E", "0X800AD1E", 3, 0, String.valueOf(aqav.a(this.jdField_a_of_type_Aqav)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      QLog.d("ark.download.ctrl", 1, new Object[] { "ark.dctrl [onClickListener] which=", Integer.valueOf(paramInt), ",cost=", Long.valueOf(Math.abs(System.currentTimeMillis() - aqav.a(this.jdField_a_of_type_Aqav))) });
      if (paramInt == 1)
      {
        bdla.a(null, "dc00898", "", "", "0X800AD1D", "0X800AD1D", 3, 0, String.valueOf(aqav.a(this.jdField_a_of_type_Aqav)), "", this.jdField_a_of_type_JavaLangString, "");
        return;
      }
      label269:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqaw
 * JD-Core Version:    0.7.0.1
 */