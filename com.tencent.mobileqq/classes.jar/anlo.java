import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.ArkIDESettingFragment;

public class anlo
  implements CompoundButton.OnCheckedChangeListener
{
  public anlo(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AboutActivity.a(5);
      if (!this.a.b().equals("close")) {
        this.a.b();
      }
      ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("ArkDebug switch is opened and IDE debug is also open ,state=%s", new Object[] { AboutActivity.b() }));
      ArkAppCenter.a(true);
      return;
    }
    AboutActivity.a(0);
    this.a.c();
    ArkAppCenter.c("ArkApp.DebugOnlineActivity", String.format("ArkDebug switch is closed and IDE debug is also closed,state=%s", new Object[] { AboutActivity.b() }));
    ArkAppCenter.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anlo
 * JD-Core Version:    0.7.0.1
 */