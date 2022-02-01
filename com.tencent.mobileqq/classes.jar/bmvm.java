import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cooperation.qzone.QzonePluginProxyActivity.4.1;

public class bmvm
  implements DialogInterface.OnDismissListener
{
  public bmvm(QzonePluginProxyActivity.4.1 param1) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.a.this$0.a != null) {
      this.a.this$0.a.onDismiss(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvm
 * JD-Core Version:    0.7.0.1
 */