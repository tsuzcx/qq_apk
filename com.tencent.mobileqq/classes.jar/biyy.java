import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.view.Window;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;

public class biyy
{
  private static void b(String paramString)
  {
    int i = 0;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl == null) {}
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 23) {
        if (!Settings.canDrawOverlays(localBaseApplicationImpl)) {
          localBaseApplicationImpl.startActivity(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION"));
        }
      }
      while (i != 0)
      {
        Dialog localDialog = new Dialog(localBaseApplicationImpl, 2131755801);
        localDialog.getWindow().setType(2003);
        localDialog.setContentView(2131558920);
        TextView localTextView = (TextView)localDialog.findViewById(2131365235);
        if (localTextView != null) {
          localTextView.setText("dump文件保存地址");
        }
        localTextView = (TextView)localDialog.findViewById(2131365231);
        if ((localTextView != null) && (paramString != null)) {
          localTextView.setText(paramString);
        }
        localTextView = (TextView)localDialog.findViewById(2131365220);
        if (localTextView != null)
        {
          localTextView.setText(2131690648);
          localTextView.setOnClickListener(new biza(localDialog));
        }
        localTextView = (TextView)localDialog.findViewById(2131365226);
        if (localTextView != null)
        {
          localTextView.setText(2131691602);
          localTextView.setOnClickListener(new bizb(localDialog, localBaseApplicationImpl, paramString));
        }
        localDialog.show();
        return;
        if (localBaseApplicationImpl.checkSelfPermission("android.settings.action.MANAGE_WRITE_SETTINGS") != 0) {
          localBaseApplicationImpl.startActivity(new Intent("android.settings.action.MANAGE_WRITE_SETTINGS"));
        } else {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biyy
 * JD-Core Version:    0.7.0.1
 */