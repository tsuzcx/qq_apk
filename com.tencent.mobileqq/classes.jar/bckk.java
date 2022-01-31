import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.wadl.WadlJsBridgeCallBack.2;

public class bckk
  implements DialogInterface.OnClickListener
{
  public bckk(WadlJsBridgeCallBack.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.g = 1;
    bgsw.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bckk
 * JD-Core Version:    0.7.0.1
 */