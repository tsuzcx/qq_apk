import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.bigbrother.JumpConfirmFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;

public class anrg
  implements DialogInterface.OnClickListener
{
  public anrg(JumpConfirmFragment paramJumpConfirmFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    JefsClass.getInstance().a(JumpConfirmFragment.a(this.a), JumpConfirmFragment.a(this.a), JumpConfirmFragment.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anrg
 * JD-Core Version:    0.7.0.1
 */