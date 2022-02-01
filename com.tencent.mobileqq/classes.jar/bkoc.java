import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.3;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

public class bkoc
  implements DialogInterface.OnClickListener
{
  public bkoc(ColorNotePlugin.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.a.a.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkoc
 * JD-Core Version:    0.7.0.1
 */