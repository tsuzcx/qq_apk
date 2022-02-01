import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.1;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

public class bkxd
  implements DialogInterface.OnClickListener
{
  public bkxd(ColorNotePlugin.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      this.a.jdField_a_of_type_Aqre.e();
      if (bkxc.a(this.a.this$0))
      {
        paramDialogInterface = new bkxe(this);
        if ((bkxc.b(this.a.this$0).getAttachedActivity() != null) && ((bkxc.c(this.a.this$0).getAttachedActivity() instanceof GameActivity1))) {
          ((GameActivity1)bkxc.d(this.a.this$0).getAttachedActivity()).setColorSignAddListener(paramDialogInterface);
        }
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.ok();
        return;
      }
    }
    catch (Exception paramDialogInterface)
    {
      QLog.e("ColorNotePlugin", 1, "show modalView error." + paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxd
 * JD-Core Version:    0.7.0.1
 */