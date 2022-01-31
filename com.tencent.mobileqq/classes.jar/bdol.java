import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.open.wadl.WadlJsBridgeCallBack.2;

public class bdol
  implements DialogInterface.OnClickListener
{
  public bdol(WadlJsBridgeCallBack.2 param2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.a.g = 1;
    biby.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdol
 * JD-Core Version:    0.7.0.1
 */