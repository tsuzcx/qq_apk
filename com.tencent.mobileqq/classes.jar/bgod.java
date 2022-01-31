import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import cooperation.qlink.QlinkStandardDialogActivity;

public class bgod
  implements DialogInterface.OnClickListener
{
  public bgod(QlinkStandardDialogActivity paramQlinkStandardDialogActivity, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (this.b) {
        apue.a(this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity, null, 777, false, 0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity.finish();
      return;
      apue.a(this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity, null, 888, false, 0);
      continue;
      paramDialogInterface = new Intent(this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity, ScannerActivity.class);
      paramDialogInterface.putExtra("from", "qlink");
      this.jdField_a_of_type_CooperationQlinkQlinkStandardDialogActivity.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgod
 * JD-Core Version:    0.7.0.1
 */