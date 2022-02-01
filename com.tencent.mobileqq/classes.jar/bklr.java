import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;

class bklr
  implements DialogInterface.OnClickListener
{
  bklr(bkll parambkll, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    RemoteHandleManager.getInstance().getSender().downloadTroopPhoto(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bklr
 * JD-Core Version:    0.7.0.1
 */