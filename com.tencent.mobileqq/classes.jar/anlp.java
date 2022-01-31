import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class anlp
  implements CompoundButton.OnCheckedChangeListener
{
  public anlp(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.b();
      this.a.a("");
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("IDEDebug is open", new Object[0]));
      return;
    }
    this.a.c();
    this.a.a("close");
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("IDEDebug is close", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlp
 * JD-Core Version:    0.7.0.1
 */