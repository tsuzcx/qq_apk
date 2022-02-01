import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime.Status;

class axtl
  implements DialogInterface.OnClickListener
{
  axtl(axsv paramaxsv, AppRuntime.Status paramStatus, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(axsv.a(this.jdField_a_of_type_Axsv)))
    {
      this.jdField_a_of_type_Axsv.c();
      QQToast.a(axsv.a(this.jdField_a_of_type_Axsv), 1, 2131718582, 1).a();
      return;
    }
    axsv.a(this.jdField_a_of_type_Axsv, this.jdField_a_of_type_MqqAppAppRuntime$Status, this.jdField_a_of_type_Long, true);
    bcef.b(axsv.a(this.jdField_a_of_type_Axsv), "dc00898", "", "", "0X8009DE1", "0X8009DE1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtl
 * JD-Core Version:    0.7.0.1
 */