import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

class atfh
  implements DialogInterface.OnClickListener
{
  atfh(atfg paramatfg, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Atfg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfh
 * JD-Core Version:    0.7.0.1
 */