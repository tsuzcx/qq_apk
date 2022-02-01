import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime.Status;

class ayzw
  implements DialogInterface.OnClickListener
{
  ayzw(ayzg paramayzg, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(ayzg.a(this.jdField_a_of_type_Ayzg)))
    {
      this.jdField_a_of_type_Ayzg.c();
      QQToast.a(ayzg.a(this.jdField_a_of_type_Ayzg), 1, 2131718971, 1).a();
      return;
    }
    ayzg.a(this.jdField_a_of_type_Ayzg, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, true);
    bdla.b(ayzg.a(this.jdField_a_of_type_Ayzg), "dc00898", "", "", "0X8009DE1", "0X8009DE1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzw
 * JD-Core Version:    0.7.0.1
 */