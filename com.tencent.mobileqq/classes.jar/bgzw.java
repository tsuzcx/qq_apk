import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cooperation.qzone.LocalMultiProcConfig;

public final class bgzw
  implements CompoundButton.OnCheckedChangeListener
{
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    LocalMultiProcConfig.putBool("qz_safe_mode_no_tip", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgzw
 * JD-Core Version:    0.7.0.1
 */