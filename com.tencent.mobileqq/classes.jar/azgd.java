import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime.Status;

class azgd
  implements DialogInterface.OnClickListener
{
  azgd(azfn paramazfn, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bhnv.g(azfn.a(this.jdField_a_of_type_Azfn)))
    {
      this.jdField_a_of_type_Azfn.c();
      QQToast.a(azfn.a(this.jdField_a_of_type_Azfn), 1, 2131718340, 1).a();
      return;
    }
    azfn.a(this.jdField_a_of_type_Azfn, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, true);
    bdll.b(azfn.a(this.jdField_a_of_type_Azfn), "dc00898", "", "", "0X8009DE1", "0X8009DE1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgd
 * JD-Core Version:    0.7.0.1
 */