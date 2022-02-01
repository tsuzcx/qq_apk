import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

class awei
  implements DialogInterface.OnClickListener
{
  awei(aweh paramaweh, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    QIPCClientHelper.getInstance().callServer("TogetherBusinessIPCModule", "action_open_start", this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Aweh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awei
 * JD-Core Version:    0.7.0.1
 */