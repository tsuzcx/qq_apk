import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.wadl.WadlJsBridgeCallBack.2;

public class bfsg
  implements DialogInterface.OnClickListener
{
  public bfsg(WadlJsBridgeCallBack.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.g = 1;
    bkis.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfsg
 * JD-Core Version:    0.7.0.1
 */