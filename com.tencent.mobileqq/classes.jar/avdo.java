import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.widget.Switch;

public class avdo
  implements DialogInterface.OnClickListener
{
  public avdo(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1)
    {
      paramDialogInterface = this.a;
      if (!AppletsSettingFragment.a(this.a))
      {
        AppletsSettingFragment.a(paramDialogInterface, bool);
        AppletsSettingFragment.a(this.a, AppletsSettingFragment.a(this.a));
        this.a.a.cancel();
      }
    }
    while (paramInt != 0) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    AppletsSettingFragment.a(this.a).setChecked(AppletsSettingFragment.a(this.a));
    this.a.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdo
 * JD-Core Version:    0.7.0.1
 */