import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;

final class awqs
  implements DialogInterface.OnClickListener
{
  awqs(BaseActivity paramBaseActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bjfq.c();
    FloatingScreenPermission.requestPermission(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqs
 * JD-Core Version:    0.7.0.1
 */