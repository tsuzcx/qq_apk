import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

class atay
  implements DialogInterface.OnClickListener
{
  atay(atax paramatax, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Atax);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atay
 * JD-Core Version:    0.7.0.1
 */