import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class asfr
  implements DialogInterface.OnDismissListener
{
  public asfr(MedalGuideView paramMedalGuideView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MedalGuideView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asfr
 * JD-Core Version:    0.7.0.1
 */