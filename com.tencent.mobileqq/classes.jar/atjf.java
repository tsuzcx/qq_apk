import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;

public class atjf
  implements DialogInterface.OnKeyListener
{
  public atjf(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      if (this.a.a != null)
      {
        this.a.a.dismiss();
        this.a.a = null;
      }
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjf
 * JD-Core Version:    0.7.0.1
 */