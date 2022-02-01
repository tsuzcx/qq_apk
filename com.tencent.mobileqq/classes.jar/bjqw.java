import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.wadl.WadlJsBridgeCallBack.2;

public class bjqw
  implements DialogInterface.OnClickListener
{
  public bjqw(WadlJsBridgeCallBack.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.h = 1;
    bmqk.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjqw
 * JD-Core Version:    0.7.0.1
 */