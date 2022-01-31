import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cooperation.qzone.LocalMultiProcConfig;

public final class bjbu
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBool("qz_safe_mode_no_tip", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbu
 * JD-Core Version:    0.7.0.1
 */