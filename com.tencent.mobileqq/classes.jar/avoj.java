import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class avoj
  implements DialogInterface.OnDismissListener
{
  public avoj(MedalGuideView paramMedalGuideView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MedalGuideView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avoj
 * JD-Core Version:    0.7.0.1
 */