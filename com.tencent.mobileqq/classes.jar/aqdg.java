import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;

final class aqdg
  implements DialogInterface.OnClickListener
{
  aqdg(BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = aqcz.a(this.a.app);
    aqcq.b(this.a, str);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdg
 * JD-Core Version:    0.7.0.1
 */