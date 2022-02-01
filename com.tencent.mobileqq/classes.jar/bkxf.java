import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.1;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

public class bkxf
  implements DialogInterface.OnClickListener
{
  public bkxf(ColorNotePlugin.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.a.a.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxf
 * JD-Core Version:    0.7.0.1
 */