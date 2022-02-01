import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.ae.play.AEVideoPreviewFragment;

public class boxs
  implements DialogInterface.OnClickListener
{
  public boxs(AEVideoPreviewFragment paramAEVideoPreviewFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = this.a.c();
    paramDialogInterface = new Intent("AEEDITOR_GENERATE_STATUS_DELETE");
    paramDialogInterface.putExtra("delete_position", paramInt);
    paramDialogInterface.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(paramDialogInterface);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxs
 * JD-Core Version:    0.7.0.1
 */