import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.app.BaseActivity;

final class asvk
  implements DialogInterface.OnKeyListener
{
  asvk(BaseActivity paramBaseActivity) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramDialogInterface.dismiss();
      this.a.finish();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvk
 * JD-Core Version:    0.7.0.1
 */