import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

final class arvt
  implements DialogInterface.OnClickListener
{
  arvt(BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bcub.c();
    FloatingScreenPermission.requestPermission(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arvt
 * JD-Core Version:    0.7.0.1
 */