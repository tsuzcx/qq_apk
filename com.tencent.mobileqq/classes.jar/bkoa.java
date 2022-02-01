import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.3;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

public class bkoa
  implements DialogInterface.OnClickListener
{
  public bkoa(ColorNotePlugin.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      this.a.jdField_a_of_type_Aqnr.e();
      if (bknz.a(this.a.this$0))
      {
        paramDialogInterface = new bkob(this);
        if ((bknz.b(this.a.this$0).getAttachedActivity() != null) && ((bknz.c(this.a.this$0).getAttachedActivity() instanceof GameActivity1))) {
          ((GameActivity1)bknz.d(this.a.this$0).getAttachedActivity()).setColorSignAddListener(paramDialogInterface);
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
 * Qualified Name:     bkoa
 * JD-Core Version:    0.7.0.1
 */