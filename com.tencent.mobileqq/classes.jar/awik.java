import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.medalwall.MedalGuideView;

public class awik
  implements DialogInterface.OnDismissListener
{
  public awik(MedalGuideView paramMedalGuideView) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MedalGuideView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awik
 * JD-Core Version:    0.7.0.1
 */